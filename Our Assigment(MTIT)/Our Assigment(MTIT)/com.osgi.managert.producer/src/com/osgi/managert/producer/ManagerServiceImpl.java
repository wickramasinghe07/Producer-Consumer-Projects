package com.osgi.managert.producer;

import java.util.List;




public class ManagerServiceImpl implements ManagerActivaterService   {

	

	@Override
	public synchronized int addItems(String Managername,String model, int hours,int rate) {
		Manager newItem = new Manager(Managername, model, hours,rate);
		ManagerDataStore.itemsList.add(newItem);
		return 1;
	}

	@Override
	public synchronized int removeItems1(String model) {
		boolean invalid = true;
		int count = -1;
		for (Manager tempItem :ManagerDataStore.itemsList) {
			count++;
			if (tempItem.getmodel().equalsIgnoreCase(model)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			ManagerDataStore.itemsList.remove(count);
			return 1;

		} else {
		return -1;
	}
	}

	@Override
	public int searchitems(String model) {
		boolean valid = false;
		
		for (Manager tempItem : ManagerDataStore.itemsList) {
		
			if (tempItem.getmodel().equalsIgnoreCase(model)) {

				valid = true;
				break;

			}			

		}
		if(valid) {
			return 1;
			
		}
		else {
			return -1;
		}
	}

	@Override
	public List<Manager> listItem() {
		
		return ManagerDataStore.itemsList;
}
	
	@Override
	public List<Manager> listItems1() {
	// TODO Auto-generated method stub
	return null;

}
}
