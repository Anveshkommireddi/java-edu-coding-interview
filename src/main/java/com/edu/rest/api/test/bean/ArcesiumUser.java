package com.edu.rest.api.test.bean;

public class ArcesiumUser {
	
	private int id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String website;
	
	private ArcesiumCompany company;
	
	private ArcesiumAddress address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public ArcesiumCompany getCompany() {
		return company;
	}

	public void setCompany(ArcesiumCompany company) {
		this.company = company;
	}

	public ArcesiumAddress getAddress() {
		return address;
	}

	public void setAddress(ArcesiumAddress address) {
		this.address = address;
	}

}
