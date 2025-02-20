package com._SpringSecurity.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com._SpringSecurity.Dao.EmployeeDao;
import com._SpringSecurity.Dao.VendorDao;
import com._SpringSecurity.Service.EmployeeService;
import com._SpringSecurity.entity.Employee;
import com._SpringSecurity.entity.Vendors;
import com._SpringSecurity.vo.EmployeeLoginPrinciple;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	EmployeeDao empDao;
	
	@Autowired
	VendorDao vendorDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		

		Employee byUsername = empDao.findByUsername(username);

		Optional<Vendors> vendors = vendorDao.findById(username);
		
		
		if(byUsername!=null) {
			return new EmployeeLoginPrinciple(byUsername);
		}
		
		else if( vendors!=null) {
			return new EmployeeLoginPrinciple(vendors.get());
		}
		
		throw new UsernameNotFoundException("User Not Found");
		
	}

}
