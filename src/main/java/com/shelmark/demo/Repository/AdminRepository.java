package com.shelmark.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shelmark.demo.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{
	Admin findByUsername(String username);
}
