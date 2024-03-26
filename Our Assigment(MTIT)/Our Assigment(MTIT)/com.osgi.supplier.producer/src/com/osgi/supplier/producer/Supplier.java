package com.osgi.supplier.producer;

public class Supplier {

	private int  itemId;
	private String itemName;
    private String itemLocation;
	private double itemPrice;
	private double discount;
	private double finalPriceinItem;
	
	public Supplier(int itemId, String itemName, String itemLocation, double itemPrice, double discount) {
		
		this.itemId = itemId;
		this.itemName = itemName;
        this.itemLocation = itemLocation;
		this.itemPrice = itemPrice;
		this.discount = discount;
		calculateFinalPriceInItem();
		
	}
	

	public int getitemID() {
		return itemId;
	}

	public void setItemID(int itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String ItemName) {
		this.itemName = itemName;
	}

        
        public String getItemLocation() {
		return itemLocation;
	}


	public void setItemLocation(String ItemLocation) {
		this.itemLocation = itemLocation;
	}


	


	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalPriceinItem() {
		return finalPriceinItem;
	}

	public void setFinalPriceinItem(double finalPriceinItem) {
		this.finalPriceinItem = finalPriceinItem;
	}


	private void calculateFinalPriceInItem() {
		this.finalPriceinItem = itemPrice * ((100.00- discount)/100.00) ;
		// TODO Auto-generated method stub
		
	}
	
	

}
