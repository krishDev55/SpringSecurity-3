package com._SpringSecurity.Service;



import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._SpringSecurity.Common;
import com._SpringSecurity.Dao.OrdersDao;
import com._SpringSecurity.Dao.ProductDao;
import com._SpringSecurity.entity.Orders;
import com._SpringSecurity.entity.Product;

@Service
public class OrderService {
		@Autowired
		OrdersDao orderDao;
		
		@Autowired
		 ProductDao productDao;
		
	public  Orders saveOrder(Orders order) {
		 
		order.setOrderId("ord_"+Common.genrateId());
		LocalDateTime ldt= LocalDateTime.now();
		String substring = ldt.toString().substring(11,16)+" - "+ldt.toString().substring(0, 10) ;
		
		order.setTime(substring);
		order.setStatus("Prossing");
		
		Product product = productDao.findById(order.getProdId()).get();
		
		System.out.println("Order is : "+order);
		System.out.println("Product is : "+product);
		
		if(product.getProdQuantity()>=order.getQuentity()) {
		 product.setProdQuantity(product.getProdQuantity()-order.getQuentity());
		 		productDao.save(product);
				return orderDao.save(order);
			
		}
//		
		throw new  NoSuchElementException("Only availeble product  are "+product.getProdQuantity());
	}
	
	public Orders getOrderById(String id) {
		Optional<Orders> byId = orderDao.findById(id);
		if(byId.isPresent()) {
			return byId.get();
		}
		throw new NoSuchElementException(" Not a Valid  order Id "); 
	}
	
	public List<Orders> findOrdersByEmpId(int id){			
		return orderDao.findByEmpId(id);
	}
	
	
	public String deleteOrderById(String orderId) {
		try {
			orderDao.deleteById(orderId);
			return "order delete";
		
		} catch (Exception e) {
			throw new NoSuchElementException("order-Id not Present..");
		}
		
	}
		
	public List<Orders> getAll(){
		
		List<Orders> collect = orderDao.findAll().stream().
									filter(f-> productDao.findById(f.getProdId()).isPresent())
									.collect(Collectors.toList());
		return collect;
	} 
	
	

	public List<Orders> findOrdersByVendorId(String vendorId) {
		
		List<Orders> orders = orderDao.findAll();
		List<Orders> list= new ArrayList<>();
			Iterator<Orders> itr = orders.iterator();
			
		while(itr.hasNext()) {
				Orders order = itr.next();
						int prodId2 = order.getProdId();
				Product product = productDao.findById(prodId2).get();
				if(vendorId.equals(product.getVendorId())) {
					list.add(order);
				}
		}
		
	
		return list;
	}
	
	public Orders updateOrderStatusByOrderId(String ordersId,String status) {
		Orders order = getOrderById(ordersId);
		order.setStatus(status);
		
		return orderDao.save(order);
	}
}
