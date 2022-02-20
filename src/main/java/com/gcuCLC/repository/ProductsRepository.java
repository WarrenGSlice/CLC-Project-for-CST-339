package com.gcuCLC.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcuCLC.entity.ProductsEntity;

public interface ProductsRepository extends CrudRepository<ProductsEntity,Long> {

	@Override
	@Query(value= "SELECT * FROM PRODUCTS")
	public List<ProductsEntity> findAll();
}