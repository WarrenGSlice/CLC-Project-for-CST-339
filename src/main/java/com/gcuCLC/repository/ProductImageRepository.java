package com.gcuCLC.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcuCLC.entity.ProductImageEntity;

public interface ProductImageRepository extends CrudRepository<ProductImageEntity,Long> {

	@Override
	@Query(value= "SELECT * FROM PRODUCTIMAGE")
	public List<ProductImageEntity> findAll();
}