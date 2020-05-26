package com.shelmark.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shelmark.demo.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
