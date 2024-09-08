package com.edu.rest.api.test.bean;

public class ArcesiumAddress {
	
	private String suite;
	
	private String street;
	
	private String zipcode;
	
	private String city;
	
	private ArcesiumGeo geo;

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ArcesiumGeo getGeo() {
		return geo;
	}

	public void setGeo(ArcesiumGeo geo) {
		this.geo = geo;
	}

}
