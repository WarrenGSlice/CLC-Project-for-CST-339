package com.gcuCLC.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.gcuCLC.entity.OrderEntity;

@Service
public interface OrdersRepository extends CrudRepository<OrderEntity,Long> {

	@Override
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findAll();
	

	
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findById(String orderId);
	
	public OrderEntity findByOrderId(Integer orderId);


}
