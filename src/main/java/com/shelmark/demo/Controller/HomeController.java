package com.shelmark.demo.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Category;
import com.shelmark.demo.Entity.Order;
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
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
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
		DateFormat df = new SimpleDateFormat("dd:MM:yyyy:HH:mm:ss");
		for (Product pro:pros) {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(Long.parseLong(pro.getDate()));
			pro.setDate(df.format(cal.getTime()));
		}
		mv.setViewName("productList");
		mv.addObject("pros", pros);
		return mv;
	}
	
	@RequestMapping(value="/order", method= RequestMethod.GET)
	public ModelAndView getOrder() {
		ModelAndView mv = new ModelAndView();
		List<Order> orders = homeService.getAllOrder();
		mv.setViewName("cusOrder");
		mv.addObject("orders", orders);
		return mv;
	}
}
