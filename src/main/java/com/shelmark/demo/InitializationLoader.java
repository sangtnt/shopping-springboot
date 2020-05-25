//package com.shelmark.demo;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.shelmark.demo.Service.AdminService;
//
//@Component
//public class InitializationLoader {
//	@Autowired
//	private AdminService adminService;
//
//	@PostConstruct
//	public void init() {
//		try {
//			if (adminService.getByUserName("tansang") == null) {
//				adminService.createDefaultAdmin();
//			}
//		} catch (Exception e) {
//// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
