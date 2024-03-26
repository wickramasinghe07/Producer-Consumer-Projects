package com.osgi.managert.producer;

import java.util.List;





public interface ManagerActivaterService {

	List<Manager> listItem();
	
    public  int  addItems(String Managername,String model,int hours,int rate);//Adds the new items to the item list
	
	public   int removeItems1(String model);//Removes the items from the list
	
	public   int searchitems(String model);//Searches and item by name
	
	public   List<Manager> listItems1();//Returns the item 

	

	

	
}
