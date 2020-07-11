package com.shelmark.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shelmark.demo.Entity.Permission;
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
			Permission admin = perService.findById((long) 1);
			Permission userPer = perService.findById((long) 2);
			Permission proManager = perService.findById((long) 3);
			Permission orderManager = perService.findById((long) 4);
			if (admin==null||userPer==null||proManager==null||orderManager==null) {
				perService.createDefaultPermission();
			}
			User user = userService.findByUsername("admin");
			if (user==null) {
				userService.createDefaultUser();
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
