package com.shelmark.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shelmark.demo.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
