package com.shelmark.demo.Service;

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
}
