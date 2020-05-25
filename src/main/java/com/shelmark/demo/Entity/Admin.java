package com.shelmark.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@Column(name="ADMIN_USERNAME", length=30)
	private String username;
	
	@Column(name="ADMIN_PASSWORD")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "ADMIN_PERMISSION", 
			joinColumns = { 
					@JoinColumn(name = "ADMIN_USERNAME") 
			}, 
			inverseJoinColumns = {
					@JoinColumn(name = "PERMISSION_ID") 
			})
	private List<Permission> permissions;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	
}
