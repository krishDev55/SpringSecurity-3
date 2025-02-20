package com._SpringSecurity.entity;

import java.util.List;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Vendors {

	@Id
	private String venderId;
	@Column(unique = true)
	private String email;
	private String password;
	private String fullname;
	@Column(unique = true)
	private Long mobile;
	private String address;
	private int pincode;
	
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@Lazy(value = false)
	private List<Product> products;
	
	
	public String getVenderId() {
		return venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	public Vendors(String venderId, String email, String password, String fullname, Long mobile, String address,
			int pincode) {
		super();
		this.venderId = venderId;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.mobile = mobile;
		this.address = address;
		this.pincode = pincode;
	}
	public Vendors() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Vendors [venderId=" + venderId + ", email=" + email + ", password=" + password + ", fullname="
				+ fullname + ", mobile=" + mobile + ", address=" + address + ", pincode=" + pincode + "]";
	}
	
	
	
	
}
