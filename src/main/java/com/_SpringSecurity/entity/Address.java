package com._SpringSecurity.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addId;
	private String street; // The street address (e.g., "123 Main St")
	private String city; // The city (e.g., "New York")
	private String state; // The state or province (e.g., "NY")
	private int postalCode; // The postal or ZIP code (e.g., "10001")
	private String country; // The country (e.g., "USA")

	private String temp;
	
	

	public String getTemp() {
		return temp;
	}



	public void setTemp(String temp) {
		this.temp = temp;
	}



	// Constructor
	public Address(String street, String city, String state, int postalCode, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}
	
		
	
	// Constructor
	public Address() {
		super();
		
	}




	// Getters and Setters
	
	
	public int getAddId() {
		return addId;
	}



	public void setAddId(int addId) {
		this.addId = addId;
	}



	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



	@Override
	public String toString() {
		return "\nAddress [addId=" + addId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", country=" + country + ", temp=" + temp + "]";
	}

	// Optional: toString method for easy display
	
}
