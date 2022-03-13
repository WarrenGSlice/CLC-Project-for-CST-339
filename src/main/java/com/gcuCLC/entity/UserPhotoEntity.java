package com.gcuCLC.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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
 * 1. Entity - User Photo Entity
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@Table("PICTURES")
public class UserPhotoEntity {

	@Id
	Integer pictureId;
	
	@Column("PICTURE_LABEL")
	String pictureLabel;
	
	@Column("PICTURE_URL")
	String pictureUrl;

	/**
	 * User Photo Entity Constructor Method
	 */
	public UserPhotoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * User Photo Entity Constructor Method
	 * @param pictureId - Integer
	 * @param pictureLabel - String
	 * @param pictureUrl - String
	 */
	public UserPhotoEntity(Integer pictureId, String pictureLabel, String pictureUrl) {
		super();
		this.pictureId = pictureId;
		this.pictureLabel = pictureLabel;
		this.pictureUrl = pictureUrl;
	}

	/**
	 * Getter - Picture ID
	 * @return Picture ID
	 */
	public Integer getPictureId() {
		return pictureId;
	}

	/**
	 * Setter - Picture ID
	 * @param pictureId - Integer
	 */
	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

	/**
	 * Getter - Picture Description
	 * @return Photo Description
	 */
	public String getPictureLabel() {
		return pictureLabel;
	}

	/**
	 * Setter - Photo Description
	 * @param pictureLabel - String
	 */
	public void setPictureLabel(String pictureLabel) {
		this.pictureLabel = pictureLabel;
	}

	/**
	 * Getter - Photo URL Address
	 * @return Photo URL Address
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}

	/**
	 * Setter - Photo URL Address
	 * @param pictureUrl - String
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	
}
