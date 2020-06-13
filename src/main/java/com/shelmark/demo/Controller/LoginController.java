package com.shelmark.demo.Controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Permission;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.PermissionService;
import com.shelmark.demo.Service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PermissionService perService;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session, HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		session.setAttribute("referer", referer);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView createAcc(@RequestParam String phone, @RequestParam String password) {
		ModelAndView mv = new ModelAndView();
		User user = new User();
		password = passwordEncoder.encode(password);
		user.setPassword(password);
		user.setUsername(phone);
		user.setPhone(phone);
		List<Permission> pers = user.getPermissions();
		pers.add(perService.findById((long) 2));
		user.setPermissions(pers);
		userService.save(user);
		mv.setViewName("login");
		return mv;
	}
}
