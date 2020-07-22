package com.shelmark.demo.ClientController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.ImageService;
import com.shelmark.demo.Service.UserService;

@Controller
@RequestMapping("/user")
public class ClientUserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/viewShop", method = RequestMethod.GET)
	public ModelAndView showShop(@RequestParam String username) {
		User user = userService.findByUsername(username);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("shopDetail");
		return mv;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView showProfile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = "";
		ModelAndView mv = new ModelAndView();
		try {
			User u = (User) session.getAttribute("user");
			username = u.getUsername();
		} catch (Exception e) {
			mv.setViewName("login");
			return mv;
		}
		String referer="/";
		if( request.getHeader("referer")!=null) {
			referer=request.getHeader("referer");
		}
		if(!referer.contains("profile")) {
			session.setAttribute("referer",referer);
		}
		User user = userService.findByUsername(username);
		mv.addObject("user", user);
		mv.setViewName("profile");
		return mv;
	}

	@Autowired
	private ImageService imgService;
	
	public static String uploadRootPath = System.getProperty("user.dir") + "/src/main/webapp/resources/static/img";
	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public String editProfile(@RequestParam String fullname,
							@RequestParam String phone,
							@RequestParam String address, 
							@RequestParam String email, 
							@RequestParam MultipartFile file,
							HttpServletRequest request
	) {
		HttpSession session = request.getSession();
		User u =(User) session.getAttribute("user");
		User user = userService.findByUsername(u.getUsername());
		user.setPhone(phone);
		user.setAddress(address);
		user.setEmail(email);
		user.setFullname(fullname);
		if (!file.isEmpty()) {
			String img ="/resources/static/img/avatar/"+ imgService.uploadFile(uploadRootPath + "/avatar", file);
			user.setImage(img);
		}
		userService.save(user);
		return "redirect:/user/profile";
	}
}
