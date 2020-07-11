package com.shelmark.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void save(User user){
		userRepository.save(user);
	}
	
	public List<User> getUserByPage(Integer start, Integer limit){
		return userRepository.getUsersByPage(start, limit);
	}
	
	public String delete(User user) {
		userRepository.delete(user);
		return null;
		
	}
	
	public String  deleteId(String username) {
		userRepository.deleteById(username);
		return null;
	}
	

	public String saveUser(User cat) {
		if(cat.getUsername() == null || cat.getUsername().isEmpty()) {
			return "User name must be filled";
		}
		userRepository.save(cat);
		return null;
	}
	
	public User getUsername(String username) {
		User user = userRepository.getOne(username);

		return user;
		
	}
}