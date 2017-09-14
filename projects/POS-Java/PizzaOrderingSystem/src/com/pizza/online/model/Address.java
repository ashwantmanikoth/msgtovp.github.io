package com.pizza.online.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String houseNo;
	private String streetName;
	private String location;
	private String city;
	private Integer pincode;

	@Column(name = "house_no", nullable = false, length = 100)
	public String getHouseNo() {
		return houseNo;
	}

	@Column(name = "street_name", nullable = false, length = 100)
	public String getStreetName() {
		return streetName;
	}

	@Column(name = "location", nullable = false, length = 100)
	public String getLocation() {
		return location;
	}

	@Column(name = "city", nullable = false, length = 100)
	public String getCity() {
		return city;
	}

	@Column(name = "pincode", nullable = false)
	public Integer getPincode() {
		return pincode;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

}
