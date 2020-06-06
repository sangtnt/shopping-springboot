package com.shelmark.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Repository.UserRepository;

@Service
//@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User findByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User findByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	public List<User> getUserByPage(Integer start, Integer limit){
		return userRepository.getUsersByPage(start, limit);
	}

}