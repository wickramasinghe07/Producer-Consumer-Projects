package stockkeeperconsumer;

import com.osgi.stokkeeper.producer.Stock;
import com.osgi.stokkeeper.producer.StockKeeperService;
import java.util.List;
import java.util.Scanner;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;



public class Activator implements BundleActivator {

	ServiceReference StockKeeperServiceReference;
	Scanner input = new Scanner(System.in);

	boolean exit = false;

	@Override
	public void start(BundleContext context) throws Exception {    
		
	
		StockKeeperServiceReference = context.getServiceReference(StockKeeperService.class.getName());
		
		@SuppressWarnings("unchecked")
		
		StockKeeperService  StockKeeperService = (StockKeeperService) context.getService(StockKeeperServiceReference);		//Instance of managerService
		
		do {
		int selection = 7;
		do {
		System.out.println("\n--------------Welcome to Online Market Place. A place where you can find anything you want.--------------- \n");
	
		System.out.println("To proceed, choose one of the options.... \n");
		
		System.out.println("1.Add items here to stock. ");
		System.out.println("2.Delete an existing objects");
		System.out.println("3.Items for purchase at the shop");
		System.out.println("4.Browse for available items by name.");
		System.out.println("5.Return to the stockkeeper interface. \n");
		
		System.out.println("Insert your preference here. :");
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
		if (selection == 1) {//Handles the adding new items to the store
			do {
			System.out.println("Enter the New Item Name: ");
			String stockName = input.nextLine();

			System.out.println("Enter the stock quantity: ");
			int quantity = input.nextInt();
			
			input.nextLine();
			
			
			int result =StockKeeperService.addItems(stockName, quantity);
			String msg = (result ==1) ? "The item was successfully added! \n" : "Please enter a valid name.";
			System.out.println(msg);
			System.out.println("Hit 0 to return to the home�screen, or any other key to continue...");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if (selection == 2) {//Handles the removing an existing item in the store
			do {
			System.out.println("Enter the name of the item to be removed.:");

			String stockName = input.nextLine();
			int result =StockKeeperService.removeItems1(stockName);
			   String msg = (result ==1) ? "The item was successfully removed! \n" :"please enter a valid name";
			   System.out.println(msg);
              System.out.println("Hit 0 to return to the home�screen, or any other key to continue...");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 3) {//Handles displaying all items in the store
			do {
				List<Stock> itemsList =StockKeeperService.listItems();//Consumes the ManagerService listItems()
				System.out.println("=================Products available in stock================");

				System.out.println("Item ID:"+"\t"+"Item Name:"+"\t"+"Quantity:"+"\t" );
				
			for(Stock tempItem: itemsList ) {
				System.out.println(tempItem.getStockID()+"\t\t"+tempItem.getStockName()+"\t\t"+tempItem.getQuantity()+"\t ");
								
			}
			System.out.println("===================================================");
            System.out.println("Hit 0 to return to the home�screen, or any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 4) {//Handles the searching process of an existing item in the store
			do {
			
			System.out.println("Enter the product details to be searched.");
			

			String stockName = input.nextLine();
			int result =StockKeeperService.searchitems(stockName);
			 String msg = (result ==1) ? "Item found!" :"Item not found!";
			   System.out.println(msg);
			
			System.out.println("Hit 0 to return to the home�screen, or any other key to continue...");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));
		}
		else if(selection == 5) { //Exits form the consumer program
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop life cycle method
		System.out.println("============Online Market Place consumer component is over============");
		context.ungetService(StockKeeperServiceReference);
	}


}
