package com.gcuCLC.entity;

import java.util.Random;

import com.gcuCLC.model.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("USER")
public class UserEntity {

	@Id
	Long userId;
	
	@Column("USER_NAME")
	String username;
	
	@Column("FIRST_NAME")
	String firstName;
	
	@Column("LAST_NAME")
	String lastName;
	
	@Column("ADDRESS")
	String address;
	
	@Column("CITY")
	String city;
	
	@Column("STATE")
	String state;
	
	@Column("ZIP")
	String zip;
	
	@Column("EMAIL")
	String email;
	
	@Column("PASSWORD")
	String password;
	
	@Column("BUSINESS_NAME")
	String businessName;

	@Column("PHONE")
	String phone;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(User user)
	{
		Random r = new Random();
		userId = r.nextLong();
		username = user.getUsername();
		password = user.getPassword();
		firstName = user.getFirstName();
		lastName = user.getLastName();
		address = user.getAddress();
		city = user.getCity();
		state = user.getState();
		zip = user.getZip();
		email = user.getEmail();
		businessName = user.getBusinessName();
		phone = user.getPhone();
	}

	public UserEntity(Long userId, String username, String firstName, String lastName, String address, String city,
			String state, String zip, String email, String password, String businessName, String phone) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.password = password;
		this.businessName = businessName;
		this.phone = phone;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	
}