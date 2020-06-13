package com.shelmark.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shelmark.demo.Entity.ShoppingCart;
import com.shelmark.demo.Repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	@Autowired
	private ShoppingCartRepository cartRepo;
	
	public void save(ShoppingCart cart) {
		cartRepo.save(cart);
	}
}
