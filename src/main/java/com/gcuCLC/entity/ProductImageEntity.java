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
 * 1. Entity - Product Image Entity
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@Table("PRODUCTIMAGE")
public class ProductImageEntity {

	@Id
	Integer id;
	
	@Column("PRODUCT_IMAGE_NAME")
	String productImageName;
	
	@Column("PRODUCT_IMAGE_URL")
	String productImageUrl;

	//---------CONSTRUCTORS------------\\
	
	/**
	 * Empty Product Image Entity Super Constructor Method
	 */
	public ProductImageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Product Image Entity Constructor Method
	 * @param id - Integer
	 * @param productImageName - String
	 * @param productImageUrl - String
	 */
	public ProductImageEntity(Integer id, String productImageName, String productImageUrl) {
		super();
		this.id = id;
		this.productImageName = productImageName;
		this.productImageUrl = productImageUrl;
	}

	//-------------GETTERS & SETTERS--------------\\
	
	/**
	 * Getter - ID
	 * @return ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter - ID
	 * @param id - Integer
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter - Product Image Name
	 * @return Product Image Name
	 */
	public String getProductImageName() {
		return productImageName;
	}

	/**
	 * Setter - Product Image Name
	 * @param productImageName - String
	 */
	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}

	/**
	 * Getter - Product Image URL
	 * @return Product Image URL
	 */
	public String getProductImageUrl() {
		return productImageUrl;
	}

	/**
	 * Setter - Product Image URL
	 * @param productImageUrl - String
	 */
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	
	
}
