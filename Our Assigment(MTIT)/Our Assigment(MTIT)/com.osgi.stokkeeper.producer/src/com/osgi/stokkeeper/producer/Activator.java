package com.osgi.stokkeeper.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {

	ServiceRegistration<?> serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("============Welcome to Online Market Place . let the journey begin.============");
		StockKeeperService managerSer = new StockKeeperServiceImpl();
		serviceRegisterer = context.registerService(StockKeeperService.class.getName(), managerSer, null); 
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("==============Thank you! feel free to visit us again. your journey comes to an end.=============");
		serviceRegisterer.unregister();
	}

}
