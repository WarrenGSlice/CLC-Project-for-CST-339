package com.gcuCLC.entity;

import java.util.Random;
import java.util.Set;
import com.gcuCLC.model.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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
 * 1. Entity - User Entity
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

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

	/**
	 * User Entity Constructor Method
	 */
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * User Entity Constructor Method
	 * @param user - Auto Injected User Model
	 */
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

	/**
	 * User Entity Constructor Method
	 * @param userId - Long
	 * @param username - String
	 * @param firstName - String
	 * @param lastName - String
	 * @param address - String
	 * @param city - String
	 * @param state - String
	 * @param zip - String
	 * @param email - String
	 * @param password - String
	 * @param businessName - String
	 * @param phone - String
	 */
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
	
	/**
	 * User Entity Constructor Method
	 * @param username - String
	 * @param password - String
	 * @param firstName - String
	 * @param lastName - String
	 * @param businessName - String
	 * @param address - String
	 * @param city - String
	 * @param email - String
	 * @param phone - String
	 * @param zip - String
	 * @param state - String
	 */
	public UserEntity(String username, String password, String firstName, String lastName, String businessName,
			String address, String city, String email, String phone, String zip, String state) {
		this.username = getUsername();
		this.password = getPassword();
		this.firstName = getFirstName();
		this.lastName = getLastName();
		this.businessName = getBusinessName();
		this.address = getAddress();
		this.city = getCity();
		this.email = getEmail();
		this.phone = getPhone();
		this.zip = getZip();
		this.state = getState();

	}

	//----------GETTERS & SETTERS ------------\\
	
	/**
	 * Getter - Phone Number
	 * @return Phone Number
	 */
	public String getPhone()
	{
		return phone;
	}

	/**
	 * Setter - Phone Number
	 * @param phone - Phone Number
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	/**
	 * Getter - User ID
	 * @return User ID
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Setter - User ID
	 * @param userId - Long
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Getter - Username
	 * @return Username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Getter - Username
	 * @param username - Username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter - First Name
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
	 * Setter - Last name
	 * @param lastName - String
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter - Home Address
	 * @return Home Address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter - Home Address
	 * @param address - String
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter - City
	 * @return - City
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Setter - City
	 * @param city - String
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Getter - State
	 * @return State
	 */
	public String getState() {
		return state;
	}

	/**
	 * Setter - State
	 * @param state - String
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Getter - Zip Code
	 * @return Zip Code
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * Setter - Zip Code
	 * @param zip - String
	 */
	public void setZip(String zip) {
		this.zip = zip;
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
	 * Getter - Password
	 * @return Password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter - password
	 * @param password - String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter - Name Of Business
	 * @return Name Of Business
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * Setter - Name of Business
	 * @param businessName - String
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	/**
	 * Method to Get a Set of all Users
	 * @return - Set of Users
	 */
	@SuppressWarnings("unchecked")
	public Set<UserEntity> getUsers() {
		// TODO Auto-generated method stub
		return (Set<UserEntity>) new UserEntity(getUsername(), getFirstName(), getLastName(), getBusinessName(), getAddress(),
				getCity(), getState(), getEmail(), getPhone(), getZip(), getPassword());
	}
	
	/**
	 * Helper Method of Customer User Details Class
	 * @return true - is Enabled
	 */
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}