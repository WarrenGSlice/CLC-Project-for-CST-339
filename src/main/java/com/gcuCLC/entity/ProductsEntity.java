package com.gcuCLC.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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

	public ProductsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
