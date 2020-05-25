package com.shelmark.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.HomeService;

@Controller
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="/users", method= RequestMethod.GET)
	public ModelAndView getUsers() {
		ModelAndView mv = new ModelAndView();
		List<User> users = homeService.getAllUsers();
		mv.setViewName("userList");
		mv.addObject("users", users);
		return mv;
	}
}
