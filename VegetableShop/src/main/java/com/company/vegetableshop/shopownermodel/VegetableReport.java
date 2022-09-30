package com.company.vegetableshop.shopownermodel;

import org.springframework.data.annotation.Id;



public class VegetableReport implements Comparable<VegetableReport>{
	private int profit;
	private int quantitysold;
	private String name;
	private int purchaseQuantity;
	private int availableQuantity;
	@Id
	private String vegetableId;
	
	public String getName() {
		return name;
	}
	public String getVegetableId() {
		return vegetableId;
	}
	public void setVegetableId(String vegetableId) {
		this.vegetableId = vegetableId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public int getQuantitysold() {
		return quantitysold;
	}
	public void setQuantitysold(int quantitysold) {
		this.quantitysold = quantitysold;
	}

	
	public int compareTo(VegetableReport rep){
		return name.compareTo(rep.name);
	}

	

}
