package com.gcuCLC.repository;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
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
 * 1. Repository - Edit Order Repository
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 * 03/12/2022 Team                Documentation
 *
 */

@Service
public interface EditOrderRepository extends Repository<OrderEntity,Integer> {
	
	/**
	 * CRUD: Searches Database to Find an Order by the Order ID
	 * @param orderId - Integer
	 * @return List of Orders that matched the searched for Order ID
	 */
	List<OrderEntity> findByOrderId(Integer orderId);
	
	/**
	 * CRUD: Searched Database to Find an Order by the Company Name
	 * @param companyName - String
	 * @return List of Orders that matched the search for Company Name
	 */
	List<OrderEntity> findByCompanyName(String companyName);
}