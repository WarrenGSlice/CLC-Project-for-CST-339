package com.gcuCLC.data;

import java.util.List;

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
 * 1. Interface - Data Access Interface 
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 */

@Service
public interface DataAccessInterface<T> {

	/**
	 * Method to Find All
	 * @return Entire List
	 */
	public List<T> findAll();
	
	/**
	 * Method to Find by ID
	 * @param id - Integer
	 * @return Single Item
	 */
	public T findById(Integer id);
	
	/**
	 * Method to Create new Database Entry
	 * @param t - Passes Generic
	 * @return New Entry in Database
	 */
	public boolean create(T t);
	
	/**
	 * Method to Update Database Entry
	 * @param t - Passes Generic
	 * @return Updates Entry
	 */
	public boolean update(T t);
	
	/**
	 * Method to Delete Database Entry
	 * @param t - Passes Generic
	 * @return Deletes Entry
	 */
	public boolean delete(T t);
	
	/**
	 * Method for Testing
	 */
	public void init();
			
	/**
	 * Method For Testing
	 */
	public void destroy();

}
