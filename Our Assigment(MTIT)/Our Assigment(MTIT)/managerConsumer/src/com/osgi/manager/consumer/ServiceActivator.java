package com.osgi.manager.consumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.osgi.managert.producer.Manager;
import com.osgi.managert.producer.ManagerActivaterService;



public class ServiceActivator implements BundleActivator {
	ServiceReference ManagerService;
	Scanner input = new Scanner(System.in);
	
	boolean exit = false;
	
	@Override
	
	public void start(BundleContext context) throws Exception {//start life cycle method
		System.out.println("============Market place Manager consumer started.============");
		ManagerService = context.getServiceReference(ManagerActivaterService.class.getName());
		
		@SuppressWarnings("unchecked")
		ManagerActivaterService  managerActivaterService = (ManagerActivaterService) context.getService(ManagerService);//Instance of managerService
		do {
			int selection = 7;
			do {
			System.out.println("----------------------------Welcome to Online MarketPlace -------------------------------");
			System.out.println("Please Select an option to continue.....");
			System.out.println("Options");
			System.out.println("1.Add new manager Name ");
			System.out.println("2.Remove Name");
			System.out.println("3.List Of Current Manager");
			System.out.println("4.Search  available Manager by model");
			System.out.println("5.Exit to Manager Interface");
			
			
			
			System.out.println("Enter your selection...");
			 selection = input.nextInt();
			 
			 input.nextLine();
			 if(selection == 5) {
				 exit = true;
			 }
			 
			 if(selection !=1 &&  selection !=2 && selection !=3 && selection !=4 && selection!=5) {
				 System.out.println("Please enter a valid selection");
			 }
			}while(selection !=1  && selection !=2 && selection !=3 && selection !=4 && selection!=5 );
			
		
			
			  String  backToHome = null;
				if (selection == 1) {//Handles the adding process of new items to the list
					do {
					System.out.println("Enter the Manager Name..");
					String model = input.nextLine();

					
					
					System.out.println("Enter The hours worked..");
					int hours = input.nextInt();
					
					System.out.println("Enter the Rate of the manager..");
					int rate = input.nextInt();
					
					System.out.println("Enter The Manager type..");
					String Managername = input.nextLine();
					Managername=input.nextLine();
					
					int result =managerActivaterService.addItems(Managername, model,hours,rate);//Consumes the ManagerService addItems()
					 String msg = (result ==1) ? "Successfully added the Stock!" :"please enter a valid name";
					   System.out.println(msg);
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}
	
					while(!(backToHome.equals("0")));

				}
				else if (selection == 2) {//Handles the removing process of an existing item in the list 
					do {
					System.out.println("Enter the Manager name need to remove..:");

					String Managername = input.nextLine();
					int result =managerActivaterService.removeItems1(Managername);//Consumes the ManagerService removeItems()
					   String msg = (result ==1) ? "Successfully Removed the item!" :"please enter a valid name";
					   System.out.println(msg);
		              System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}
					
					while(!(backToHome.equals("0")));

				}
				else if(selection == 3) {//Handles displaying all items in the list
					do {
						List<Manager> itemsList =managerActivaterService.listItem();//Consumes the ManagerService listItems()
						System.out.println("-----------------------------------Phone Stock list--------------------------------------------");
						System.out.println("Managername:"+"\t"+"\t" +"Model:"+"\t"+"\t" +"Hours:"+"\t" +"    rate:"+"\t"+"\t" +"Total Salary:"+"\t" );
						
					for(Manager tempItem: itemsList ) {
						System.out.println(tempItem.getmodel()+"\t         "+tempItem.getManagername()+"\t         "+tempItem.gethours()+"\t         "+tempItem.getrate()+"\t      "+tempItem.gettotal()+"\t        \n");
										
					}
					System.out.println("-----------------------------------------------------------------------------------------");
		            System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}
					
					while(!(backToHome.equals("0")));

				}
				else if(selection == 4) {//Handles the searching process of an existing item in the list
					do {
					
					System.out.println("Enter the Manager name to search");
					

					String Managername = input.nextLine();
					int result =managerActivaterService.searchitems(Managername);//Consumes the ManagerService searchItems()
					 String msg = (result ==1) ? "Item found!" :"Item not found!";
					   System.out.println(msg);
					
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}
					
					while(!(backToHome.equals("0")));
				}
				else if(selection == 5) {//Exits form the Manager consumer program
					return;
				}
			}while(!exit);
			}
			
			@Override
			public void stop(BundleContext context) throws Exception {//stop life cycle method
				System.out.println("============Manager consumer stopped.============");
				context.ungetService(ManagerService);
			}


}
