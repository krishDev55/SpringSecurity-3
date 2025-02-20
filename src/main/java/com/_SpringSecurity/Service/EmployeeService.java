package com._SpringSecurity.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com._SpringSecurity.Dao.EmployeeDao;
import com._SpringSecurity.entity.Address;
import com._SpringSecurity.entity.Employee;
import com._SpringSecurity.security.JWTService;

@Service
public class EmployeeService {
	
	@Autowired
	AuthenticationManager authManager;

		@Autowired
		EmployeeDao employeeDao;
		
		@Autowired
		JWTService jwtService;
		
		private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);
		
		public Employee saveEmployee(Employee employee) {	
			employee.setPassword(encoder.encode(employee.getPassword()));
		
			return employeeDao.save(employee);
		}
		
		public Employee findEmployeeById(int id) {	
//			
			return employeeDao.findById(id).get();
		}
		
		public List<Employee> findAllEmployees() {						
			return employeeDao.findAll();
		}

		
		public Employee updateEmployee(Employee emp) {
			int id = emp.getId();
			
			Employee emp1 = findEmployeeById(id);
			emp.setUsername(emp1.getUsername());
			emp.setPassword(emp1.getPassword());
			
			return employeeDao.save(emp);
		}
		
		public Employee updateEmployeeAddress(int empId,Address address) {
			System.out.println("Address is : "+address);
			Employee emp = findEmployeeById(empId);
			System.out.println("Employee is: "+emp);
			List<Address> list = emp.getAddress();
			boolean flag=true;
			
		 for(Address ad :list) {
			 System.out.println("count : "+list.size()+"     "+ad.getTemp() +"    "+ address.getTemp() +" ---- "+ad.getTemp().equals(address.getTemp()));
			 	if(ad.getTemp().equals(address.getTemp())) {
			 		address.setAddId(ad.getAddId());
			 		System.out.println("Address is 1: "+address);
			 		flag=false;
			 		break;
			 	}
		 }
		 if(flag) {
			 list.add(address);
			 emp.setAddress(list);
			 System.out.println("Employee is 1 : "+emp);
			 return employeeDao.save(emp); 
		 }
		throw new NoSuchElementException("dataNotSave");
		}
		
		
		
		public String varify(Employee emp ) {
			Authentication authenticate = 
							authManager.authenticate(
										new UsernamePasswordAuthenticationToken(emp.getUsername(), emp.getPassword()));
			if(authenticate.isAuthenticated()) {
				return jwtService.generateToken(emp.getUsername()) ;
			}
			
//			if(temp!=null && temp.getPassword().equals(emp.getPassword())) {
//				
//				return "user login done:";
//			}
			
			return "User not found....!!!";
		}

		public Employee findEmployeeByUserName(String userName) {
			
//			
			return employeeDao.findByUsername(userName);
			
			
		}
		
}

