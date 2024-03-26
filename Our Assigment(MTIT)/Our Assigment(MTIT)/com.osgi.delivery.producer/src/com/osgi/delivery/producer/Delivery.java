package com.osgi.delivery.producer;

public class Delivery {

	private int  deliveryID;
	private String deliveryName;
	private String deliveryLocation;
	private int deliveryChargers;
	
	public Delivery(int deliveryID, String deliveryName, String deliveryLocation, String deliveryItem) {
		super();
		this.deliveryID = deliveryID;
		this.deliveryName = deliveryName;
		this.deliveryLocation = deliveryLocation;
		this.deliveryChargers = Integer.parseInt(deliveryItem) * 20;
		
	}

	public int getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(int deliveryID) {
		this.deliveryID = deliveryID;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String Delivery_name) {
		this.deliveryName = Delivery_name;
	}

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String Delivery_Location) {
		this.deliveryLocation = Delivery_Location;
	}

	public int getDeliveryChargers() {
		return deliveryChargers;
	}

	public void setDeliveryChargers(int Delivery_Chargers) {
		this.deliveryChargers = Delivery_Chargers;
	}
}
