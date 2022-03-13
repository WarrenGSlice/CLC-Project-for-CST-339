package com.gcuCLC.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.repository.StringRepo;

/**
 * ---------------------------------------------------------------------------
 * Name      : Group H1
 * Members   : W. Peterson, J. LeVan, and I. Gudino
 * Date      : 2022-03-11
 * Class     : CST-339 Java Programming III
 * Professor : Brandon Bass
 * Assignment: Milestone - CLC Group Assignment
 * Disclaimer: This is our own work
 * ---------------------------------------------------------------------------
 * Description:
 * 1. Service - Order Service
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

public class OrderService {
	
	@Autowired
	private StringRepo stringRepo;

	/**
	 * Method to Work with API's
	 * API - to find by Company Name
	 * @param companyName - Name of Company in Database
	 * @return Full Order - matched by Company Name
	 */
	public List<OrderEntity> findByCompanyName(String companyName) {
		return stringRepo.findByCompanyName(companyName);
	}
	
	/**
	 * Method to Work with API's
	 * API - to find by Customer Name
	 * @param customerName - Name of Customer in Database
	 * @return Full Order - matched by Customer Name
	 */
	public List<OrderEntity> findByCustomerName(String customerName){
		return stringRepo.findByCustomerName(customerName);
	}
	
	/**
	 * Method to Work with API's
	 * API - to find by Delivery Status
	 * @param deliveryStatus - Delivery Status of Order in Database
	 * @return Full Orders - Matched by Delivery Status
	 */
	public List<OrderEntity> findByDeliveryStatus(String deliveryStatus){
		return stringRepo.findByDeliveryStatus(deliveryStatus);
	}
	
	/**
	 * Method to Work with API's
	 * API - to find by Payment Type
	 * @param payment - Payment Type of Order in Database
	 * @return Full Orders - Matched by Payment Types
	 */
	public List<OrderEntity> findByPayment(String payment){
		return stringRepo.findByPayment(payment);
	}

}
