package com.osgi.stokkeeper.producer;

import java.util.List;


public interface StockKeeperService {

	List<Stock> listItems();

	public  int  addItems(String stockName,int quantity);   //Add the new items to the item store
	public   int removeItems1(String itemName);             //Removes the items from the store
	public   int searchitems(String itemName);             //Searches and item by name
	public   List<Stock> listItems1();                   //Returns the item store

}
