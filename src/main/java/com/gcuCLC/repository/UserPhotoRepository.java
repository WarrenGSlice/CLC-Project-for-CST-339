package com.gcuCLC.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcuCLC.entity.UserPhotoEntity;

public interface UserPhotoRepository extends CrudRepository<UserPhotoEntity,Long> {

	@Override
	@Query(value= "SELECT * FROM PICTURES")
	public List<UserPhotoEntity> findAll();
}