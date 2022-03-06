package com.gcuCLC.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.repository.StringRepo;

public class OrderService {
	
	@Autowired
	private StringRepo stringRepo;

	public List<OrderEntity> findByCompanyName(String companyName) {
		return stringRepo.findByCompanyName(companyName);
	}
	
	public List<OrderEntity> findByCustomerName(String customerName){
		return stringRepo.findByCustomerName(customerName);
	}
	
	public List<OrderEntity> findByDeliveryStatus(String deliveryStatus){
		return stringRepo.findByDeliveryStatus(deliveryStatus);
	}
	
	public List<OrderEntity> findByPayment(String payment){
		return stringRepo.findByPayment(payment);
	}

}
