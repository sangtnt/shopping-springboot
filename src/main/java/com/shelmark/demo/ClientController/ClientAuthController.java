package com.shelmark.demo.ClientController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Entity.ShoppingCart;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Repository.ShoppingCartRepository;
import com.shelmark.demo.Service.ProductService;

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
}
