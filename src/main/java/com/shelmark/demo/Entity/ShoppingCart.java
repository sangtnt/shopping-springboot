package com.shelmark.demo.Entity;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CART_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="PRO_ID", nullable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="USER_USERNAME", nullable=false)
	private User user;
	
	@Column(name="CART_DATE")
	private Long date;
	
	@Column(name="CART_QUANTITY")
	private Long quantity;
	
	@Column(name="CART_TOTAL")
	private Long total;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
		Date currentDate = new Date(this.date);
		return df.format(currentDate);
	}

	public void setDate() {
		Date date= new Date();
		this.date = date.getTime();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = this.quantity*this.product.getPrice();
	}
	
}
