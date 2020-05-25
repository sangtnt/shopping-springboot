package com.shelmark.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shelmark.demo.Repository.UserRepository;
import com.shelmark.demo.Entity.User;

@Service
public class HomeService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
}
