package com.osgi.stokkeeper.producer;

import java.util.List;




public class StockKeeperServiceImpl implements StockKeeperService {


	@Override
	public synchronized int  addItems(String stockName,int quantity) {

		
		Stock newItem = new Stock(StockKeeperDataStore.itemsList.size() + 1, stockName, quantity);
		StockKeeperDataStore.itemsList.add(newItem);

	return 1;		
	}
	
	@Override
	public  synchronized int removeItems1(String stockName) {

		boolean invalid = true;
		int count = -1;
		for (Stock tempItem :StockKeeperDataStore.itemsList) {
			count++;
			if (tempItem.getStockName().equalsIgnoreCase(stockName)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			StockKeeperDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String stockName) {
		boolean valid = false;
	
		for (Stock tempItem : StockKeeperDataStore.itemsList) {
		
			if (tempItem.getStockName().equalsIgnoreCase(stockName)) {

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
	public List<Stock> listItems() {

		return StockKeeperDataStore.itemsList;
	}

	@Override
	public List<Stock> listItems1() {
		// TODO Auto-generated method stub
		return null;
	
	}

}
