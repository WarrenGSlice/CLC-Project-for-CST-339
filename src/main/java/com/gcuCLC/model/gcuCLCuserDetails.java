package com.gcuCLC.model;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gcuCLC.entity.UserEntity;

public class gcuCLCuserDetails implements UserDetails {
    private UserEntity user;
    
    private static final long serialVersionUID = 1L;
     
    public gcuCLCuserDetails(UserEntity user) {
        this.user = user;
    }
 
    public gcuCLCuserDetails() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //Set<User> users = user.getUsers();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
       // for (User user : users) {
            authorities.add(new SimpleGrantedAuthority(user.getUsername()));
        //}
        return authorities;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
    
    public String getEmail() {
		return this.user.getEmail();
	}
    
    public void setEmail(String email) {
    	this.user.setEmail(email);
    }
    
    public String getFirstName() {
    	return this.user.getFirstName();
    }
    
    public void setFirstName(String firstName) {
    	this.user.setFirstName(firstName);
    }
    
    public String getLastName() {
    	return this.user.getLastName();
    }
    
    public void setLastName(String lastName) {
    	this.user.setLastName(lastName);
    }
    
    public String getPhone() {
    	return this.user.getPhone();
    }
    
    public void setPhone(String phone) {
    	this.user.setPhone(phone);
    }
    
    public String getBusinessName() {
    	return this.user.getBusinessName();
    }
    
    public void setBusinessName(String businessName) {
    	this.user.setBusinessName(businessName);
    }
    
    public String getAddress() {
    	return this.user.getAddress();
    }
    
    public void setAddress(String address) {
    	this.user.setAddress(address);
    }
    
    public String getCity() {
    	return this.user.getCity();
    }
    
    public void setCity(String city) {
    	this.user.setCity(city);
    }
    
    public String getState() {
    	return this.user.getState();
    }
    
    public void setState(String state) {
    	this.user.setState(state);
    }
    
    public String getZip() {
    	return this.user.getZip();
    }
    
    public void setZip(String zip) {
    	this.user.setZip(zip);
    }
}
