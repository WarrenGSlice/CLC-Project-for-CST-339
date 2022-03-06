package com.gcuCLC.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcuCLC.entity.OrderEntity;

public interface StringRepo extends CrudRepository<OrderEntity,String> {

	public List<OrderEntity> findByCompanyName(String companyName);
	
	public List<OrderEntity> findByCustomerName(String customerName);
	
	public List<OrderEntity> findByDeliveryStatus(String deliveryStatus);
	
	public List<OrderEntity> findByPayment(String payment);
}
