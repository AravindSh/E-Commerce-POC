package com.ecommerce.user.dto;

public class UserDto {
	private Integer userid;
	private String address;
	private String city;
	private String firstName;
	private String lastName;
	private String zip;
	private String stateName;
	
	public UserDto(Integer userid, String address, String city, String firstName, String lastName, String zip,
			String stateName) {
		super();
		this.userid = userid;
		this.address = address;
		this.city = city;
		this.firstName = firstName;
		this.lastName = lastName;
		this.zip = zip;
		this.stateName = stateName;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
}
