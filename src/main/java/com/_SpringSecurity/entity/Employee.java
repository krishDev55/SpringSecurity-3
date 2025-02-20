package com._SpringSecurity.entity;

import java.util.List;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private String fullName;
	private Long mobileNo;
//	private String address;
	private int pincode;
	
	
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@Lazy(value = true)
	private List<Address> address;
	
				
			
   
	
	
	public List<Address> getAddress() {		   
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String username, String password, String fullName, Long mobileNo, 
			int pincode) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.mobileNo = mobileNo;
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", fullName=" + fullName
				+ ", mobileNo=" + mobileNo + ", address=" + address + ", pincode=" + pincode + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
