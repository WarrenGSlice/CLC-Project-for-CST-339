package com.gcuCLC.repository;




import java.util.List;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.gcuCLC.entity.OrderEntity;

@Service
public interface EditOrderRepository extends Repository<OrderEntity,Integer> {
	
	List<OrderEntity> findByOrderId(Integer orderId);
}