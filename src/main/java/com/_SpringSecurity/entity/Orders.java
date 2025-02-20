package com._SpringSecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {
	@Id
   private String orderId;
	private String productImg;
	private String  productName;
	private int quentity;
	private double price;
	private String time;
	private String status;
	private int  empId;
	private int prodId;
	
	@OneToOne(targetEntity = Address.class)
	private Address address;
	
	
	
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuentity() {
		return quentity;
	}
	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
	
	
	
	
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	
	
	
	
	
	
	
	public Orders(String orderId, String productImg, String productName, int quentity, double price, String time,
			String status, int empId, int prodId) {
		super();
		this.orderId = orderId;
		this.productImg = productImg;
		this.productName = productName;
		this.quentity = quentity;
		this.price = price;
		this.time = time;
		this.status = status;
		this.empId = empId;
		this.prodId = prodId;
	}
	
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\nOrders [orderId=" + orderId + ", productImg=" + productImg + ", productName=" + productName
				+ ", quentity=" + quentity + ", price=" + price + ", time=" + time + ", status=" + status + ", empId="
				+ empId + ", prodId=" + prodId + ", address=" + address + "]";
	}
	
	
	
	
	
}
