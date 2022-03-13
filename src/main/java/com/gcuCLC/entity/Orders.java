package com.gcuCLC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
 * 1. Entity - Orders 
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderId;
	
	@Column(length=55, nullable=false)
	String customerName;
	
	@Column(length=55, nullable=false)
	String companyName;
	
	@Column(length=55, nullable=false)
	String deliveryDate;
	
	@Column(length=11, nullable=false)
	Integer deliveryPrice;
	
	@Column(length=45, nullable=false)
	String payment;
	
	@Column(length=20, nullable=false)
	String deliveryStatus;

	//-----------------------Constructors-------------------------\\
	
	/**
	 * Empty Constructor Method
	 */
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Orders Constructor Method
	 * @param orderId - int
	 * @param companyName - String
	 * @param customerName - String
	 * @param deliveryDate - String
	 * @param deliveryPrice - Integer
	 * @param deliveryStatus - String
	 * @param payment - String
	 */
	public Orders(int orderId,  String companyName, String customerName, String deliveryDate, Integer deliveryPrice,
			String deliveryStatus, String payment) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
	}

	/**
	 * Orders Constructor Method
	 * @param companyName - String
	 * @param customerName - String
	 * @param deliveryDate - String
	 * @param deliveryPrice - Integer
	 * @param deliveryStatus - String
	 * @param payment - String
	 */
	public Orders(String companyName, String customerName,  String deliveryDate, Integer deliveryPrice,
			String deliveryStatus, String payment) {
		this.customerName = customerName;
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	/**
	 * Orders Constructor Method
	 * @param orderId - int
	 */
	public Orders(int orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * Orders Constructor Method
	 * @param companyName - String
	 * @param deliveryDate - String
	 * @param deliveryPrice - Integer
	 * @param payment - String
	 * @param deliveryStatus - String
	 */
	public Orders(String companyName, String deliveryDate, Integer deliveryPrice,
			String payment, String deliveryStatus) {
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	/**
	 * Orders Constructor Method
	 * @param deliveryDate - String
	 * @param deliveryPrice - Integer
	 * @param payment - String
	 * @param deliveryStatus - String
	 */
	public Orders(String deliveryDate, Integer deliveryPrice,
			String payment, String deliveryStatus) {
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	/**
	 * Orders Constructor Method
	 * @param companyName - String
	 * @param customerName - String
	 * @param deliveryDate - String
	 */
	public Orders(String companyName, String customerName,  String deliveryDate) {
		this.customerName = customerName;
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
	}
	
	/**
	 * Orders Constructor Method
	 * @param companyName  -String
	 * @param customerName - String
	 */
	public Orders(String companyName, String customerName) {
		this.customerName = customerName;
		this.companyName = companyName;
	}
	
	/**
	 * Orders Constructor Method
	 * @param orderId - int
	 * @param companyName - String
	 */
	public Orders(int orderId, String companyName) {
		this.orderId = orderId;
		this.companyName = companyName;
	}
	
	/**
	 * Orders Constructor Method
	 * @param orderId - int
	 * @param companyName - String
	 * @param customerName - String
	 */
	public Orders(int orderId, String companyName, String customerName) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.companyName = companyName;
	}
	
	/**
	 * Orders Constructor Method
	 * @param companyName - String
	 */
	public Orders(String companyName) {
		this.companyName = companyName;
	}
	
	//-------------------------Getters & Setters------------------------\\
	
	/**
	 * Getter - Order Id
	 * @return Order Id
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Setter - Order Id
	 * @param orderId - int
	 */
	public void setOrderId(int orderId) {
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
	 * Getter - Delivery Price
	 * @return Delivery Price
	 */
	public int getDeliveryPrice() {
		return deliveryPrice;
	}

	/**
	 * Setter - Delivery Price
	 * @param deliveryPrice - Integer
	 */
	public void setDeliveryPrice(Integer deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	/**
	 * Getter - Payment Type
	 * @return - Payment Type
	 */
	public String getPayment() {
		return payment;
	}

	/**
	 * Setter - payment type
	 * @param payment - String
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}

	/**
	 * Getter - Delivery Status
	 * @return Delivery Status
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
	 * To-String Method For Formatting output on Console
	 */
	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId +  ", companyName=" + companyName + ", customerName=" + customerName
				+ ", deliveryDate=" + deliveryDate + ", deliveryPrice=" + deliveryPrice +  ", deliveryStatus=" + deliveryStatus + ", payment=" + payment
				+"]";
	}
}
