package com.shelmark.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shelmark.demo.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query(value="SELECT * FROM product LIMIT :start, :limit", nativeQuery=true)
	List<Product> getProductsByPage(Integer start, Integer limit);
	
	@Query(value="SELECT * FROM product WHERE cat_id=:catId AND pro_quantity>0", nativeQuery=true)
	List<Product> findByCatId (Long catId);
	
	@Query(value="SELECT * FROM product WHERE cat_id=:catId AND pro_quantity>0 ORDER BY pro_date DESC LIMIT 9", nativeQuery=true)
	List<Product> getProByCatAndDate (Long catId);
	
	@Query(value="SELECT * FROM product WHERE cat_id=:catId AND pro_quantity>0 ORDER BY pro_rating DESC LIMIT 9", nativeQuery=true)
	List<Product> getProByCatAndRating (Long catId);
	
	@Query(value="SELECT * FROM product WHERE cat_id=:catId AND pro_quantity>0 ORDER BY pro_sold DESC LIMIT 9", nativeQuery=true)
	List<Product> getProByCatAndSold (Long catId);
	
	@Query(value="SELECT * FROM product WHERE pro_quantity>0 ORDER BY pro_date DESC LIMIT 9", nativeQuery=true)
	List<Product> getAllProDate ();
	
	@Query(value="SELECT * FROM product WHERE pro_quantity>0 ORDER BY pro_rating DESC LIMIT 9", nativeQuery=true)
	List<Product> getAllProRating ();
	
	@Query(value="SELECT * FROM product WHERE pro_quantity>0 ORDER BY pro_sold DESC LIMIT 9", nativeQuery=true)
	List<Product> getAllProSold ();
	
	@Query(value="SELECT * FROM product WHERE cat_id=:catId AND pro_quantity>0", nativeQuery=true)
	List<Product> findAllByCat (Long catId);
	
	@Query(value="SELECT * FROM product WHERE pro_quantity>0 ORDER BY pro_research DESC LIMIT 12", nativeQuery=true)
	List<Product> getAllMostResearch ();
	
}
