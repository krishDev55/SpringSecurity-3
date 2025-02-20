package com._SpringSecurity.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._SpringSecurity.entity.Orders;

import jakarta.persistence.criteria.Order;

import java.util.List;


@Repository
public interface OrdersDao extends JpaRepository<Orders, String> {

	public List<Orders> findByEmpId(int empId);

}
