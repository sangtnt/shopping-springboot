package com.shelmark.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="image_product")
public class ImageProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IMAGE_ID")
	private Long id;
	
	@Column(name="IMAGE")
	private String image;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="PRO_ID", nullable=false)
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
