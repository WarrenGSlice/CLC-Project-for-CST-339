package com.gcuCLC.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gcuCLC.entity.UserEntity;

/**
 * ---------------------------------------------------------------------------
 * Name      : Group H1
 * Members   : W. Peterson, J. LeVan, and I. Gudino
 * Date      : 2022-03-11
 * Class     : CST-339 Java Programming III
 * Professor : Brandon Bass
 * Assignment: Milestone - CLC Group Assignment
 * Disclaimer: This is our own work
 * ---------------------------------------------------------------------------
 * Description:
 * 1. Model - User
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 * 03/12/2022 Team                Documentation
 *
 */

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

	/**
	 * User Constructor Method
	 * @param username - String
	 * @param password - String
	 * @param firstName - String
	 * @param lastName - String
	 * @param email - String
	 * @param businessName - String
	 * @param address - String
	 * @param city - String
	 * @param zip - String
	 * @param phone - String
	 * @param state - String
	 */
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

	/**
	 * User Constructor Method
	 */
	public User() {
    	
    }

	/**
	 * User Constructor Method
	 * @param user - Auto Injected User Entity Entity
	 */
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

	//----------GETTERS & SETTERS------------\\
	
	/**
	 * getter - State
	 * @return State
	 */
	public String getState()
	{
		return this.state;
	}

	/**
	 * Setter - State
	 * @param state - String
	 */
	public void setState(String state)
	{
		this.state = state;
	}

	/**
	 * Getter - Business Name
	 * @return Name Of business
	 */
	public String getBusinessName() 
	{
		return this.businessName;
	}

	/**
	 * Setter - Name Of Business
	 * @param businessName - String
	 */
	public void setBusinessName(String businessName) 
	{
		this.businessName = businessName;
	}

	/**
	 * Getter - Home Address
	 * @return Home address
	 */
	public String getAddress() 
	{
		return this.address;
	}

	/**
	 * Setter - Home Address
	 * @param address - String
	 */
	public void setAddress(String address) 
	{
		this.address = address;
	}

	/**
	 * Getter - City
	 * @return City
	 */
	public String getCity() 
	{
		return this.city;
	}

	/**
	 * Setter - City
	 * @param city - String
	 */
	public void setCity(String city) 
	{
		this.city = city;
	}

	/**
	 * Getter - Zip Code
	 * @return Zip Code
	 */
	public String getZip() 
	{
		return this.zip;
	}

	/**
	 * Setter - Zip Code
	 * @param zip - String
	 */
	public void setZip(String zip) 
	{
		this.zip = zip;
	}
	
	/**
	 * Getter - UserName 
	 * @return UserName
	 */
    public String getUsername() {
    	return username;
	}
	 
    /**
     * Setter - UserName
     * @param username - String
     */
    public void setUsername(String username) {
    	this.username = username;
	}
	    
    /**
     * Getter - Password
     * @return Password
     */
    public String getPassword() {
    	return password;
	}
	 
    /**
     * Setter - Password
     * @param password - String
     */
    public void setPassword(String password) {
    	this.password = password;
	}
	 
    /**
     * getter - First Name
     * @return First Name
     */
    public String getFirstName() {
    	return firstName;
	}
	 
    /**
     * Setter - First Name
     * @param firstName - String
     */
    public void setFirstName(String firstName) {	       
    	this.firstName = firstName;
    }
    
	/**
	 * Getter - Last Name 
	 * @return Last Name
	 */
	public String getLastName() {
        return lastName;
    }
	 
	/**
	 * Setter - Last Name
	 * @param lastName - String
	 */
    public void setLastName(String lastName) {
    	this.lastName = lastName;
	}

    /**
     * Getter - Email Address
     * @return Email Address
     */
    public String getEmail() {
    	return email;
	}
	 
    /**
     * Setter - Email Address
     * @param email - String
     */
    public void setEmail(String email) {
    	this.email = email;
	}
    
    /**
     * Getter - Phone Number
     * @return Phone Number
     */
    public String getPhone() {
    	return phone;
    }
	
    /**
     * Setter - Phone Number
     * @param phone - String
     */
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
    /**
     * User To String Method
     */
    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phone=" + phone + ", businessName=" + businessName + ", zip= " + 
				zip + ", address= " + address + ", city= " + city + ", state= " + state + "]";
	}
}