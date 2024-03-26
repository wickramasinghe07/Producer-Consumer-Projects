package com.osgi.delivery.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {

	ServiceRegistration<?> serviceRegisterer;
	@Override
	public void start(BundleContext context) throws Exception {//The Life cycle method start
		System.out.println("============Online Market Place Service Started.============");
		DeliveryActivatorService managerSer = new DeliveryServiceImpl();
		serviceRegisterer = context.registerService(DeliveryActivatorService.class, managerSer, null); //Registering the Manager Service
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {// The Life cycle method stop
		System.out.println("==============Online Market Place  Service Stoped.=============");
		serviceRegisterer.unregister();
	}

}
