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
@Table(name="user_rate_pro")
public class User_Rate_Pro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_RATE_PRO_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="USER_USERNAME", nullable=false)
	private User user;	
	
	@ManyToOne
	@JoinColumn(name="PRO_ID", nullable=false)
	private User product;
	
	@Column(name="rating")
	private Long rating;

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

	public User getProduct() {
		return product;
	}

	public void setProduct(User product) {
		this.product = product;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}
	
	
}
