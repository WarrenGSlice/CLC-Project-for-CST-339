package com.gcuCLC.data;

import org.springframework.data.repository.Repository;

import com.gcuCLC.entity.UserEntity;

public interface DataAccessUserInterface<T>  {

	public UserEntity findByEmail(String email);
	public UserEntity findByUsername(String username);
//	public Boolean verifyUser(String username, String password);
}
