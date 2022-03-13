package com.gcuCLC.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcuCLC.entity.UserEntity;
import com.gcuCLC.repository.UserRepository;

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
 * 1. Data Service - User Data Service
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@Service
public class UserDataService implements DataAccessInterface<UserEntity>, DataAccessUserInterface<UserEntity>{

	@Autowired
	private UserRepository usersRepository;
	@Autowired
	private DataAccessInterface<UserEntity> UserDAO;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default Constructor for constructor injection
	 * @param usersRepository - Auto Injected Users Repository Repository
	 * @param dataSource - Auto Injected DataSource
	 */
	public UserDataService(UserRepository usersRepository, DataSource dataSource) { // 2/26/2022 comment out
		this.usersRepository = usersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/**
	 * CRUD: finder to return all user entities
	 */
	@Override
	public List<UserEntity> findAll() {

		List<UserEntity> user = new ArrayList<UserEntity>();
		try
		{
			// Get all all the Entity Orders
			Iterable<UserEntity> usersIterable = usersRepository.findAll();

			// Convert to a List and return the List
			user = new ArrayList<UserEntity>();
			usersIterable.forEach(user::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// Return the List
		return user;
	}

	/**
	 * Method to find User by Id
	 */
	@Override
	public UserEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return UserDAO.findById(id);
	}

	/**
	 * CRUD: create an entity
	 */
	@Override
	public boolean create(UserEntity user) {
		// Example of "overriding" the CrudRepository save() because it simple is never called
		// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO USER(USER_NAME, FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE, ZIP, EMAIL, PASSWORD, BUSINESS_NAME, PHONE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql,
					user.getUsername(),
					user.getFirstName(),
					user.getLastName(),
					user.getAddress(),
					user.getCity(),
					user.getState(),
					user.getZip(),
					user.getEmail(),
					user.getPassword(),
					user.getBusinessName(),
					user.getPhone());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	return true;
	}

	/**
	 * CRUD: Method to Update an Order Entity
	 */
	@Override
	public boolean update(UserEntity user) {
		
		String sql = "UPDATE USER SET FIRST_NAME = ?, LAST_NAME = ?, ADDRESS = ?, CITY = ?, STATE = ?, ZIP = ?, EMAIL = ?, BUSINESS_NAME = ?, PHONE = ? WHERE USER_NAME = ? AND PASSWORD = ?";
		try
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql,
					user.getFirstName(),
					user.getLastName(),
					user.getAddress(),
					user.getCity(),
					user.getState(),
					user.getZip(),
					user.getEmail(),
					user.getBusinessName(),
					user.getPhone(),
					user.getUsername(),
					user.getPassword());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		// Return the List
		return true;
	}

	/**
	 * CRUD: Method to Delete a User
	 * @param user - Auto Injected User Entity Entity
	 * @return Deleted User
	 */
	@Override
	public boolean delete(UserEntity user) {
		try
		{
			this.usersRepository.delete(user);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
		// Return the List
		return true;
	}

	/**
	 * Method to Find User by Email
	 */
	@SuppressWarnings("deprecation")
	@Override
	public UserEntity findByEmail(String email) {
		{
			String sql = "SELECT * FROM USER WHERE EMAIL = ?";
			UserEntity users =new UserEntity();
			try
			{
				users = jdbcTemplateObject.queryForObject(sql, new Object[]{email}, (rs, rowNum) ->
					    new UserEntity((long) rs.getInt("USER_ID"),
									  rs.getString("USER_NAME"),
									  rs.getString("FIRST_NAME"),
									  rs.getString("LAST_NAME"),
									  rs.getString("ADDRESS"),
									  rs.getString("CITY"),
									  rs.getString("STATE"),
									  rs.getString("ZIP"),
									  rs.getString("EMAIL"),
									  rs.getString("PASSWORD"),
									  rs.getString("BUSINESS_NAME"),
									  rs.getString("PHONE")));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return (UserEntity) users;
		}
	}
	
	/**
	 * CRUD: finder to return an entity by User name
	 * @param username - String
	 * @return User Based on Username
	 */
	public UserEntity findByUsername(String username)
	{
		return usersRepository.findByUsername(username);
	}
	
	/**
	 * Method to Check if User Name Already Exists in Database
	 * @param username - String
	 * @return true if user is valid
	 * @return false if user already exists
	 */
	@SuppressWarnings("deprecation")
	public Boolean usernameExists(String username)
	{
		int results = 0;
		
		String sql = "SELECT COUNT(*) FROM USER WHERE USER_NAME = ?";
		try
		{
			results = jdbcTemplateObject.queryForObject(sql, new Object[]{username}, Integer.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		if (results == 0)
		{
			System.out.printf("User does not have an account: Username=%s\n", username);
			return false;
		}
		else
		{
			System.out.printf("User has a valid account: Username=%s\n", username);
			return true;			
		}
	}

	/**
	 * Tells Console when service is initialized
	 */
	@Override
	public void init() {
		System.out.println("UserDataService Initialized");
	}

	/**
	 * Tells Console when service is destroyed
	 */
	@Override
	public void destroy() {
		System.out.println("UserDataService Destroyed");	
	}


}