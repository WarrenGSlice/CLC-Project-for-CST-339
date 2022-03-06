package com.gcuCLC.model;

/** * * * * * * * * * * * * * * *
 * CST-339 CLC Milestone Project
 * Order Management Application *
 * Created by Warren Peterson,* *
 * Jonathan Levan, Ivan Gudino  *
 * * * * * * * * * * * * * * * **/ 

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// User Login in Properties to be used with LoginController
public class Login {

	// Variables
	@NotNull(message="UserName is a Required Field")
	@Size(min=1, max=32, message="UserName Must be Between 1 & 32 characters")
	private String username;
	
	@NotNull(message="Password is a Required Field")
	@Size(min=1, max=32, message="Password Must be Between 1 & 32 characters")
	private String password;

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
	
	public Login() {
		
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}

	
}