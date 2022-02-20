package com.gcuCLC.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCTIMAGE")
public class ProductImageEntity {

	@Id
	Integer id;
	
	@Column("PRODUCT_IMAGE_NAME")
	String productImageName;
	
	@Column("PRODUCT_IMAGE_URL")
	String productImageUrl;

	public ProductImageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductImageEntity(Integer id, String productImageName, String productImageUrl) {
		super();
		this.id = id;
		this.productImageName = productImageName;
		this.productImageUrl = productImageUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductImageName() {
		return productImageName;
	}

	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	
	
}
