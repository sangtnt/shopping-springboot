package com.shelmark.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shelmark.demo.Entity.Order;
import com.shelmark.demo.Repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAllOrder() {
		return orderRepository.findAll();
	}

	public Order getOrderById(Long id) {
		return orderRepository.findById(id).get();
	}

	public List<Order> getOrdersByPage(Integer start, Integer limit) {
		return orderRepository.getOrdersByPage(start, limit);
	}
	public void save(Order order) {
		orderRepository.save(order);
	}
}
