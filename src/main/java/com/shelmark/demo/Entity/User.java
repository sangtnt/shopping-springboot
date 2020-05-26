package com.shelmark.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name="USER_USERNAME", length = 30)
	private String username;
	
	@Column(name="USER_PASSWORD")
	private String password;
	
	@Column(name="USER_FULLNAME")
	private String fullname;
	
	@Column(name="USER_EMAIL")
	private String email;
	
	@Column(name="USER_PHONE")
	private String phone;
	
	@Column(name="USER_GENDER")
	private String gender;
	
	@Column(name="USER_BALANCE")
	private Long balance;
	
	@Column(name= "USER_STATUS")
	private boolean status;
	
	@Column(name= "USER_IMAGE")
	private String image;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "USER_PERMISSION", 
			joinColumns = { 
					@JoinColumn(name = "USER_USERNAME") 
			}, 
			inverseJoinColumns = {
					@JoinColumn(name = "PERMISSION_ID") 
			})
	private List<Permission> permissions;
	
	@OneToMany(mappedBy="user")
	private List<Order> orders;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getBalance() {
		return balance;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
