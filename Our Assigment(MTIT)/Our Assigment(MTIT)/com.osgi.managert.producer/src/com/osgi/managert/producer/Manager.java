package com.osgi.managert.producer;

public class Manager {
	private String Managername;
	private String model;
	private int hours;
	private int rate;
	private int totalsalary;
    
	public Manager(String Managername, String model,int hours,int rate) {
		super();
		this.Managername = Managername;
		this.model = model;
		this.hours = hours;
		this.rate = rate;
		
		caltotalSalary();
		
	}



	public String getManagername() {
		return Managername;
	}


	public void setManagername(String Managername) {
		this.Managername = Managername;
	}


	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}

	public int gethours() {
		return hours;
	}

	public void sethours(int hours) {
		this.hours = hours;
		
	}
	
	public int getrate() {
		return rate;
	}


	public void setrate(int rate) {
		this.rate = rate;
	}
	
	public int gettotal() {
		return totalsalary;
	}

	public void settotal(int totalsalary) {
		this.totalsalary = totalsalary;
	}


	void caltotalSalary() {
		this.totalsalary=this.hours*this.rate;
		
	}
}
