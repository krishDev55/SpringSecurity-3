package com._SpringSecurity.entity;

import org.hibernate.annotations.IdGeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private String prodImage;
	private String prodName;
	
	private double prodPrice;
	private int prodQuantity;
	private int empId;
	private int prodId;
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getProdImage() {
		return prodImage;
	}
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getProdQuantity() {
		return prodQuantity;
	}
	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
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
	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	public Cart(int cartId, String prodImage, String prodName, double prodPrice, int prodQuantity, int empId,
			int prodId) {
		super();
		this.cartId = cartId;
		this.prodImage = prodImage;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.empId = empId;
		this.prodId = prodId;
	}
	
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", prodImage=" + prodImage + ", prodName=" + prodName + ", prodPrice="
				+ prodPrice + ", prodQuantity=" + prodQuantity + ", empId=" + empId + ", prodId=" + prodId + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
