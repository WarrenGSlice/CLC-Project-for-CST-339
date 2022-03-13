package com.gcuCLC.model;

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
 * 1. Model - Product Model
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

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
	
	/**
	 * Product Model Constructor Method
	 * @param orderId - Integer
	 * @param companyName - String
	 * @param customerName - String
	 * @param deliveryDate - String
	 * @param deliveryPrice - String
	 * @param deliveryStatus - String
	 * @param payment - String
	 */
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
	
	/**
	 * Product Model Constructor Method
	 * @param companyName - String
	 * @param customerName - String
	 * @param deliveryDate - String
	 * @param deliveryPrice - Integer
	 * @param deliveryStatus - String
	 * @param payment - String
	 */
	public ProductModel(String companyName, String customerName,  String deliveryDate, Integer deliveryPrice,
			String deliveryStatus, String payment) {
		this.customerName = customerName;
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
		
	}
	
	/**
	 * No Args Product Model Constructor Method
	 */
	public ProductModel() {
		
	}
	
	/**
	 * Non-Default Constructor (Blank)
	 * @param input - assigned to order id (typically -1)
	 */
	public ProductModel(int input) {
		super();
		this.orderId = input;
		this.companyName = "";
		this.customerName = "";
		this.deliveryDate = "";
		this.deliveryPrice = -1;
		this.deliveryStatus = "";
		this.payment = "";	
	}

	/**
	 * Passes Properties of a Product and Stores them in an Array
	 * @param productArray - String[]
	 */
	public ProductModel(String[] productArray) {
		this.orderId = Integer.parseInt(productArray[0]);
		this.customerName = productArray[1];
		this.companyName = productArray[2];
		this.deliveryDate = productArray[3];
		this.deliveryPrice = Integer.parseInt(productArray[4]);
		this.payment = productArray[5];
		this.deliveryStatus = productArray[6];
	}
	
	/**
	 * Getter - Delivery Status
	 * @return deliveryStatus - String
	 */
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	
	/**
	 * Setter - Delivery Status
	 * @param deliveryStatus - String
	 */
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	/**
	 * Getter - Order ID
	 * @return Order ID
	 */
	public int getOrderId() {
		return orderId;
	}
	
	/**
	 * Setter - Order ID
	 * @param orderId - Integer
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * Getter - Customer Name
	 * @return Customer Name
	 */
	public String getCustomerName() {
		return customerName;
	}
	
	/**
	 * Setter - Customer Name
	 * @param customerName - String
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/**
	 * Getter - Company Name
	 * @return Company Name
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * Setter - Company Name
	 * @param companyName - String
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * Getter - Delivery Date
	 * @return Delivery Date
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}
	
	/**
	 * Setter - Delivery Date
	 * @param deliveryDate - String
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	/**
	 * Getter - delivery Price
	 * @return Delivery Price
	 */
	public Integer getDeliveryPrice() {
		return deliveryPrice;
	}
	
	/**
	 * Setter - delivery Price
	 * @param deliveryPrice - Integer
	 */
	public void setDeliveryPrice(Integer deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	
	/**
	 * Getter - Payment Type
	 * @return Payment Type
	 */
	public String getPayment() {
		return payment;
	}
	
	/**
	 * Setter - Payment Type
	 * @param payment - String
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	/**
	 * Method Helped the Constructor Pass
	 * The Correct Objects to the Array in
	 * The correct form
	 * @return formatted array of Product Model Objects
	 */
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
	
	/**
	 * Product Model toString Method
	 */
	@Override
	public String toString() {
		return "ProductModel [orderId=" + orderId  + ", companyName=" + companyName + ", customerName=" + customerName + ", deliveryDate="
				+ deliveryDate + ", deliveryPrice=" + deliveryPrice +  ", deliveryStatus="
				+ deliveryStatus + ", payment=" + payment +"]";
	}
		
}
