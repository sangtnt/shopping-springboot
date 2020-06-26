package com.shelmark.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository proRepository;
	
	public List<Product> findAll() {
		return proRepository.findAll();
	}

	public List<Product> getProductsByPage(Integer start, Integer limit) {
		return proRepository.getProductsByPage(start, limit);
	}
	
	public List<Product> getProByOrderAndDate(Long catId) {
		return proRepository.getProByCatAndDate(catId);
	}
	
	public List<Product> getProByCatAndRating(Long catId) {
		return proRepository.getProByCatAndRating(catId);
	}
	public List<Product> getProByCatAndSold(Long catId) {
		return proRepository.getProByCatAndSold(catId);
	}
	
	public List<Product> getAllProDate() {
		return proRepository.getAllProDate();
	}
	
	public List<Product> getAllProRating() {
		return proRepository.getAllProRating();
	}
	public List<Product> getAllProSold() {
		return proRepository.getAllProSold();
	}
	
	public List<Product> findByCat(Long catId) {
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
	
	public List<Product> getListByListId(List<Long> id){
		List<Product> products = new ArrayList<>();
		for (Long i: id) {
			products.add(proRepository.findById(i).get());
		}
		return products;
	}
	
	public List<Product> getAllMostResearch(){
		return proRepository.getAllMostResearch();
	}
}
