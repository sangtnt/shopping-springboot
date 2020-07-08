package com.shelmark.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class Order_Detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDER_DETAIL_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="CUSORDER_ID")
	private Order order;

	@ManyToOne
	@JoinColumn(name="PRO_ID")
	private Product product;
	
	@Column(name="ORDER_DETAIL_QUANTITY")
	private Long quantity;

	@Column(name="ORDER_DETAIL_SUBTOTAL")
	private Double subTotal;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal() {
		this.subTotal =(double)  Math.round((this.quantity*this.product.getDiscountPrice())*100)/100;
	}
	
}
