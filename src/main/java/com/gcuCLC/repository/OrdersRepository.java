package com.gcuCLC.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

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
 * 1. Repository - Orders Repository
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 * 03/12/2022 Team                Documentation
 *
 */

@Service
public interface OrdersRepository extends CrudRepository<OrderEntity,Long> {

	/**
	 * CRUD: Searched the Database to find All Orders
	 */
	@Override
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findAll();
	
	/**
	 * CRUD: Searches the Database to find all order By Company Name
	 * @param companyName - String
	 * @return Orders in Database that Matched Searched for Company Name
	 */
	public List<OrderEntity> findByCompanyName(String companyName);
	
	/**
	 * CRUD: Searches the Database to find all orders By Customer Name
	 * @param customerName - String
	 * @return Orders in Database that matched Searched for Customer Name
	 */
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findByCustomerName(String customerName);
	
	/**
	 * CRUD: Searches the Database to find all orders by Delivery Date
	 * @param deliveryDate - String
	 * @return Orders in Database that matched Searched for Delivery Date
	 */
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findByDeliveryDate(String deliveryDate);
	
	/**
	 * CRUD: Searches the Database to find all Orders by Delivery Price
	 * @param deliveryPrice - Integer
	 * @return Orders in Database that matches Searched for Delivery price
	 */
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findByDeliveryPrice(Integer deliveryPrice);
	
	/**
	 * CRUD: Searches the Database to find all Orders by Delivery Status
	 * @param deliveryStatus - String
	 * @return Orders in Database that matches Searched for Delivery Status
	 */
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findByDeliveryStatus(String deliveryStatus);
	
	/**
	 * CRUD: Searches the Database to find all Orders by Payment Type
	 * @param payment - String
	 * @return - Orders in Database that Matches Searched for Payment Type
	 */
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findByPayment(String payment);
	
	/**
	 * CRUD: Searches the Database to find all Order by Order ID
	 * @param orderId - String
	 * @return Orders in Database that Matches Searched for Order ID
	 */
	@Query(value= "SELECT * FROM ORDERS")
	public List<OrderEntity> findById(String orderId);
	
	/**
	 * CRUD: Searches the Database to find all Orders by Order ID
	 * @param orderId - Integer
	 * @return Orders in Database that Matches Searched for Order ID
	 */
	public OrderEntity findByOrderId(Integer orderId);


}
