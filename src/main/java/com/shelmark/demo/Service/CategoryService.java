package com.shelmark.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shelmark.demo.Entity.Category;
import com.shelmark.demo.Repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository catRepository;

	public List<Category> getAllCategory() {
		return catRepository.findAll();
	}
	
	public List<Category> findByName(String name) {
		return catRepository.findByName(name);
	}

	public List<Category> getCatsByPage(Integer start, Integer limit) {
		return catRepository.getCatsByPage(start, limit);
	}

	public Category getCatById(Long id) {
		return catRepository.findById(id).get();
	}

	public void update(Category cat) {
		catRepository.save(cat);
	}

	public void delete(Category cat) {
		catRepository.delete(cat);
	}

	public void addCat(Category cat) {
		catRepository.save(cat);
	}
}
