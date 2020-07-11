package com.shelmark.demo.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shelmark.demo.Entity.Permission;
import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Repository.UserRepository;

@Service
//@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PermissionService perService;
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
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	public void createDefaultUser() {
		String password = passwordEncoder.encode("123456");
		User user = new User();
		user.setUsername("admin");
		user.setImage("/resources/static/img/avatar/admin.jpg");
		user.setPassword(password);
		Set<Permission> pers = new HashSet<Permission>();
		pers.add(perService.findById((long) 1));
		pers.add(perService.findById((long) 2));
		user.setPermissions(pers);
		userRepository.save(user);
	}
}