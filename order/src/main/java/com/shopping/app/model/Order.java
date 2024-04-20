package com.shopping.app.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
@Document(collection = "orderdata")
public class Order {

	@Id
	private long id;
	@Email
	private String emailId;
    private Date orderDate;
    private List<Product> items;
    private double totalPrice;
    private String shippingAddress;
    private String paymentInfo;
    private String orderStatus;
//    private String shippingMethod;
//    private String additionalNotes;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(long id, @Email String emailId, Date orderDate, List<Product> items, double totalPrice,
			String shippingAddress, String paymentInfo, String orderStatus) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.orderDate = orderDate;
		this.items = items;
		this.totalPrice = totalPrice;
		this.shippingAddress = shippingAddress;
		this.paymentInfo = paymentInfo;
		this.orderStatus = orderStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", emailId=" + emailId + ", orderDate=" + orderDate + ", items=" + items
				+ ", totalPrice=" + totalPrice + ", shippingAddress=" + shippingAddress + ", paymentInfo=" + paymentInfo
				+ ", orderStatus=" + orderStatus + "]";
	}
	
}