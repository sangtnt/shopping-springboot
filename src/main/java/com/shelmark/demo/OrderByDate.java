package com.shelmark.demo;

import java.util.Comparator;

import com.shelmark.demo.Entity.Order;

public class OrderByDate implements Comparator<Order> {
	@Override
	public int compare(Order o1, Order o2) {
		return o2.getDate().compareTo(o1.getDate());
	}
}
