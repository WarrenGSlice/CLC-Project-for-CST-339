package com.gcuCLC.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
 * 1. Entity - Order Entity
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@Table("ORDERS")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer orderId;
	
	@Column("customer_name")
	String customerName;
	
	@Column("company_name")
	String companyName;
	
	@Column("delivery_date")
	String deliveryDate;
	
	@Column("delivery_price")
	Integer deliveryPrice;
	
	@Column("delivery_status")
	String deliveryStatus;
	
	@Column("payment")
	String payment;

	/**
	 * Default No Args Constructor Method
	 */
	public OrderEntity() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Non-Default Constructor to help get Order Properties 
	 * From Database
	 * @param order - Auto Injected Order Entity
	 */
	public OrderEntity(OrderEntity order) {
		orderId = order.getOrderId();
		companyName = order.getCompanyName();
		customerName = order.getCustomerName();
		deliveryDate = order.getDeliveryDate();
		deliveryPrice = order.getDeliveryPrice();
		deliveryStatus = order.getDeliveryStatus();
		payment = order.getPayment();
	}
	
	/**
	 * Not Used Method that could have a purpose
	 * Similar to a Constructor and needs 
	 * specific values set
	 * @param input - String
	 * @return OrderEntity Object
	 */
	public OrderEntity Construct(String input) {
		orderId = -1;
		companyName = "";
		customerName = "";
		deliveryDate = "";
		deliveryPrice = -1;
		deliveryStatus = "";
		payment = "";
		return new OrderEntity(orderId = -1, companyName = "", customerName = "", deliveryDate = "", deliveryPrice = -1, deliveryStatus = "", payment = "");
	}

	/**
	 * Order Entity Constructor Method
	 * @param orderId - Integer
	 * @param companyName - String
	 * @param customerName - String
	 * @param deliveryDate - String
	 * @param deliveryPrice - Integer
	 * @param deliveryStatus - String
	 * @param payment - String
	 */
	public OrderEntity(Integer orderId,  String companyName, String customerName,String deliveryDate, Integer deliveryPrice,
			 String deliveryStatus, String payment) {
		this.orderId = orderId;
		this.companyName = companyName;
		this.customerName = customerName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.deliveryStatus = deliveryStatus;
		this.payment = payment;
	}

	/**
	 * Order Entity Constructor Method
	 * @param companyName - String
	 * @param customerName - String
	 * @param deliveryDate - String
	 * @param deliveryPrice - Integer
	 * @param deliveryStatus - String
	 * @param payment - String
	 */
	public OrderEntity( String companyName, String customerName, String deliveryDate, Integer deliveryPrice,
			String deliveryStatus, String payment) {
		this.companyName = companyName;
		this.customerName = customerName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	/**
	 * Order Entity Constructor Method
	 * @param orderId - Integer
	 */
	public OrderEntity(Integer orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * Order Entity Constructor Method
	 * @param companyName - String
	 * @param deliveryDate - String
	 * @param deliveryPrice - Integer
	 * @param payment - String
	 * @param deliveryStatus - String
	 */
	public OrderEntity(String companyName, String deliveryDate, Integer deliveryPrice,
			String payment, String deliveryStatus) {
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	/**
	 * Order Entity Constructor Method
	 * @param deliveryDate - String
	 * @param deliveryPrice - Integer
	 * @param payment - String
	 * @param deliveryStatus - String
	 */
	public OrderEntity(String deliveryDate, Integer deliveryPrice,
			String payment, String deliveryStatus) {
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	/**
	 * Order Entity Constructor Method
	 * @param companyName - String
	 * @param customerName - String
	 * @param deliveryDate - String
	 */
	public OrderEntity( String companyName, String customerName, String deliveryDate) {
		this.customerName = customerName;
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
	}
	
	/**
	 * Order Entity Constructor Method
	 * @param companyName - String
	 * @param customerName - String
	 */
	public OrderEntity( String companyName, String customerName) {
		this.customerName = customerName;
		this.companyName = companyName;
	}
	
	/**
	 * Order Entity Constructor Method
	 * @param orderId - Integer
	 * @param companyName - String
	 */
	public OrderEntity(Integer orderId, String companyName) {
		this.orderId = orderId;
		this.companyName = companyName;
	}
	
	/**
	 * Order Entity Constructor Method
	 * @param orderId - Integer
	 * @param companyName - String
	 * @param customerName - String
	 */
	public OrderEntity(Integer orderId,  String companyName, String customerName) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.companyName = companyName;
	}
	
	/**
	 * Order Entity Constructor Method
	 * @param companyName - String
	 */
	public OrderEntity(String companyName) {
		this.companyName = companyName;
	}
	
	//----------------------- Getters & Setters -------------------------\\
	
	/**
	 * Getter - Order Id
	 * @return Order Id
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * Setter - Order Id
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
	 * @return - Company Name
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
	 * @return - Delivery Date
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
	public Integer getDeliveryPrice() {
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
	 * Setter - Payment Type
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
	 * To-String Method For returning formatted console output
	 */
	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId +  ", companyName=" + companyName + ", customerName=" + customerName 
				+ ", deliveryDate=" + deliveryDate + ", deliveryPrice=" + deliveryPrice +  ", deliveryStatus=" + deliveryStatus + ", payment=" + payment
				+"]";
	}
	
	/**
	 * Method to Populate Order Details correctly to or from Database
	 * @param bean2 - Auto Injected Order Entity Entity
	 */
	public void populate(OrderEntity bean2) {
		OrderEntity bean = new OrderEntity();
		bean.setOrderId(bean.getOrderId());
		bean.setCustomerName(bean.getCustomerName());
		bean.setCompanyName(bean.getCompanyName());
		bean.setDeliveryDate(bean.getDeliveryDate());
		bean.setDeliveryPrice(bean.getDeliveryPrice());
		bean.setPayment(bean.getPayment());
		bean.setDeliveryStatus(bean.getDeliveryStatus());
	}
	
}
