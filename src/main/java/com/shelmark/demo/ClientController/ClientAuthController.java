package com.shelmark.demo.ClientController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.SetupSession;
import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Entity.ShoppingCart;
import com.shelmark.demo.Entity.User;
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
	private UserService userService;
	@RequestMapping(value="/addToCart", method = RequestMethod.POST)
	public String addToCart(@RequestParam Long quantity,@RequestParam Long proId, HttpServletRequest request) {
		Product pro = proService.findById(proId); 
		ShoppingCart cart = new ShoppingCart();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		String referer = request.getHeader("Referer");
		for (ShoppingCart c : user.getCartItems()) {
			if (c.getProduct().equals(pro)) {
				c.setQuantity(c.getQuantity()+quantity);
				cart.setDate();
				cartService.save(c);
				return "redirect:"+ referer;
			}
		}
		cart.setUser(user);
		cart.setDate();
		cart.setQuantity(quantity);
		cart.setProduct(pro);
		
		cartService.save(cart);
		SetupSession.setHeader(user.getCartItems().size()+1, user.getProLiked().size(), request);
		return "redirect:"+ referer;
	}

	@RequestMapping(value="/viewCart", method = RequestMethod.GET)
	public ModelAndView viewCart(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		mv.addObject("user", user);
		mv.setViewName("cart");
		return mv;
	}
	
	@RequestMapping(value="/deleteCartItem", method = RequestMethod.GET)
	public String deleteCartItem(@RequestParam Long itemId, HttpServletRequest request) {
		ShoppingCart cart = cartService.findById(itemId);
		cartService.delete(cart);
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		SetupSession.setHeader(user.getCartItems().size()-1, user.getProLiked().size(), request);
		return "redirect:/auth/viewCart";
	}
	
	@RequestMapping(value="/autoSaveCart", method = RequestMethod.POST)
	public String saveCart(@RequestParam List<Long> cart, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		int i = 0;
		for (ShoppingCart item : user.getCartItems()) {
			item.setQuantity(cart.get(i));
			cartService.save(item);
			i++;
		}
		return "redirect:/auth/viewCart";
	}
}
