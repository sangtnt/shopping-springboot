package com.shelmark.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {
	@Autowired 
	private UserService userService;
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView getUsers(@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer limit) {
		if (page == null) {
			page = 1;
		}
		if (limit == null) {
			limit = 10;
		}
		ModelAndView mv = new ModelAndView();
		int start = (page - 1) * limit;
		List<User> users = userService.getUserByPage(start, limit);
		mv.setViewName("userList");
		mv.addObject("users", users);
		return mv;
	}
}
