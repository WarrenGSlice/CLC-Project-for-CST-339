package com.gcuCLC.data;

import java.util.List;

import com.gcuCLC.entity.OrderEntity;

public interface DataAccessInterface<T> {

	public List<T> findAll();
	public T findById(Integer id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
	// Method to initiate bean instance
	public void init();
			
	// Method to destroy bean instancve
	public void destroy();
	/**
	 * CRUD: Method to Delete an Order Entity
	 * @param order
	 * @return
	 */

}
