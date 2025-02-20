package com._SpringSecurity.vo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com._SpringSecurity.Service.EmployeeService;
import com._SpringSecurity.entity.Employee;
import com._SpringSecurity.entity.Vendors;


public class EmployeeLoginPrinciple implements UserDetails{
	
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6768888871230l;
	private Employee emp;
	private Vendors vendor;

	public EmployeeLoginPrinciple(Employee emp) {
		this.emp=emp;
	}
	public EmployeeLoginPrinciple(Vendors vendor) {
		this.vendor=vendor;
	}
	
	public EmployeeLoginPrinciple(String userName) {
		
////		List<Employee> employeeByUserName = employeeService.findEmployeeByUserName(userName);
//		
//		
//		System.out.println("Employee : "+this.emp);
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton( new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
			if(emp==null) {
				return vendor.getPassword();
			}
			else {
				
				return emp.getPassword();
			}
	}

	@Override
	public String getUsername() {
		if(emp==null) {
			return vendor.getVenderId();
		}
		else {
			return emp.getUsername();
		}
	}

}
