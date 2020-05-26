package com.shelmark.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shelmark.demo.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUsername(String username);
	
	@Query("SELECT * FROM")
	List<User> getUsersByPage(Long page);
	
}
