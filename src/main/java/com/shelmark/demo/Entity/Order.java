/**
 * 
 */
package com.shelmark.demo.Entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade=CascadeType.ALL)
	private List<Order_Detail> order_details;
	
	@Column(name="ORDER_ADDRESS")
	private String address;
	
	@Column(name="ORDER_CUS_FULLNAME")
	private String fullname;
	
	@Column(name="ORDER_CUS_PHONE")
	private String phone;
	
	/*
	 * status 
	 * 0: wait to be accepted 
	 * 1: accepted 
	 * 2: wrap 
	 * 3: delivery 
	 * 4: received 
	 * 5: canceled
	 */
	@Column(name="ORDER_STATUS")
	private Integer status;
	
	@Column(name="ORDER_SUBTOTAL")
	private Double subTotal;
	
	@Column(name="ORDER_DISCOUNT", columnDefinition="Decimal(10) default 0")
	private Double discount;
	
	@Column(name="ORDER_ADDITIONALFEES", columnDefinition="Decimal(10) default 0")
	private Double additionalFees;
	
	@Column(name="ORDER_SHIPPING", columnDefinition="Decimal(10) default 0")
	private Double shipping;
	
	@Column(name="ORDER_GRANDTOTAL")
	private Double grandTotal;
	
	@Column(name="ORDER_DATE")
	private Long date;
	
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

	public List<Order_Detail> getOrder_details() {
		return order_details;
	}

	public void setOrder_details(List<Order_Detail> order_details) {
		this.order_details = order_details;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal() {
		Double sum= 0.0;
		for (Order_Detail o: this.order_details) {
			sum+=o.getSubTotal();
		}
		this.subTotal=sum;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal=subTotal;
	}
	
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getAdditionalFees() {
		return additionalFees;
	}

	public void setAdditionalFees(Double additionalFees) {
		this.additionalFees = additionalFees;
	}

	public Double getShipping() {
		return shipping;
	}

	public void setShipping(Double shipping) {
		this.shipping = shipping;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal() {
		Double sum = this.additionalFees - this.discount +this.subTotal + this.shipping;
		this.grandTotal=(double) Math.round(sum*100)/100;
	}

	public String getDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
		Date currentDate = new Date(this.date);
		return df.format(currentDate);
	}

	public void setDate() {
		Date date = new Date();
		this.date= date.getTime();
	}
	
	public void cancelOrder() {
		this.status=4;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
