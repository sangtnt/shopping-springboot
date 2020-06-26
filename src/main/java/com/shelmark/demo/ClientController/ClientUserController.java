package com.shelmark.demo.ClientController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.UserService;

@Controller
@RequestMapping("/user")
public class ClientUserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/viewShop", method = RequestMethod.GET)
	public ModelAndView showProfile(@RequestParam String username) {
		User user = userService.findByUsername(username);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);s
		mv.setViewName("shopDetail");
		return mv;
	}
}
