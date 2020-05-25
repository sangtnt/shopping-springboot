package com.shelmark.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

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
	
	@OneToMany(mappedBy="user")
	List<CusOrder> cusOrders;
	
	@Column(name= "USER_STATUS")
	private boolean status;

	public void setCusOrders(List<CusOrder> cusOrders) {
		this.cusOrders = cusOrders;
	}

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

	public List<CusOrder> getCusOrders() {
		return cusOrders;
	}

	public void setOrders(List<CusOrder> cusOrders) {
		this.cusOrders = cusOrders;
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
	
}
