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
	
	public List<OrderEntity> findByCompanyName(String companyName);
	
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findByCustomerName(String customerName);
	
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findByDeliveryDate(String deliveryDate);
	
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findByDeliveryPrice(Integer deliveryPrice);
	
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findByDeliveryStatus(String deliveryStatus);
	
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findByPayment(String payment);
	
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findById(String orderId);
	
	public OrderEntity findByOrderId(Integer orderId);


}
