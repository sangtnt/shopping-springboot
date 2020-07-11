package com.shelmark.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shelmark.demo.Entity.Permission;
import com.shelmark.demo.Repository.PermissionRepository;

@Service
public class PermissionService {
	@Autowired 
	private PermissionRepository permissionRepo;
	
	public Permission findById(Long id) {
		return permissionRepo.findById(id).get();
	}
	
	public List<Permission> findAll() {
		return permissionRepo.findAll();
	}
	
	public void save(Permission per) {
		permissionRepo.save(per);
	}
	
	public void delete(Permission per) {
		permissionRepo.delete(per);
	}
	
	public void createDefaultPermission() {
		Permission admin = new Permission();
		admin.setId((long) 1);
		admin.setPermissionName("ADMIN");
		Permission user = new Permission();
		user.setId((long) 2);
		user.setPermissionName("USER");
		Permission proManager = new Permission();
		proManager.setId((long) 3);
		proManager.setPermissionName("PRODUCT MANAGER");
		Permission orderManager = new Permission();
		orderManager.setId((long) 4);
		orderManager.setPermissionName("ORDER MANAGER");
		
		permissionRepo.save(admin);
		permissionRepo.save(user);
		permissionRepo.save(proManager);
		permissionRepo.save(orderManager);
	}
}
