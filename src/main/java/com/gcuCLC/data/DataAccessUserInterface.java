package com.gcuCLC.data;

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
 * 1. Interface - Data Access User Interface
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

public interface DataAccessUserInterface<T>  {

	/**
	 * Generic Method to Find User By Email
	 * @param email - String Type
	 * @return Full User
	 */
	public T findByEmail(String email);
	
	/**
	 * Generic Method to Find User By User Name
	 * @param username - String Type
	 * @return Full User
	 */
	public T findByUsername(String username);
}