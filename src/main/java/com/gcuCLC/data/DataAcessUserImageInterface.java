package com.gcuCLC.data;

import java.util.Optional;

import com.gcuCLC.entity.UserEntity;
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
 * 1. Interface - Data Access User Image Interface
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

public interface DataAcessUserImageInterface<T> {

	/**
	 * Method to Find User Photos By User Id
	 * @param id - Auto Injected User Entity Entity
	 * @return User Photo
	 */
	public Optional<UserPhotoEntity> findUserPhotosByUserId(UserEntity id);
}
