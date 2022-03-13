package com.gcuCLC.data;

import java.util.Optional;

import com.gcuCLC.entity.ProductImageEntity;
import com.gcuCLC.entity.ProductsEntity;

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
 * 1. Interface - Data Access Image Interface
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

public interface DataAccessProductImageInterface<T> {

	/**
	 * Method to Find Image by Id
	 * @param id - Auto Injected Products Entity Entity
	 * @return Images
	 */
	public Optional<ProductImageEntity> findProductImagesByProductId(ProductsEntity id);
}
