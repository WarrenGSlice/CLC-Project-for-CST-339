package com.gcuCLC;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.gcuCLC.entity.Orders;
import com.gcuCLC.repository.JpaOrderRepository;

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
 * 1. Tests - JPA Order Repository Tests
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 * 03/12/2022 Team                Documentation
 *
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class JpaOrderRepositoryTests 
{
	@Autowired
	private JpaOrderRepository repo;
	
	/**
	 * TEST: Method to Save a new order to the Database and then removes it
	 */
	@Test
	public void testCreateOrder() {
		Orders savedOrder = repo.save(new Orders("Nike","NikeShoes", "12/21/2022", (int) 15.21, "Complete","Paypal"));
		
		assertThat(savedOrder.getOrderId()).isGreaterThan(0);
	}
}
