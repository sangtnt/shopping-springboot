package com.shelmark.demo.Service;

import java.util.Date;
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
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void createDefaultAdmin() {
		String password = passwordEncoder.encode("123456");
		User admin = new User();
		admin.setUsername("admin");
		admin.setImage("/resources/static/img/avatar/admin.jpg");
		admin.setPassword(password);
		Date date = new Date();
		admin.setDate(date.getTime());
		Set<Permission> pers = new HashSet<Permission>();
		pers.add(perService.findById((long) 1));
		admin.setPermissions(pers);
		userRepository.save(admin);
	}
	
	public void createDefaultProManager() {
		String password = passwordEncoder.encode("123456");
		Date date = new Date();
		User proManager = new User();
		proManager.setUsername("proManager");
		proManager.setImage("/resources/static/img/avatar/admin.jpg");
		proManager.setPassword(password);
		proManager.setDate(date.getTime());
		Set<Permission> proPers = new HashSet<Permission>();
		proPers.add(perService.findById((long) 3));
		proManager.setPermissions(proPers);
		userRepository.save(proManager);
	}
	
	public void createDefaultOrderManager() {
		String password = passwordEncoder.encode("123456");
		Date date = new Date();
		User orderManager = new User();
		orderManager.setUsername("orderManager");
		orderManager.setImage("/resources/static/img/avatar/admin.jpg");
		orderManager.setPassword(password);
		orderManager.setDate(date.getTime());
		Set<Permission> orderPers = new HashSet<Permission>();
		orderPers.add(perService.findById((long) 4));
		orderManager.setPermissions(orderPers);
		userRepository.save(orderManager);
	}
}