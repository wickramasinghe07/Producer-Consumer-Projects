package com.osgi.managert.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class ServiceActivator implements BundleActivator {

ServiceRegistration serviceRegisterer;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("============Online Market place producer service started.============");
		ManagerActivaterService managerSer = new ManagerServiceImpl();
		serviceRegisterer = context.registerService(ManagerActivaterService.class.getName(), managerSer, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("==============Online Market place producer service closed.=============");
		serviceRegisterer.unregister();
	

}
}
