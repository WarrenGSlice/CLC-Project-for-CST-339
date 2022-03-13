package com.gcuCLC.business;

import org.springframework.stereotype.Service;

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
 * 1. Service - Security Business Service
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@Service
public class SecurityBusinessService {

	/**
	 * Method Once used to Authenticate User logins
	 * @param username - Username of User
	 * @param password - Password of user
	 * @return true - Logs user in
	 */
	public boolean authenticate(String username, String password) {
		System.out.println("Hello from the SecurityBusinessService");
		return true;
	}

}