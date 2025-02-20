package com._SpringSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._SpringSecurity.Dao.AddressDao;
import com._SpringSecurity.entity.Address;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;

	public Address getAddressById(int id) {
	
		return addressDao.findById(id).get();
	}
}
