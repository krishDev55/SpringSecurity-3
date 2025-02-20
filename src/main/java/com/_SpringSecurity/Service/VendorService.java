package com._SpringSecurity.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com._SpringSecurity.Common;
import com._SpringSecurity.Dao.VendorDao;
import com._SpringSecurity.entity.Vendors;

@Service
public class VendorService {
	@Autowired
	VendorDao vendorDao;
	
	private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);
	
		public Optional<Vendors> getVendorsById(String id) {
			Optional<Vendors> byId = vendorDao.findById(id);
			
				return byId;
			
		}
		
		public List<Vendors> getAllVendors(){
			return vendorDao.findAll();
		}
		
		public Vendors getVendorsByEmail(String email) {
		Vendors vendor = vendorDao.findByEmail(email);
			if(vendor!=null) {
				return vendor;
			}
			throw new NoSuchElementException("Vendor Email is not  present");
		}
		
		public Vendors saveVendor(Vendors vendors) {
			vendors.setVenderId("V"+Common.genrateId());
			vendors.setPassword( encoder.encode(vendors.getPassword()));
			
			return vendorDao.save(vendors);
		}
		
		public Vendors updateVendor(Vendors vendors) {
			Vendors vendor1 = getVendorsById(vendors.getVenderId()).get();
			
					vendors.setPassword(vendor1.getPassword());
					vendors.setEmail(vendor1.getEmail());
			return vendorDao.save(vendors);
		}
		
		public Vendors saveAndUpdateVendor(Vendors vendor) {
			
			return vendorDao.save(vendor);
		}
}
