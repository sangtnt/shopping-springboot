package com.shelmark.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shelmark.demo.Repository.UserRepository;
import com.shelmark.demo.Repository.CategoryRepository;
import com.shelmark.demo.Repository.OrderRepository;
import com.shelmark.demo.Repository.ProductRepository;
import com.shelmark.demo.Entity.Category;
import com.shelmark.demo.Entity.Order;
import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Entity.User;

@Service
public class HomeService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@Autowired
	private CategoryRepository catRepository;
	
	public List<Category> getAllCategory(){
		return catRepository.findAll();
	}
	
	@Autowired
	private ProductRepository proRepository;
	
	public List<Product> getAllProduct(){
		return proRepository.findAll();
	}
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getAllOrder(){
		return orderRepository.findAll();
	}
}
