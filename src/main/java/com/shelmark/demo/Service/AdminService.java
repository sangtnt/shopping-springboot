package com.shelmark.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shelmark.demo.Entity.Admin;
import com.shelmark.demo.Repository.AdminRepository;

@Transactional
@Service
public class AdminService {
	@Autowired
	private AdminRepository adminReposity;

	public Admin findByUserName(String userName) {
		return adminReposity.findByUsername(userName);
	}

}