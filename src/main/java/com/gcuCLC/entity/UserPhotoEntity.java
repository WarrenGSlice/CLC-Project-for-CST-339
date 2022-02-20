package com.gcuCLC.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PICTURES")
public class UserPhotoEntity {

	@Id
	Integer pictureId;
	
	@Column("PICTURE_LABEL")
	String pictureLabel;
	
	@Column("PICTURE_URL")
	String pictureUrl;

	public UserPhotoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPhotoEntity(Integer pictureId, String pictureLabel, String pictureUrl) {
		super();
		this.pictureId = pictureId;
		this.pictureLabel = pictureLabel;
		this.pictureUrl = pictureUrl;
	}

	public Integer getPictureId() {
		return pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

	public String getPictureLabel() {
		return pictureLabel;
	}

	public void setPictureLabel(String pictureLabel) {
		this.pictureLabel = pictureLabel;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	
}
