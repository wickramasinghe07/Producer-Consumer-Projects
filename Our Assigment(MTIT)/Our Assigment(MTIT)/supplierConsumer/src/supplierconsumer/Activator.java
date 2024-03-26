package supplierconsumer;


import com.osgi.supplier.producer.Supplier;
import com.osgi.supplier.producer.SupplierService;
import java.util.List;
import java.util.Scanner;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;




public class Activator implements BundleActivator {
	ServiceReference<SupplierService> SupplierServiceReference;
	Scanner input = new Scanner(System.in);
	boolean exit = false;
	

	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("============Online Market Place.============");
		
	        SupplierServiceReference = context.getServiceReference(SupplierService.class);
	        if (SupplierServiceReference != null) {
	        	SupplierService supplierService = context.getService(SupplierServiceReference);
	        	if(supplierService != null) {
		
		          do {
		            int selection ;
		           do {
			
			System.out.println("----------------------------Welcome to Online Market Place Supplier Interface-------------------------------");

            System.out.println("Please Select an option to continue.....");
            System.out.println("Options");
            System.out.println("1.Add  new Item to list Online Market Place ");
            System.out.println("2.Remove  an Item in existing Online Market Place ");
            System.out.println("3.Search  available List item by name");
            System.out.println("4.List Item");
            System.out.println("5.Exit to Supplier Interface");

            System.out.println("Enter your selection...");
            selection = input.nextInt();

            input.nextLine();
            if (selection == 5) {
                exit = true;
            }

            if (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5) {
                System.out.println("Please enter a valid selection");
            }
        } while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5);


        String backToHome = null;
        SupplierService SupplierService = context.getService(SupplierServiceReference);
        if (selection == 1) {
            do {
                System.out.println("Enter new item to delivery list : ");
                String itemName = input.nextLine();

                System.out.println("Enter delivery location : ");
                String itemLocation = input.nextLine();

                System.out.println("Enter item Price: ");
                double itemPrice = input.nextDouble();

                System.out.println("Enter Discount Percentage (%): ");
                double itemDiscount = input.nextDouble();
                input.nextLine();

                int result = supplierService.addItems(itemName, itemLocation, itemPrice, itemDiscount);//Consumes the ManagerService addItems()
                String msg = (result == 1) ? "Successfully added the item to delivery List!" : "please enter a valid Item name";
                System.out.println(msg);
                System.out.println("Press 0 to navigate back to home or press any other key to continue....");

                backToHome = input.nextLine();

            } while (!(backToHome.equals("0")));

        } else if (selection == 2) {
            do {
                System.out.println("Enter the item name:");

                String itemName = input.nextLine();
                int result = supplierService.removeItems(itemName);
                String msg = (result == 1) ? "Successfully Removed the item from the list!" : "please enter a valid item name";
                System.out.println(msg);
                System.out.println("Press 0 to navigate back to home or press any other key to continue....");

                backToHome = input.nextLine();

            } while (!(backToHome.equals("0")));

        } else if (selection == 3) {
            do {
                System.out.println("Enter the item name");

                String itemName = input.nextLine();
                int result = supplierService.searchItems(itemName);
                String msg = (result == 1) ? "Item found!" : "Item not found!";
                System.out.println(msg);

                System.out.println("Press 0 to go back to home or press any key to continue....");

                backToHome = input.nextLine();

            } while (!(backToHome.equals("0")));

        } else if (selection == 4) {
            do {
                List<Supplier> itemsList = supplierService.listItems();//Consumes the ManagerService listItems()
                System.out.println("-----------------------------------Item list--------------------------------------------");
                System.out.println("Item ID:" + "\t" + "Item Name:" + "\t" + "Item Location:" + "\t" + "Item Price:" + "\t" + "Discount Percentage:" + "\t" + "Price After the Discount:" + "\t");

                for (Supplier tempItem : itemsList) {
                    System.out.println(tempItem.getitemID() + "\t\t" + tempItem.getItemName() + "\t\t" + tempItem.getItemLocation() + "\t\t" + tempItem.getItemPrice() + "\t\t" + tempItem.getDiscount() + "%\t\t\t" + tempItem.getFinalPriceinItem() + "\t\n");

                }
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Press 0 to navigate back to home or press any other key to continue....");

                backToHome = input.nextLine();

            } while (!(backToHome.equals("0")));

        } else if (selection == 5) {//Exits from the Manager consumer program
            return;
        }
    } while (!exit);
	        	 } else {
	                 System.err.println("Failed to obtain SupplierService instance.");
	             }
	         } else {
	             System.err.println("SupplierService reference is null.");
	         }
	     }

	     @Override
	     public void stop(BundleContext context) throws Exception {
	         System.out.println("============Online Market Place consumer stopped.============");
	         if (SupplierServiceReference != null) {
	             context.ungetService(SupplierServiceReference);
	         }
	     }
	 }		          
