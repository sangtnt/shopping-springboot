package com.shelmark.demo.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private String date;
	
	@ManyToOne
	@JoinColumn(name="CAT_ID", nullable=false)
	private Category cat;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<Order_Detail> order_details;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public List<Order_Detail> getOrder_details() {
		return order_details;
	}

	public void setOrder_details(List<Order_Detail> order_details) {
		this.order_details = order_details;
	}

	
}
