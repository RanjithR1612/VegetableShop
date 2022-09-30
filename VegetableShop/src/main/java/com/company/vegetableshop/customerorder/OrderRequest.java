package com.company.vegetableshop.customerorder;

import org.springframework.data.annotation.Id;

public class OrderRequest {
	
private int quantity;
private String name;



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}
