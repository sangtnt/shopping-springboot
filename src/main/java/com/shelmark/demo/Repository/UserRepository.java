package com.shelmark.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shelmark.demo.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	@Query(value="SELECT * FROM user LIMIT :start, :limit", nativeQuery=true)
	List<User> getUsersByPage(Integer start, Integer limit);
	
	User findByUsername(String username);
}
