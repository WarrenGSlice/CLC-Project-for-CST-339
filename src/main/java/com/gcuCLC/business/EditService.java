package com.gcuCLC.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.repository.EditOrderRepository;

public class EditService implements IEditService {

	@Autowired
	private EditOrderRepository editOrderRepository;

	@Override
	public Optional<OrderEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
