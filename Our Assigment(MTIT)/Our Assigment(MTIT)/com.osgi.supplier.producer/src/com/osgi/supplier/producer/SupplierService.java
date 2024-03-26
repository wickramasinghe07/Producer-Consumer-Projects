package com.osgi.supplier.producer;

import java.util.List;

public interface SupplierService {
	
List<Supplier> listItems();

      int  addItems(String itemName,String itemLocation,double itemPrice,double itemDiscount);//Adds the new items to the item list
	  int  updateItems(String updatedItemName,String updatedItemLocation,double updatedItemPrice,double updatedItemDiscount);//Updates the item details
      int  removeItems(String itemName);//Removes the items from the list
	  int  searchitems(String itemName);//Searches and item by name

	int searchItems(String itemName);

	int searchitems1(String itemName);
	



}
