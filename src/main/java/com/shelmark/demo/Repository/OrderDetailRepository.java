package com.shelmark.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shelmark.demo.Entity.Order_Detail;

@Repository
public interface OrderDetailRepository extends JpaRepository<Order_Detail, Long>{

}
