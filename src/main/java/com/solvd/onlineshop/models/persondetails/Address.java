package com.solvd.onlineshop.models.persondetails;

public class Address {

	private String streetName;
	private String streetNumber;
	private Integer houseNumber;
	private String zipCode;
	private String cityName;

	public Address() {
	}

	public Address(String streetName, String streetNumber, Integer houseNumber, String zipCode,
			String cityName) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.cityName = cityName;
	}

	public Address(String streetName, String streetNumber, String zipCode, String cityName) {
		this.streetNumber = streetName;
		this.streetName = streetNumber;
		this.zipCode = zipCode;
		this.cityName = cityName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber ) {
		this.streetNumber = streetNumber;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getyCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
