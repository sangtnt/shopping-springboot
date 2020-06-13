package com.shelmark.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shelmark.demo.Entity.Permission;

@Repository
public interface PermissionRepository  extends JpaRepository<Permission, Long>{
	
}
