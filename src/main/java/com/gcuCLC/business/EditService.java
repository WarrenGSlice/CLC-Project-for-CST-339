package com.gcuCLC.business;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.repository.EditOrderRepository;

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
 * 1. Service - Edit Service
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 * Class was made for temporily solution to problem that no longer exists
 *
 */

public class EditService implements IEditService {

	@SuppressWarnings("unused")
	@Autowired
	private EditOrderRepository editOrderRepository;

	/**
	 * Service - finds by Id
	 * @param id - Auto Injected Long
	 * @return null - Method is Non-functional
	 */
	@Override
	public Optional<OrderEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
