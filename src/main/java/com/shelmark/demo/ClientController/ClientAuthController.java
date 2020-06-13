package com.shelmark.demo.ClientController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Entity.ShoppingCart;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Repository.ShoppingCartRepository;
import com.shelmark.demo.Repository.UserRepository;
import com.shelmark.demo.Service.ProductService;
import com.shelmark.demo.Service.UserService;

@Controller
@RequestMapping("/auth")
public class ClientAuthController {
	@Autowired
	private ProductService proService;
	
	@Autowired
	private ShoppingCartRepository cartRepo;
	
	@RequestMapping(value="/addToCart", method = RequestMethod.POST)
	public String addToCart(@RequestParam Long quantity,@RequestParam Long proId, HttpServletRequest request) {
		Product pro = proService.findById(proId);
		ShoppingCart cart = new ShoppingCart();
		cart.setProduct(pro);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		cart.setUser(user);
		cart.setDate();
		cart.setQuantity(quantity);
		cartRepo.save(cart);
		String referer = request.getHeader("Referer");
		return "redirect:"+ referer;
	}
	
	@Autowired
	private UserService userService;
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
}
