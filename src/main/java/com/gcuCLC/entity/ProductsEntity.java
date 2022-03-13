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
 * 1. Entity - Products Entity
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@Table("PRODUCTS")
public class ProductsEntity {

	@Id
	Integer productId;
	
	@Column("PRODUCT_NAME")
	String productName;
	
	@Column("BRAND")
	String brand;
	
	@Column("DETAILS")
	String details;
	
	@Column("PRODUCT_PRICE")
	float productPrice;
	
	@Column("COLOR")
	String color;

	//--------CONSTRUCTORS---------\\
	
	/**
	 * Products Entity Constructor Method
	 */
	public ProductsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Products Entity Constructor Method
	 * @param productId - Integer
	 * @param productName - String
	 * @param brand - String
	 * @param details - String
	 * @param productPrice - float
	 * @param color - String
	 */
	public ProductsEntity(Integer productId, String productName, String brand, String details, float productPrice,
			String color) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.details = details;
		this.productPrice = productPrice;
		this.color = color;
	}

	//--------------GETTERS & SETTERS---------------\\
	
	/**
	 * Getter - Product ID
	 * @return Product ID
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * Setter - Product ID
	 * @param productId - Integer
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * Getter - Product Name
	 * @return Product Name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Setter - Product name
	 * @param productName - String
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Getter - Brand Name
	 * @return Brand Name
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Setter - Brand Name
	 * @param brand - String
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Getter - Product Details
	 * @return Product Details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Setter - Product Details
	 * @param details - String
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * Getter - Product Price
	 * @return Product Price
	 */
	public float getProductPrice() {
		return productPrice;
	}

	/**
	 * Setter - Product Price
	 * @param productPrice - float
	 */
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * Getter - Product Color
	 * @return Product COlor
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Setter - Product COlor
	 * @param color - String
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
