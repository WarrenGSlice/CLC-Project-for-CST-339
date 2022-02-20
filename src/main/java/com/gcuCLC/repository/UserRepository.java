package com.gcuCLC.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcuCLC.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

	@Override
	@Query(value= "SELECT * FROM USER")
	public List<UserEntity> findAll();
	
	public UserEntity findByUsername(String username);
	
//	public Boolean verifyUser(String username, String password);
	
	public UserEntity findByUsernameAndPassword(String username, String password);
	
	public Boolean usernameExists(String username);
}