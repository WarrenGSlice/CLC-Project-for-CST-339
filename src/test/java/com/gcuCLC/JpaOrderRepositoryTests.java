package com.gcuCLC;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.gcuCLC.entity.Orders;
import com.gcuCLC.repository.JpaOrderRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class JpaOrderRepositoryTests 
{
	@Autowired
	private JpaOrderRepository repo;
	
	@Test
	public void testCreateOrder() {
		Orders savedOrder = repo.save(new Orders("Nike","NikeShoes", "12/21/2022", (int) 15.21, "Complete","Paypal"));
		
		assertThat(savedOrder.getOrderId()).isGreaterThan(0);
	}
}
