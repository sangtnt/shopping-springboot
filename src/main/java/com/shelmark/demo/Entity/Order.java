/**
 * 
 */
package com.shelmark.demo.Entity;

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
	
	@Column(name="ORDER_ISACCEPTED")
	private boolean is_Accepted;
	
	@Column(name="ORDER_SUBTOTAL")
	private Long subTotal;
	
	@Column(name="ORDER_DISCOUNT")
	private Long discount;
	
	@Column(name="ORDER_ADDITIONALFEES")
	private Long additionalFees;
	
	@Column(name="ORDER_SHIPPING")
	private Long shipping;
	
	@Column(name="ORDER_GRANDTOTAL")
	private Long grandTotal;
	
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

	public boolean isIs_Accepted() {
		return is_Accepted;
	}

	public void setIs_Accepted(boolean is_Accepted) {
		this.is_Accepted = is_Accepted;
	}

	public Long getSubTotal() {
		return subTotal;
	}

	public void setSubTotal() {
		Long sum=(long) 0;
		for (Order_Detail o: this.order_details) {
			sum+=o.getSubTotal();
		}
		this.subTotal=sum;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public Long getAdditionalFees() {
		return additionalFees;
	}

	public void setAdditionalFees(Long additionalFees) {
		this.additionalFees = additionalFees;
	}

	public Long getShipping() {
		return shipping;
	}

	public void setShipping(Long shipping) {
		this.shipping = shipping;
	}

	public Long getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal() {
		Long sum = this.additionalFees - this.discount +this.grandTotal + this.shipping;
		this.grandTotal=sum;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}
}
