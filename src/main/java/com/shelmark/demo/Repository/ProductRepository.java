package com.shelmark.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shelmark.demo.Entity.Product;
import com.shelmark.demo.Entity.User;

public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query(value="SELECT * FROM product LIMIT :start, :limit", nativeQuery=true)
	List<Product> getProductsByPage(Integer start, Integer limit);
}
