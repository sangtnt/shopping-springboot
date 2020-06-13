package com.shelmark.demo.Wrapper;

import java.util.List;

import com.shelmark.demo.Entity.ShoppingCart;

public class ShoppingCartWrapper {
	List<Long> quantity;

	public List<Long> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Long> quantity) {
		this.quantity = quantity;
	}
}
