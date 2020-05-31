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
	
	public List<User> getUserByPage(Integer start, Integer limit){
		return userRepository.getUsersByPage(start, limit);
	}
	
	@Autowired
	private CategoryRepository catRepository;
	
	public List<Category> getAllCategory(){
		return catRepository.findAll();
	}
	public List<Category> getCatsByPage(Integer start, Integer limit){
		return catRepository.getCatsByPage(start, limit);
	}
	public Category getCatById(Long id){
		return catRepository.findById(id).get();
	}
	public void update(Category cat){
		catRepository.save(cat);
	}
	public void delete(Category cat){
		catRepository.delete(cat);
	}
	public void addCat(Category cat){
		catRepository.save(cat);
	}
	
	@Autowired
	private ProductRepository proRepository;
	
	public List<Product> getAllProduct(){
		return proRepository.findAll();
	}
	public List<Product> getProductsByPage(Integer start, Integer limit){
		return proRepository.getProductsByPage(start, limit);
	}
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getAllOrder(){
		return orderRepository.findAll();
	}
	public Order getOrderById(Long id){
		return orderRepository.findById(id).get();
	}
	public List<Order> getOrdersByPage(Integer start, Integer limit){
		return orderRepository.getOrdersByPage(start, limit);
	}
}
