package com.gcuCLC.business;

import java.util.Optional;

import com.gcuCLC.entity.OrderEntity;

public interface IEditService {

	Optional<OrderEntity> findById(Long id);
}
