package com.gcuCLC.model;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
 * 1. Model - GCU CLC User Details (Customer User Details Class)
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 * Used for passing User details besides username and password to session data
 * so it can be viewed in other parts of the application
 */

public class gcuCLCuserDetails implements UserDetails {
    private UserEntity user;
    
    private static final long serialVersionUID = 1L;
     
    /**
     * gcuCLCuserDetails Constructor Method
     * @param user - Auto Injected User Entity Entity
     */
    public gcuCLCuserDetails(UserEntity user) {
        this.user = user;
    }
 
    /**
     * gcuCLCuserDeatils Constructor Method
     */
    public gcuCLCuserDetails() {
		// TODO Auto-generated constructor stub
	}

    /**
     * Method is a requirement for using User Details and making it custom
     */
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getUsername()));
        return authorities;
    }
 
	/**
	 * Getter - Gets Logged in Users Password
	 */
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    /**
     * Getter - Gets Logged in Users Username
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }
 
    /**
     * Method is required for using custom User Details class
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    /**
     * Method is required for using custom User Details Class
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    /**
     * Method is required for using customer User details class
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    /**
     * Method is required for using custom user details class
     */
    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
    
    /**
     * getter - allows logged in Users Email to be
     * viewed on any page when logged in
     * @return Logged in Users Email
     */
    public String getEmail() {
		return this.user.getEmail();
	}
    
    /**
     * setter - sets logged in Users Email Address
     * @param email - Auto Injected String
     */
    public void setEmail(String email) {
    	this.user.setEmail(email);
    }
    
    /**
     * Getter - Gets Logged in Users First Name
     * @return Logged in users First Name
     */
    public String getFirstName() {
    	return this.user.getFirstName();
    }
    
    /**
     * Setter - sets logged in Users First Name
     * @param firstName - String
     */
    public void setFirstName(String firstName) {
    	this.user.setFirstName(firstName);
    }
    
    /**
     * Getter - Gets logged in users Last Name
     * @return Logged in Users Last name
     */
    public String getLastName() {
    	return this.user.getLastName();
    }
    
    /**
     * Setter - sets logged in users Last Name
     * @param lastName - String
     */
    public void setLastName(String lastName) {
    	this.user.setLastName(lastName);
    }
    
    /**
     * Getter - gets logged in users Phone Number
     * @return Logged in users Phone Number
     */
    public String getPhone() {
    	return this.user.getPhone();
    }
    
    /**
     * Setter - sets Logged in users Phone Number
     * @param phone - String
     */
    public void setPhone(String phone) {
    	this.user.setPhone(phone);
    }
    
    /**
     * Getter - gets logged in users Name of Business
     * @return Logged in users Name of Business
     */
    public String getBusinessName() {
    	return this.user.getBusinessName();
    }
    
    /**
     * Sets Logged in Users Name of Business
     * @param businessName - String
     */
    public void setBusinessName(String businessName) {
    	this.user.setBusinessName(businessName);
    }
    
    /**
     * Gets Logged in users Home Address
     * @return Logged in users Home Address
     */
    public String getAddress() {
    	return this.user.getAddress();
    }
    
    /**
     * Sets Logged in Users Home Address
     * @param address - String
     */
    public void setAddress(String address) {
    	this.user.setAddress(address);
    }
    
    /**
     * Getter - gets logged in users City
     * @return Logged in users city
     */
    public String getCity() {
    	return this.user.getCity();
    }
    
    /**
     * Setter - sets logged in users City
     * @param city - String
     */
    public void setCity(String city) {
    	this.user.setCity(city);
    }
    
    /**
     * Getter - gets logged in users State
     * @return Logged in Users State
     */
    public String getState() {
    	return this.user.getState();
    }
    
    /**
     * Setter - Sets Logged in users State
     * @param state - String
     */
    public void setState(String state) {
    	this.user.setState(state);
    }
    
    /**
     * Getter - Gets Logged in Users Zip Code
     * @return Logged in Users Zip Code
     */
    public String getZip() {
    	return this.user.getZip();
    }
    
    /**
     * Setter - sets logged in users zip code
     * @param zip - String
     */
    public void setZip(String zip) {
    	this.user.setZip(zip);
    }
}
