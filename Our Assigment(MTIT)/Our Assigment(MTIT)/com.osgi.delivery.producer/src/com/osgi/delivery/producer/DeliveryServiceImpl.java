package com.osgi.delivery.producer;

import java.util.List;


public class DeliveryServiceImpl implements DeliveryActivatorService{
	
	@Override
	public synchronized int  addItems(String deliveryName,String deliveryLocation,String deliveryItem) {

		Delivery newItem = new Delivery(DeliveryDataStore.itemsList.size() + 1, deliveryName, deliveryLocation, deliveryItem);
		DeliveryDataStore.itemsList.add(newItem);

	return 1;		
	}

	@Override
	public  synchronized int removeItems(String deliveryName) {

		boolean found = false;
		int count = -1;
		for (Delivery tempItem :DeliveryDataStore.itemsList) {
			count++;
			if (tempItem.getDeliveryName().equalsIgnoreCase(deliveryName)) {
			
				found = true;
				break;
			}
		}
		if (found) {

			DeliveryDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String deliveryName) {
		boolean found = false;
	
		for (Delivery tempItem : DeliveryDataStore.itemsList) {
		
			if (tempItem.getDeliveryName().equalsIgnoreCase(deliveryName)) {

				found = true;
				break;

			}			

		}

        return found ? 1 : -1;
		
	}

	@Override
	public List<Delivery> listItems() {

		return DeliveryDataStore.itemsList;
		}
	}
	
