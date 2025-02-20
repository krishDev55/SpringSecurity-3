package com._SpringSecurity.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._SpringSecurity.Common;
import com._SpringSecurity.Dao.ProductDao;
import com._SpringSecurity.entity.Orders;
import com._SpringSecurity.entity.Product;

@Service
public class ProductService {

	@Autowired
	 ProductDao productDao;
	
	
	
	public Product getProductById(int id ) {
		Optional<Product> byId = productDao.findById(id);
		if(byId.isPresent()) {
			return byId.get();
		}
		else {
			throw new NoSuchElementException(" Product Id Not VAlid..");
		}
	}
	
	public List<Product> getAllProduct(){
		List<Product> all = productDao.findAll();
		return all;
	}
	
	
	public Product saveProduct(Product product) {	
		return productDao.save(product);
	}
	
	
	public List<Product> getProductByVendorId(String vendorId){	
		List<Product> products = productDao.findByVendorId(vendorId);
		System.out.println("All product is : "+products);
		return products ;
	}
	
	
	public Set<Product> randomProductList(List<Product> list){
		Set<Product> allProduct= new HashSet<>();
	
	for(int i=0 ; i<list.size(); i++) {
		int genrateId = Common.genrateId()%list.size();
		Product product = list.get(genrateId);
		allProduct.add(product);
		
	}
	return allProduct;
}
	
	
	public List<Product> searchProduct(String search) {
		
//		List<Product> all = productDao.findAll();
//		
//		return all.stream().filter(e-> e.getProdName().equals(search)).collect(Collectors.toSet());
		
		return productDao.findByNameLike(search);
	}
	
}
