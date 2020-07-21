package com.shelmark.demo.ClientController;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.SetupSession;
import com.shelmark.demo.Entity.Order;
import com.shelmark.demo.Entity.Order_Detail;
import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Entity.ShoppingCart;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Entity.UserRatePro;
import com.shelmark.demo.Entity.UserReviewPro;
import com.shelmark.demo.Repository.OrderDetailRepository;
import com.shelmark.demo.Repository.UserRateProRepository;
import com.shelmark.demo.Repository.UserReviewProRepository;
import com.shelmark.demo.Service.ImageService;
import com.shelmark.demo.Service.OrderService;
import com.shelmark.demo.Service.ProductService;
import com.shelmark.demo.Service.ShoppingCartService;
import com.shelmark.demo.Service.UserService;

@Controller
@RequestMapping("/auth")
public class ClientAuthController {
	@Autowired
	private ProductService proService;

	@Autowired
	private ShoppingCartService cartService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderDetailRepository orderDetailRepo;
	
	@Autowired
	private UserReviewProRepository userReviewPro;
	
	public static String uploadRootPath = System.getProperty("user.dir") + "/src/main/webapp/resources/static/img";
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCart(@RequestParam List<Long> quantity, @RequestParam List<Long> proId,
			HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		for (int i = 0; i < quantity.size(); i++) {
			boolean check = false;
			Product pro = proService.findById(proId.get(i));
			ShoppingCart cart = new ShoppingCart();
			for (ShoppingCart c : user.getCartItems()) {
				if (c.getProduct().equals(pro)) {
					if (pro.getQuantity() < c.getQuantity() + quantity.get(i)) {
						c.setQuantity(pro.getQuantity());
					} else {
						c.setQuantity(c.getQuantity() + quantity.get(i));
					}
					cart.setDate();
					cartService.save(c);
					check = true;
					break;
				}
			}
			if (!check) {
				cart.setUser(user);
				cart.setDate();
				cart.setQuantity(quantity.get(i));
				cart.setProduct(pro);
				cart.setTotal();
				cartService.save(cart);
				SetupSession.setHeader(user.getCartItems().size() + quantity.size(), user.getProLiked().size(),
						request);
			}
		}
		if (!referer.contains("order")) {
			return "redirect:" + referer;
		} else {
			return "redirect:/auth/viewCart";
		}
	}

	@RequestMapping(value = "/viewCart", method = RequestMethod.GET)
	public ModelAndView viewCart(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		mv.addObject("user", user);
		mv.setViewName("cart");
		return mv;
	}

	@RequestMapping(value = "/deleteCartItem", method = RequestMethod.GET)
	public String deleteCartItem(@RequestParam Long itemId, HttpServletRequest request) {
		ShoppingCart cart = cartService.findById(itemId);
		cartService.delete(cart);
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		SetupSession.setHeader(user.getCartItems().size() - 1, user.getProLiked().size(), request);
		return "redirect:/auth/viewCart";
	}

	@RequestMapping(value = "/autoSaveCart", method = RequestMethod.POST)
	public String saveCart(@RequestParam List<Long> cart, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		int i = 0;
		for (ShoppingCart item : user.getCartItems()) {
			item.setQuantity(cart.get(i));
			item.setTotal();
			cartService.save(item);
			i++;
		}
		return "redirect:/auth/viewCart";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("checkout");
		return mv;
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String submitOrder(@RequestParam String fullname, @RequestParam String city, @RequestParam String district,
			@RequestParam String address, @RequestParam String phone, @RequestParam List<Long> proId,
			@RequestParam List<Long> quantity, @RequestParam String payment, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		System.out.print(payment);
		// set Order
		Order order = new Order();
		order.setStatus(0);
		order.setFullname(fullname);
		order.setAddress(city + " " + district + " " + address);
		order.setPhone(phone);
		order.setUser(user);
		order.setDate();
		order.setShipping( 30.0);
		order.setDiscount( 0.0);
		order.setAdditionalFees( 0.0);
		orderService.save(order);
		List<Product> pros = proService.getListByListId(proId);
		Double subTotal = 0.0;
		// set Order_Detail
		for (int index = 0; index < pros.size(); index++) {
			Order_Detail orderDetail = new Order_Detail();
			orderDetail.setOrder(order);
			orderDetail.setProduct(pros.get(index));
			orderDetail.setQuantity(quantity.get(index));
			orderDetail.setSubTotal();
			subTotal += orderDetail.getQuantity() * orderDetail.getProduct().getDiscountPrice();
			orderDetailRepo.save(orderDetail);
			Product pro = pros.get(index);
			pro.setQuantity(pro.getQuantity() - quantity.get(index));
			pro.setSold(pro.getSold() + quantity.get(index));
			proService.save(pro);
		}
		order.setSubTotal(subTotal);
		order.setGrandTotal();
		orderService.save(order);
		Set<ShoppingCart> cartItems = user.getCartItems();
		for (Product p : pros) {
			for (ShoppingCart cartItem : cartItems) {
				if (cartItem.getProduct().equals(p)) {
					cartService.delete(cartItem);
					cartItems.remove(cartItem);
					break;
				}
			}
		}
		SetupSession.setHeader(cartItems.size(), user.getProLiked().size(), request);
		return "redirect:/";
	}

	@RequestMapping(value = "/like", method = RequestMethod.GET)
	public String like(@RequestParam Long proId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		Product pro = proService.findById(proId);
		Set<Product> pros = user.getProLiked();
		if (pros.contains(pro)) {
			pros.remove(pro);
		} else {
			pros.add(pro);
		}
		user.setProLiked(pros);
		userService.save(user);
		SetupSession.setHeader(user.getCartItems().size(), user.getProLiked().size(), request);
		String referer = request.getHeader("referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value = "/viewProLike", method = RequestMethod.GET)
	public ModelAndView viewProLike(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("proLike");
		mv.addObject("pros", user.getProLiked());
		return mv;
	}

	@Autowired
	private ImageService imgService;
	
	@RequestMapping(value = "/review", method=RequestMethod.POST)
	public String addReview(@RequestParam String username, @RequestParam Long proId, @RequestParam String review,
			HttpServletRequest request,
			MultipartFile file) {
		User user = userService.findByUsername(username);
		Product pro = proService.findById(proId);
		UserReviewPro reviewPro = new UserReviewPro();
		reviewPro.setUser(user);
		reviewPro.setDate();
		String img;
		if (!file.isEmpty()) {
			img = imgService.uploadFile(uploadRootPath + "/review", file);
			reviewPro.setImage("/resources/static/img/review/" + img);
		} else {
			reviewPro.setImage("");
		}
		reviewPro.setProduct(pro);
		reviewPro.setReview(review);
		userReviewPro.save(reviewPro);
		String referer = request.getHeader("referer");
		return "redirect:" + referer;
	}
	
	@Autowired
	private UserRateProRepository uRateProRepo;
	
	@RequestMapping(value = "/rating", method = RequestMethod.POST)
	public String rate(@RequestParam Long proId, @RequestParam Long rating, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		Product pro = proService.findById(proId);
		UserRatePro uRatePro = uRateProRepo.findByUser(user);
		if(uRatePro!=null) {
			uRatePro.setRating(rating);
			uRateProRepo.save(uRatePro);
		}
		else{
			UserRatePro uR = new UserRatePro();
			uR.setProduct(pro);
			uR.setRating(rating);
			uR.setUser(user);
			uRateProRepo.save(uR);
		}
		pro.setRating();
		proService.save(pro);
		String referer = request.getHeader("referer");
		return "redirect:" + referer;
	}
}
