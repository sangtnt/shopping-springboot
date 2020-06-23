package com.shelmark.demo.Entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private Long date;
	
	@OneToMany(mappedBy = "product")
	private List<User_Rate_Pro> ratings;
	
	@Column(name="PRO_SOLD")
	private Long sold;
	
	@Column(name="PRO_RATING")
	private Long rating;
	
	@Column(name="PRO_SHIPPING")
	private String shipping;
	
	@Column(name="PRO_BRAND")
	private String brand;
	
	@Column(name="PRO_ORIGIN")
	private String origin;
	
	@Column(name="PRO_RESEARCH")
	private Long research;
	
	@ManyToOne
	@JoinColumn(name="CAT_ID", nullable=false)
	private Category cat;
	
	@OneToMany(mappedBy = "product")
	private Set<ShoppingCart> cartItems = new HashSet<ShoppingCart>();
	
	@ManyToOne
	@JoinColumn(name="USER_USERNAME", nullable=false)
	private User user;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<Order_Detail> order_details;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<User_Review_Pro> reviews;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_LIKE_PRO", joinColumns = { @JoinColumn(name = "PRO_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "USER_USERNAME") })
	private Set<Product> proLiked;
	
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
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
		Date currentDate = new Date(this.date);
		return df.format(currentDate);
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

	public List<Order_Detail> getOrder_details() {
		return order_details;
	}

	public void setOrder_details(List<Order_Detail> order_details) {
		this.order_details = order_details;
	}

	public Long getSold() {
		return sold;
	}

	public void setSold(Long sold) {
		this.sold = sold;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public List<User_Review_Pro> getReviews() {
		return reviews;
	}

	public void setReviews(List<User_Review_Pro> reviews) {
		this.reviews = reviews;
	}

	
	public Set<Product> getProLiked() {
		return proLiked;
	}

	public void setProLiked(Set<Product> proLiked) {
		this.proLiked = proLiked;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User_Rate_Pro> getRatings() {
		return ratings;
	}

	public void setRatings(List<User_Rate_Pro> ratings) {
		this.ratings = ratings;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating() {
		long result=0;
		if (this.ratings.size()!=0) {
			for (User_Rate_Pro r: this.ratings) {
				result+=r.getRating();
			}
			result=Math.round(result/this.ratings.size());
			this.rating = result;
		}
		else {
			this.rating=(long) 0;
		}
	}

	public Set<ShoppingCart> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<ShoppingCart> cartItems) {
		this.cartItems = cartItems;
	}

	public Long getResearch() {
		return research;
	}

	public void setResearch(Long research) {
		this.research = research;
	}
	
	
}
