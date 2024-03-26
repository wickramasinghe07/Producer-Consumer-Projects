package com.osgi.delivery.producer;

import java.util.List;



public interface DeliveryActivatorService {

	List<Delivery> listItems();

	public  int  addItems(String deliveryName,String DeliveryLocation,String DeliveryItem);//This adds the new items to the Item list
	public   int removeItems(String itemName);//This removes the items from the Item list
	public   int searchitems(String itemName);//This searches the item by it's name
	//public   List<Delivery> listItems1();//This returns the Item list
}
