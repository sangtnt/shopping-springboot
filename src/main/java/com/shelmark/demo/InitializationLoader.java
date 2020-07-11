package com.shelmark.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Service.PermissionService;
import com.shelmark.demo.Service.UserService;

@Component
public class InitializationLoader {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PermissionService perService;
	
	@PostConstruct
	public void init() {
		try {
			User user = userService.findByUsername("admin");
			if (user==null) {
				userService.createDefaultAdmin();
			}
			user = userService.findByUsername("proManager");
			if (user==null) {
				userService.createDefaultProManager();
			}
			user = userService.findByUsername("orderManager");
			if (user==null) {
				userService.createDefaultOrderManager();
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
