package com._SpringSecurity.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com._SpringSecurity.entity.Product;
import java.util.List;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	List<Product> findByVendorId(String vendorId);
	
	
	 Product findByProdIdAndVendorId(int prodId, String vendorId);
	 
	 @Query("SELECT p FROM Product p WHERE p.prodName || p.prodType LIKE %:keyword%")
	    List<Product> findByNameLike(@PathVariable String keyword);
		
}
