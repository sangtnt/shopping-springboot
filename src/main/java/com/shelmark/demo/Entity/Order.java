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

	
}
