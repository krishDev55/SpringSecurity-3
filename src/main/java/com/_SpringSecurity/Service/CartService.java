package com._SpringSecurity.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._SpringSecurity.Dao.CartDao;
import com._SpringSecurity.entity.Cart;

@Service
public class CartService {

	@Autowired
	CartDao cartDao;
	
	public Cart saveCart(Cart cart) {		
		Cart save = cartDao.save(cart);
		return save;
	}
	public List<Cart> findByEmpId(int empId){
		
		return cartDao.findByEmpId(empId);
	}
	
	
	public  String deleteCartById(int cartId) {
		try{
			cartDao.deleteById(cartId);
			return "Cart Delete";
		}
		catch (Exception e) {
			throw new  NoSuchElementException("this Id not present .....");
		}
	}
	
	public Cart findCartByCartId(int id) {
		// TODO Auto-generated method stub
		Optional<Cart> byId = cartDao.findById(id);
		if(byId.isPresent()) {
			return byId.get();
		}
		throw new NoSuchElementException("This Cart Value Not Present...");
	}
}
