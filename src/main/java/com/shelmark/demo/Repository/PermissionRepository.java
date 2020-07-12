package com.shelmark.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shelmark.demo.Entity.Permission;

@Repository
public interface PermissionRepository  extends JpaRepository<Permission, Long>{
	@Query("SELECT p FROM Permission p WHERE p.permissionName=?1")
	public List<Permission> findByName(String name);
}
