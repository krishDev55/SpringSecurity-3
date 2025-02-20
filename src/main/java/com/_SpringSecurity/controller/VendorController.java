package com._SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._SpringSecurity.Service.VendorService;
import com._SpringSecurity.entity.Vendors;

@RestController
@RequestMapping("/v1/vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@GetMapping("/getById/{vendorId}")
	public Vendors getVendorById(@PathVariable String vendorId) {
		 Vendors vendors = vendorService.getVendorsById(vendorId).get();	
		
		
		return vendors;
	}
	
	@GetMapping("/getAll")
	public List<Vendors> getAllVendor() {
		 List<Vendors> vendors = vendorService.getAllVendors();
		
		System.out.println("Alll vender is : "+vendors);
		
		return vendors;
	}
	
}
