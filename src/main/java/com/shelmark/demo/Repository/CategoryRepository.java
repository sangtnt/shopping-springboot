package com.shelmark.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shelmark.demo.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	@Query(value="SELECT * FROM category LIMIT :start, :limit", nativeQuery=true)
	List<Category> getCatsByPage(Integer start, Integer limit);
}
