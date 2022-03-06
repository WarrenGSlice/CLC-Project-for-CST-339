package com.gcuCLC.model;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gcuCLC.entity.UserEntity;

@SuppressWarnings("serial")
public class gcuCLCuserDetails implements UserDetails {
    private UserEntity user;
     
    public gcuCLCuserDetails(UserEntity user) {
        this.user = user;
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
    
    public String getFirstName() {
    	return this.user.getFirstName();
    }
    
    public String getLastName() {
    	return this.user.getLastName();
    }
    
    public String getPhone() {
    	return this.user.getPhone();
    }
    
    public String getBusinessName() {
    	return this.user.getBusinessName();
    }
    
    public String getAddress() {
    	return this.user.getAddress();
    }
    
    public String getCity() {
    	return this.user.getCity();
    }
    
    public String getState() {
    	return this.user.getState();
    }
    
    public String getZip() {
    	return this.user.getZip();
    }
}
