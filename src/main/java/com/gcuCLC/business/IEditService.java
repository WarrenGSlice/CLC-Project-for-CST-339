package com.gcuCLC.business;

import java.util.Optional;

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
 * 1. Interface - I Edit Service
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 * Works with Edit Service Business Class
 *
 */

public interface IEditService {

	/**
	 * Method to find Order by Id in the database
	 * @param id - Order Id
	 * @return Order based on OrderId
	 */
	Optional<OrderEntity> findById(Long id);
}
