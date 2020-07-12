package com.shelmark.demo.Controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shelmark.demo.Entity.Permission;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.ImageService;
import com.shelmark.demo.Service.PermissionService;
import com.shelmark.demo.Service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private PermissionService perService;

	public static String uploadRootPath = System.getProperty("user.dir") + "/src/main/webapp/resources/static/img";
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

	@RequestMapping(value = "/decentralization", method = RequestMethod.GET)
	public String decentralize(@RequestParam String username) {
		return "redirect:/admin/user";
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String delete(@RequestParam String username) {
		User user = userService.findByUsername(username);
		userService.delete(user);
		return "redirect:/admin/user";
	}

	@RequestMapping(value = "/addPermission", method = RequestMethod.GET)
	public ModelAndView addPer(@RequestParam String username) {
		List<Permission> pers = perService.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("decentralization");
		mv.addObject("pers", pers);
		mv.addObject("username", username);
		return mv;
	}

	@RequestMapping(value = "/addPermission", method = RequestMethod.POST)
	public String addPermission(@RequestParam String username, @RequestParam List<Long> per) {
		User user = userService.findByUsername(username);
		Set<Permission> newPers = user.getPermissions();
		for (Long p : per) {
			Permission permission = perService.findById(p);
			newPers.add(permission);
		}
		user.setPermissions(newPers);
		userService.save(user);
		return "redirect:/admin/user";
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public ModelAndView getNewUserView() {
		User user = new User();
		ModelAndView mv = new ModelAndView();
		List<Permission> pers = perService.findAll();
		mv.addObject("pers", pers);
		mv.setViewName("createUser");
		return mv;
	}

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired 
	private ImageService imgService;
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String saveUser(@RequestParam String username, 
							@RequestParam String password, 
							@RequestParam String phone,
							@RequestParam String email,
							@RequestParam String gender,
							@RequestParam String address,
							@RequestParam MultipartFile file,
							@RequestParam Set<Long> pers
	) {
		User user = new User();
		user.setUsername(username);
		user.setEmail(password);
		user.setPassword(passwordEncoder.encode(password));
		Date date = new Date();
		user.setDate(date.getTime());
		user.setEmail(email);
		user.setGender(gender);
		user.setAddress(address);
		String img ="/resources/static/img/avatar/";
		if (!file.isEmpty()) {
			img += imgService.uploadFile(uploadRootPath + "/avatar", file);
		} else {
			img += gender+".png";
		}
		user.setImage(img);
		user.setPermissions(perService.findPermissionsByListId(pers));
		userService.save(user);
		return "redirect:/admin/user";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView getEditView(@RequestParam("username") String username) {
		User user = userService.getUsername(username);
		ModelAndView model = new ModelAndView();
		model.setViewName("editUser");
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("user") User userModel, HttpServletRequest request, Model model) {
		if (userModel.getUsername() == null) {
			String errorMessage = userService.saveUser(userModel);
			model.addAttribute("errorMessage", errorMessage);
			if (errorMessage != null) {
				return "createUser";
			}
		} else {
			userService.saveUser(userModel);
		}
		return "redirect:/admin/user";
	}
}
