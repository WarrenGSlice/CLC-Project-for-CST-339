package com.gcuCLC.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcuCLC.entity.UserPhotoEntity;

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
 * 1. Repository - User Photo Repository
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 * 03/12/2022 Team                Documentation
 *
 */

public interface UserPhotoRepository extends CrudRepository<UserPhotoEntity,Long> {

	/**
	 * CRUD: Searches the Database to Find All User Photos
	 */
	@Override
	@Query(value= "SELECT * FROM PICTURES")
	public List<UserPhotoEntity> findAll();
}