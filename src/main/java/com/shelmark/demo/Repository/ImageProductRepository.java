package com.shelmark.demo.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shelmark.demo.Entity.ImageProduct;

@Repository
public interface ImageProductRepository extends JpaRepository<ImageProduct, Long>{
	@Transactional
	@Modifying
	@Query("DELETE FROM ImageProduct imgPro WHERE imgPro.product.id=:id")
	public void deleteByProductId(Long id);
}
