package com.company.vegetableshop.customerorder;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("order")
public class Order {
	
	//private List<OrderRequest> orderRequests;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	private float totalCost;
	@Id
	private String orderId;
	
	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	
	//public List<OrderRequest> getOrderRequests() {
		//return orderRequests;
	//}
	//public void setOrderRequests(List<OrderRequest> orderRequests) {
		//this.orderRequests = orderRequests;
	//}
	
	
	
	
	

	
	
	

}
