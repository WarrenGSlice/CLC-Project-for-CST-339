package com.gcuCLC.data;

public interface DataAccessUserInterface<T>  {

	public T findByEmail(String email);
	public T findByUsername(String username);
//	public Boolean verifyUser(String username, String password);
}