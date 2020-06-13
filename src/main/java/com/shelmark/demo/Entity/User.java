package com.shelmark.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
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
	
	@Column(name="USER_FULLNAME", nullable=true)
	private String fullname;
	
	@Column(name="USER_EMAIL", nullable=true)
	private String email;
	
	@Column(name="USER_PHONE", nullable=true)
	private String phone;
	
	@Column(name="USER_GENDER", nullable=true)
	private String gender;
	
	@Column(name="USER_BALANCE", nullable=true)
	private Long balance;
	
	@Column(name= "USER_STATUS", nullable=true)
	private boolean status;
	
	@Column(name= "USER_IMAGE", nullable=true)
	private String image;
	
	@Column(name= "USER_ADDRESS", nullable=true)
	private String address;
	
	@Column(name= "USER_DATE", nullable=true)
	private Long date;
	
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
	
	@OneToMany(mappedBy="user")
	private List<User_Review_Pro> reviews;
	
	@OneToMany(mappedBy="user")
	private List<Product> products;
	
	@OneToMany(mappedBy = "user")
	private List<ShoppingCart> cartItems;

	@OneToMany(mappedBy = "user")
	private List<User_Rate_Pro> ratings;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_LIKE_PRO", joinColumns = { @JoinColumn(name = "USER_USERNAME") }, inverseJoinColumns = {
			@JoinColumn(name = "PRO_ID") })
	private List<Product> proLiked;
	
	public User() {
		this.permissions = new ArrayList<Permission>();
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

	public List<User_Review_Pro> getReviews() {
		return reviews;
	}

	public void setReviews(List<User_Review_Pro> reviews) {
		this.reviews = reviews;
	}

	public List<Product> getProLiked() {
		return proLiked;
	}

	public void setProLiked(List<Product> proLiked) {
		this.proLiked = proLiked;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public List<User_Rate_Pro> getRatings() {
		return ratings;
	}

	public void setRatings(List<User_Rate_Pro> ratings) {
		this.ratings = ratings;
	}

	public List<ShoppingCart> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<ShoppingCart> cartItems) {
		this.cartItems = cartItems;
	}
	
}
