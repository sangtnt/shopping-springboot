/**
 * 
 */
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author TanSang
 *
 */
@Entity
@Table(name="cus_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CUSORDER_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="USER_USERNAME")
	private User user;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ORDER_DETAIL", joinColumns = { @JoinColumn(name = "ORDER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PRODUCT_ID") })
	List<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
