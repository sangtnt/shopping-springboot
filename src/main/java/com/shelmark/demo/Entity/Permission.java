package com.shelmark.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "permission")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSMISSION_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "PERSMISSION_NAME", length = 20)
	private String permissionName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ADMIN_PERMISSION", joinColumns = { @JoinColumn(name = "PERMISSION_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ADMIN_USERNAME") })
	private List<Admin> admins;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public List<Admin> getUsers() {
		return admins;
	}
}