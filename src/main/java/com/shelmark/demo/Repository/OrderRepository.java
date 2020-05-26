package com.shelmark.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shelmark.demo.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	@Query(value="SELECT * FROM cus_order LIMIT :start, :limit", nativeQuery=true)
	List<Order> getOrdersByPage(Integer start, Integer limit);
}
