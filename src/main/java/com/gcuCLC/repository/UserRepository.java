package com.gcuCLC.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

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
 * 1. Repository - User Repository
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 * 03/12/2022 Team                Documentation
 *
 */

public interface UserRepository extends CrudRepository<UserEntity,Long> {

	/**
	 * CRUD: Searches the Database to Find All Users
	 */
	@Override
	@Query(value= "SELECT * FROM USER")
	public List<UserEntity> findAll();
	
	/**
	 * CRUD: Searches the Database to Find Users by UserName
	 * @param username - String
	 * @return User/s in Database that matched the searched for UserName
	 */
	public UserEntity findByUsername(String username);
		
	/**
	 * CRUD: Searches the Database to Find Users by UserName and Password
	 * @param username - String
	 * @param password - String
	 * @return User/s in Database that matched the searched for UserName and Password
	 */
	public UserEntity findByUsernameAndPassword(String username, String password);
	
	/**
	 * CRUD: Searches the Database to check if a UserName already exists
	 * @param username - String
	 * @return true - If UserName already exist in the Database
	 * @return false - If UserName does not exist in the Database
	 */
	public Boolean usernameExists(String username);
}