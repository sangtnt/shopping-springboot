package com.shelmark.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Category;
import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.HomeService;

@Controller
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="/user", method= RequestMethod.GET)
	public ModelAndView getUsers() {
		ModelAndView mv = new ModelAndView();
		List<User> users = homeService.getAllUsers();
		mv.setViewName("userList");
		mv.addObject("users", users);
		return mv;
	}
	
	@RequestMapping(value="/category", method= RequestMethod.GET)
	public ModelAndView getCategory() {
		ModelAndView mv = new ModelAndView();
		List<Category> cats = homeService.getAllCategory();
		mv.setViewName("categoryList");
		mv.addObject("cats", cats);
		return mv;
	}
	
	@RequestMapping(value="/product", method= RequestMethod.GET)
	public ModelAndView getProduct() {
		ModelAndView mv = new ModelAndView();
		List<Product> pros = homeService.getAllProduct();
		mv.setViewName("productList");
		mv.addObject("pros", pros);
		return mv;
	}
}
