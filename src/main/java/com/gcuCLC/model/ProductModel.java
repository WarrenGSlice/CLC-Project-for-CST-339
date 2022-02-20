package com.gcuCLC.model;

/** * * * * * * * * * * * * * * *
 * CST-339 CLC Milestone Project
 * Order Management Application *
 * Created by Warren Peterson,* *
 * Jonathan Levan, Ivan Gudino  *
 * * * * * * * * * * * * * * * **/ 

// Order Properties to be used with Login Controller -> doLogin(reDirect)
public class ProductModel {
	
	// Variables
	public Integer orderId;
	public String customerName;
	public String companyName;
	public String deliveryDate;
	public Integer deliveryPrice;
	public String payment;
	public String deliveryStatus;
	
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Integer getDeliveryPrice() {
		return deliveryPrice;
	}
	public void setDeliveryPrice(Integer deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public ProductModel(Integer orderId,  String companyName, String customerName,String deliveryDate, Integer deliveryPrice,
			String deliveryStatus, String payment) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	public ProductModel(String companyName, String customerName,  String deliveryDate, Integer deliveryPrice,
			String deliveryStatus, String payment) {
		this.customerName = customerName;
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
		
	}
	
	public ProductModel() {
		
	}
	// Passes properties of a Product and stores them an an array
	public ProductModel(String[] productArray) {
		this.orderId = Integer.parseInt(productArray[0]);
		this.customerName = productArray[1];
		this.companyName = productArray[2];
		this.deliveryDate = productArray[3];
		this.deliveryPrice = Integer.parseInt(productArray[4]);
		this.payment = productArray[5];
		this.deliveryStatus = productArray[6];
	}
	// Helps the constructor pass the correct objects to the array in the correct form
	public String[] ToArray() {
		return new String[] {
				orderId.toString(),
				
				companyName,
				customerName,
				deliveryDate,
				deliveryPrice.toString(),
				
				deliveryStatus,
				payment,
		};
	}
	@Override
	public String toString() {
		return "ProductModel [orderId=" + orderId  + ", companyName=" + companyName + ", customerName=" + customerName + ", deliveryDate="
				+ deliveryDate + ", deliveryPrice=" + deliveryPrice +  ", deliveryStatus="
				+ deliveryStatus + ", payment=" + payment +"]";
	}
	
	
	
	
	
}
