package com.osgi.stokkeeper.producer;

public class Stock {

	private int  stockId;
	private String stockName;
	private int quantity;

	
	public Stock(int stockId, String stockName, int quantity) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.quantity = quantity;
	
		
	}
	

	public int getStockID() {
		return stockId;
	}

	public void setStockID(int stockId) {
		this.stockId = stockId;
	}


	public String getStockName() {
		return stockName;
	}


	public void setStockName(String stockName) {
		this.stockName = stockName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
