package com.gcuCLC.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.entity.UserEntity;
import com.gcuCLC.repository.UserRepository;

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
	 */
	public UserDataService(UserRepository usersRepository, DataSource dataSource) {
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
	 * CRUD: Method to Delete an Order Entity
	 * @param order
	 * @return
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

	@SuppressWarnings("deprecation")
	@Override
	public UserEntity findByUsername(String username) {
		{
			String sql = "SELECT * FROM USER WHERE USER_NAME = ?";
			UserEntity users =new UserEntity();
			try
			{
				users = jdbcTemplateObject.queryForObject(sql, new Object[]{username}, (rs, rowNum) ->
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

//	@SuppressWarnings("deprecation")
//	@Override
//	public Boolean verifyUser(String username, String password)
//	{
//		int results = 0;
//		
//		String sql = "SELECT COUNT(*) FROM USER WHERE USER_NAME = ? AND PASSWORD = ?";
//		try
//		{
//			results = jdbcTemplateObject.queryForObject(sql, new Object[]{username, password}, Integer.class);
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//
//		if (results == 0)
//		{
//			System.out.printf("User does not have an account: Username=%s, Password=%s\n", username, password);
//			return false;
//		}
//		else
//		{
//			System.out.printf("User has a valid account: Username=%s, Password=%s\n", username, password);
//			return true;			
//		}
//	}
	
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

	@Override
	public void init() {
		System.out.println("UserDataService Initialized");
	}

	@Override
	public void destroy() {
		System.out.println("UserDataService Destroyed");	
	}


}