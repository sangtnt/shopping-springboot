package com.shelmark.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shelmark.demo.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUsername(String username);

	
}
