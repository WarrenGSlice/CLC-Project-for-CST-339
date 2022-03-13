package com.gcuCLC.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
 * 1. Model - Login
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

// User Login in Properties to be used with LoginController
public class Login {

	// Variables
	@NotNull(message="UserName is a Required Field")
	@Size(min=1, max=32, message="UserName Must be Between 1 & 32 characters")
	private String username;
	
	@NotNull(message="Password is a Required Field")
	@Size(min=1, max=32, message="Password Must be Between 1 & 32 characters")
	private String password;

	/**
	 * Getter - UserName
	 * @return UserName
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter - userName
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
	 * Login No Args Constructor Method
	 */
	public Login() {
		
	}

	/**
	 * Login To-String Method
	 */
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}

	
}