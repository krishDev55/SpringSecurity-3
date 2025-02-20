package com._SpringSecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prodId;
	private String prodName;
	private String prodType;
	private String prodInfo;
	private double prodPrice;
	private int prodQuantity;
	private String prodImage;
	private String vendorId;
	
	
	
//	private Vendors vendor;    
	

	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getProdInfo() {
		return prodInfo;
	}
	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
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
	public String getProdImage() {
		return prodImage;
	}
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	

	public String getVendorId() {
		return vendorId;
	}


	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	
	

//	public Vendors getVendor() {
//		return vendor;
//	}
//
//
//	public void setVendor(Vendors vendor) {
//		this.vendor = vendor;
//	}


	public Product(int prodId, String prodName, String prodType, String prodInfo, double prodPrice, int prodQuantity,
			String prodImage, String vendorId) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodInfo = prodInfo;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodImage = prodImage;
		this.vendorId = vendorId;
	}


	@Override
	public String toString() {
		return "\nProduct [prodId=" + prodId + ", prodName=" + prodName + ", prodType=" + prodType + ", prodInfo="
				+ prodInfo + ", prodPrice=" + prodPrice + ", prodQuantity=" + prodQuantity + ", prodImage=" + prodImage
				+ ", vendorId=" + vendorId + "]";
	}


	
	
	
	
	
	
	
}
