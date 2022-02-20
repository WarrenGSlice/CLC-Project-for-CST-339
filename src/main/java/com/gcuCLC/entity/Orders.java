package com.gcuCLC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



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

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderId,  String companyName, String customerName, String deliveryDate, Integer deliveryPrice,
			String deliveryStatus, String payment) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
	}

	public Orders(String companyName, String customerName,  String deliveryDate, Integer deliveryPrice,
			String deliveryStatus, String payment) {
		this.customerName = customerName;
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	public Orders(int orderId) {
		this.orderId = orderId;
	}
	
	public Orders(String companyName, String deliveryDate, Integer deliveryPrice,
			String payment, String deliveryStatus) {
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	public Orders(String deliveryDate, Integer deliveryPrice,
			String payment, String deliveryStatus) {
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	public Orders(String companyName, String customerName,  String deliveryDate) {
		this.customerName = customerName;
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
	}
	
	public Orders(String companyName, String customerName) {
		this.customerName = customerName;
		this.companyName = companyName;
	}
	
	public Orders(int orderId, String companyName) {
		this.orderId = orderId;
		this.companyName = companyName;
	}
	
	public Orders(int orderId, String companyName, String customerName) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.companyName = companyName;
	}
	
	public Orders(String companyName) {
		this.companyName = companyName;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
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

	public int getDeliveryPrice() {
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

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId +  ", companyName=" + companyName + ", customerName=" + customerName
				+ ", deliveryDate=" + deliveryDate + ", deliveryPrice=" + deliveryPrice +  ", deliveryStatus=" + deliveryStatus + ", payment=" + payment
				+"]";
	}
}
