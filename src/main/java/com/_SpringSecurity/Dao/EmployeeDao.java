package com._SpringSecurity.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._SpringSecurity.entity.Employee;

@Repository
public interface EmployeeDao  extends JpaRepository<Employee, Integer>{

	public Employee findByUsername(String userName);
}
