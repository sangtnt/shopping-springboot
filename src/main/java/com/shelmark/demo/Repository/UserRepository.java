package com.shelmark.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shelmark.demo.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	@Query(value="SELECT * FROM user LIMIT :start, :limit", nativeQuery=true)
	List<User> getUsersByPage(Integer start, Integer limit);
	
	@Query("SELECT u FROM User u WHERE u.fullname LIKE %?1%")
	List<User> findByFullname(String fullname);
	
	@Query("SELECT u FROM User u WHERE u.email=?1")
	List<User> findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.phone=?1")
	List<User> findByPhone(String phone);
	
	User findByUsername(String username);
}
