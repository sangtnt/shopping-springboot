package com.shelmark.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shelmark.demo.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
