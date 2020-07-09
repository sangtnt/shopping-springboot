package com.shelmark.demo.ClientController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shelmark.demo.Entity.Category;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.CategoryService;
import com.shelmark.demo.Service.UserService;

@ControllerAdvice
public class GlobalControllerAdvice {
	@Autowired 
	private CategoryService catService;
	
	@Autowired 
	private UserService userService;
	@ModelAttribute
    public void addGlobalAttr(HttpServletRequest request) {
		HttpSession session =request.getSession(true); // true == allow create
			List<Category> cats = catService.getAllCategory();
			session.setAttribute("cats", cats);
			User u = (User) session.getAttribute("user");
			if(u!=null) {
				User user = userService.findByUsername(u.getUsername());
				session.setAttribute("userPers", user.getPermissions());
			}
    }
}
