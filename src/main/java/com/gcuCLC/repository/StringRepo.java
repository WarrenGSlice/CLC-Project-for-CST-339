package com.gcuCLC.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcuCLC.entity.OrderEntity;

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
 * 1. Repository - String Repo
 * Used for API's searches in the address bar
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 * 03/12/2022 Team                Documentation
 *
 */

public interface StringRepo extends CrudRepository<OrderEntity,String> {

	/**
	 * CRUD API: Searches the Database to Find Orders by Company Name
	 * @param companyName - String
	 * @return Orders in Database that matched the searched for Company Name
	 */
	public List<OrderEntity> findByCompanyName(String companyName);
	
	/**
	 * CRUD API: Searches the Database to Find Orders by Customer Name
	 * @param customerName - String
	 * @return Orders in Database that matched the searched for Customer Name
	 */
	public List<OrderEntity> findByCustomerName(String customerName);
	
	/**
	 * CRUD API: Searches the Database to Find Orders by Delivery Status
	 * @param deliveryStatus - String
	 * @return Orders in Database that matched the searched for Delivery Status
	 */
	public List<OrderEntity> findByDeliveryStatus(String deliveryStatus);
	
	/**
	 * CRUD API: Searches the Database to Find Orders By Payment Type
	 * @param payment - String
	 * @return Orders in Database that matched the searched for Payment Type
	 */
	public List<OrderEntity> findByPayment(String payment);
}
