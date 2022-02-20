package com.gcuCLC.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.entity.UserEntity;
import com.gcuCLC.entity.UserPhotoEntity;
import com.gcuCLC.repository.UserPhotoRepository;
import com.gcuCLC.repository.UserRepository;

public class UserPhotoDataService implements DataAccessInterface<UserPhotoEntity>, DataAcessUserImageInterface<UserPhotoEntity>{

	@Autowired
	private UserPhotoRepository usersPhotoRepository;
	@Autowired
	private DataAccessInterface<UserPhotoEntity> UserPhotoDAO;
	@SuppressWarnings("unused")
	@Autowired
	private UserRepository userRepository;
	@SuppressWarnings("unused")
	@Autowired
	private DataAccessInterface<UserEntity> UserDAO;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default Constructor for constructor injection
	 */
	public UserPhotoDataService(UserPhotoRepository usersPhotoRepository, DataSource dataSource) {
		this.usersPhotoRepository = usersPhotoRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * CRUD: finder to return all photo entities
	 */
	@Override
	public List<UserPhotoEntity> findAll() {

		List<UserPhotoEntity> userPhoto = new ArrayList<UserPhotoEntity>();
		try
		{
			// Get all all the Entity Orders
			Iterable<UserPhotoEntity> usersPhotoIterable = usersPhotoRepository.findAll();

			// Convert to a List and return the List
			userPhoto = new ArrayList<UserPhotoEntity>();
			usersPhotoIterable.forEach(userPhoto::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// Return the List
		return userPhoto;
	}

	@Override
	public UserPhotoEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return UserPhotoDAO.findById(id);
	}

	/**
	 * CRUD: create an entity
	 */
	@Override
	public boolean create(UserPhotoEntity userPhoto) {
		// Example of "overriding" the CrudRepository save() because it simple is never called
		// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO ORDERS(PICTURE_ID, PICTURE_LABEL, PICTURE_URL) VALUES(?, ?, ?)";
		try
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql,
					userPhoto.getPictureId(),
					userPhoto.getPictureLabel(),
					userPhoto.getPictureUrl());
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
	public boolean update(UserPhotoEntity userPhoto) {
		
		
		// Return the List
		return usersPhotoRepository.save(userPhoto) != null;
	}

	/**
	 * CRUD: Method to Delete an Order Entity
	 * @param order
	 * @return
	 */
	@Override
	public boolean delete(UserPhotoEntity userPhoto) {
		try
		{
			this.usersPhotoRepository.delete(userPhoto);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
		// Return the List
		return true;
	}

	@Override
	public Optional<UserPhotoEntity> findUserPhotosByUserId(UserEntity id) {
		
		long photoId = id.getUserId();			
		return Optional.of(UserPhotoDAO.findById((int) photoId));
	}
	
	@Override
	public void init() {
		System.out.println("UserPhotoDataService Initialized");
	}

	@Override
	public void destroy() {
		System.out.println("UserPhotoDataService Destroyed");	
	}


	
}