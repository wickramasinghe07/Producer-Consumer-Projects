package com.osgi.supplier.producer;

import java.util.Iterator;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {

    @Override
    public synchronized int addItems(String itemName, String itemLocation, double itemPrice, double discount) {
        Supplier newItem = new Supplier(SupplierDataStore.itemsList.size() + 1, itemName, itemLocation, itemPrice, discount);
        SupplierDataStore.itemsList.add(newItem);
        return 1;
    }

    @Override
    public synchronized int updateItems(String updatedItemName, String updatedItemLocation, double updatedItemPrice, double updatedItemDiscount) {
        int count = 0;
        for (Supplier tempItem : SupplierDataStore.itemsList) {
            if (tempItem.getItemName().equalsIgnoreCase(updatedItemName)) {
                tempItem.setItemName(updatedItemName);
                tempItem.setItemPrice(updatedItemPrice);
                tempItem.setDiscount(updatedItemDiscount);
                tempItem.setFinalPriceinItem(updatedItemPrice * ((100 - updatedItemDiscount) / 100.00));
                SupplierDataStore.itemsList.set(count, tempItem);
                return 1;
            }
            count++;
        }
        return -1; // Item not found
    }

    @Override
    public synchronized int removeItems(String itemName) {
        Iterator<Supplier> iterator = SupplierDataStore.itemsList.iterator();
        while (iterator.hasNext()) {
            Supplier tempItem = iterator.next();
            if (tempItem.getItemName().equalsIgnoreCase(itemName)) {
                iterator.remove();
                return 1;
            }
        }
        return -1; // Item not found
    }

    public int searchitems(String itemName) {
        for (Supplier tempItem : SupplierDataStore.itemsList) {
            if (tempItem.getItemName().equalsIgnoreCase(itemName)) {
                return 1; // Item found
            }
        }
        return -1; // Item not found
    }

    @Override
    public List<Supplier> listItems() {
        return SupplierDataStore.itemsList;
    }

	public int searchitems1(String itemName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int searchItems(String itemName) {
		// TODO Auto-generated method stub
		return 0;
	}
}