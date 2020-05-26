package com.shelmark.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Repository.UserRepository;

@Transactional
@Service
public class UserService {
	@Autowired
	private UserRepository userReposity;

	public User findByUserName(String userName) {
		return userReposity.findByUsername(userName);
	}

}