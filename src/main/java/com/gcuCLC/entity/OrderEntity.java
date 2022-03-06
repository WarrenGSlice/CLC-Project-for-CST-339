package com.gcuCLC.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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

	public OrderEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderEntity(OrderEntity order) {
		orderId = order.getOrderId();
		companyName = order.getCompanyName();
		customerName = order.getCustomerName();
		deliveryDate = order.getDeliveryDate();
		deliveryPrice = order.getDeliveryPrice();
		deliveryStatus = order.getDeliveryStatus();
		payment = order.getPayment();
	}
	
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

	public OrderEntity( String companyName, String customerName, String deliveryDate, Integer deliveryPrice,
			String deliveryStatus, String payment) {
		this.companyName = companyName;
		this.customerName = customerName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	public OrderEntity(Integer orderId) {
		this.orderId = orderId;
	}
	
	public OrderEntity(String companyName, String deliveryDate, Integer deliveryPrice,
			String payment, String deliveryStatus) {
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	public OrderEntity(String deliveryDate, Integer deliveryPrice,
			String payment, String deliveryStatus) {
		this.deliveryDate = deliveryDate;
		this.deliveryPrice = deliveryPrice;
		this.payment = payment;
		this.deliveryStatus = deliveryStatus;
	}
	
	public OrderEntity( String companyName, String customerName, String deliveryDate) {
		this.customerName = customerName;
		this.companyName = companyName;
		this.deliveryDate = deliveryDate;
	}
	
	public OrderEntity( String companyName, String customerName) {
		this.customerName = customerName;
		this.companyName = companyName;
	}
	
	public OrderEntity(Integer orderId, String companyName) {
		this.orderId = orderId;
		this.companyName = companyName;
	}
	
	public OrderEntity(Integer orderId,  String companyName, String customerName) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.companyName = companyName;
	}
	
	public OrderEntity(String companyName) {
		this.companyName = companyName;
	}
	
	public Integer getOrderId() {
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

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	// Not sure what this does
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if ( o == null || getClass() != o.getClass()) return false;
//		OrderEntity orderEntity = (OrderEntity) o;
//		return orderId == orderEntity.orderId && Objects.equals(orderId, orderEntity.orderId);
//	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(orderId, companyName);
//	}
	
	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId +  ", companyName=" + companyName + ", customerName=" + customerName 
				+ ", deliveryDate=" + deliveryDate + ", deliveryPrice=" + deliveryPrice +  ", deliveryStatus=" + deliveryStatus + ", payment=" + payment
				+"]";
	}
	
//	@Override
//    public String toString() {
//
//        var builder = new StringBuilder();
//        builder.append("OrderEntity{orderId=").append(orderId).append(", companyName=")
//                .append(companyName).append(", customerName=")
//                .append(customerName).append("}");
//
//        return builder.toString();
//    }
	
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
