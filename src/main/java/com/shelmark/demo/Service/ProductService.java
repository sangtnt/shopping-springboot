package com.shelmark.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository proRepository;

	public List<Product> getAllProduct() {
		return proRepository.findAll();
	}

	public List<Product> getProductsByPage(Integer start, Integer limit) {
		return proRepository.getProductsByPage(start, limit);
	}
	
	public List<Product> getProductsByCat(Long catId) {
		return proRepository.findByCatId(catId);
	}
	
	public Product findById(Long id) {
		return proRepository.findById(id).get();
	}
	
	public void delete(Product pro) {
		proRepository.delete(pro);
	}
	
	public void save(Product pro) {
		proRepository.save(pro);
	}
}
