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

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRO_ID")
	private Long id;
	
	@Column(name="PRO_NAME")
	private String name;
	
	@Column(name="PRO_IMAGE")
	private String image;
	
	@Column(name="PRO_PRICE")
	private Long price;
	
	@Column(name="PRO_DESCRIPTION")
	private String description;
	
	@Column(name="PRO_QUANTITY")
	private Long quantity;
	
	@Column(name="PRO_DATE")
	private Long date;
	
	@ManyToOne
	@JoinColumn(name="CAT_ID", nullable=false)
	private Category cat;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ORDER_DETAIL", joinColumns = { @JoinColumn(name = "PRODUCT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ORDER_ID") })
	List<Order> orders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
