package com._SpringSecurity.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._SpringSecurity.entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
	
	public List<Cart> findByEmpId(int empId);

}
