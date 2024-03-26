package com.osgi.supplier.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {
	ServiceRegistration<?> serviceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============Welcome to Online Market Place. Service Started.============");
		SupplierService managerSer = new SupplierServiceImpl();
		serviceRegistration = context.registerService(SupplierService.class.getName(), managerSer, null); 
		
		if (serviceRegistration != null) {
            System.out.println("Service registered successfully.");
        } else {
            System.err.println("Failed to register service.");
        }
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("==============Thank you! Come Again. Service Closed.=============");
		serviceRegistration.unregister();
		System.out.println("Service unregistered.");
	}

}
