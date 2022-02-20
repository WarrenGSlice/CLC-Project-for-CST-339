package com.gcuCLC.model;

/** * * * * * * * * * * * * * * *
 * CST-339 CLC Milestone Project
 * Order Management Application *
 * Created by Warren Peterson,* *
 * Jonathan Levan, Ivan Gudino  *
 * * * * * * * * * * * * * * * **/ 

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gcuCLC.entity.UserEntity;

// User Properties for use with RegistrationController
public class User {
	
	@NotNull(message="UserName is a Required Field")
	@Size(min=1, max=32, message="UserName Must be Between 1 & 32 characters")
	private String username;
	
	@NotNull(message="Password is a Required Field")
	@Size(min=1, max=32, message="Password Must be Between 1 & 32 characters")
	private String password;
	
	@NotNull(message="Please Enter a First Name")
	@Size(min=1, max=32, message="First Name Must be Between 1 & 32 characters")
    private String firstName;
	
	@NotNull(message="Please Enter a Last Name")
	@Size(min=1, max=32, message="Last Name Name Must be Between 1 & 32 characters")
    private String lastName;
	
	@NotNull(message="Email is a Required Field")
	@Size(min=1, max=64, message="Email Must be Between 1 & 32 characters")
    private String email;
	
	@NotNull(message="Business Name is a Required Field")
    private String businessName;

	@NotNull(message="Address is a Required Field")
    private String address;

	@NotNull(message="City is a Required Field")
    private String city;

	@NotNull(message="Zip is a Required Field")
    private String zip;

	@NotNull(message="Phone is a Required Field")
	@Size(min=1, max=11, message="Phone Number must be 9 digits")
    private String phone;

	@NotNull(message="State is a Required Field")
	private String state;	

	public User(String username, String password, String firstName, String lastName, String email, String businessName, String address, String city, String zip, String phone, String state) 
	{
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.businessName = businessName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.state = state;
	}

	public User() {
    	
    }

	public User(UserEntity user)
	{
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

	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getBusinessName() 
	{
		return this.businessName;
	}

	public void setBusinessName(String businessName) 
	{
		this.businessName = businessName;
	}

	public String getAddress() 
	{
		return this.address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getCity() 
	{
		return this.city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getZip() 
	{
		return this.zip;
	}

	public void setZip(String zip) 
	{
		this.zip = zip;
	}
	
	 
    public String getUsername() {
    	return username;
	}
	 
    public void setUsername(String username) {
    	this.username = username;
	}
	    
    public String getPassword() {
    	return password;
	}
	 
    public void setPassword(String password) {
    	this.password = password;
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

    public String getEmail() {
    	return email;
	}
	 
    public void setEmail(String email) {
    	this.email = email;
	}
    
    public String getPhone() {
    	return phone;
    }
	
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phone=" + phone + "]";
	}
}