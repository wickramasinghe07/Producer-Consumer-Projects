package deliveryconsumer;

import com.osgi.delivery.producer.Delivery;
import com.osgi.delivery.producer.DeliveryActivatorService;
import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;



public class Activator implements BundleActivator {

    ServiceReference<DeliveryActivatorService> deliveryService;
    Scanner input = new Scanner(System.in);

    boolean exit = false;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("============Delivery Service Consumer Started.============");

        deliveryService = context.getServiceReference(DeliveryActivatorService.class);

        DeliveryActivatorService deliveryActivaterService = context.getService(deliveryService);

        do {
            int selection;
            do {
                System.out.println("----------------------------Welcome to Online Market Place Service-------------------------------");
                System.out.println("Please Select an Option to continue.....");
                System.out.println("================Options=================");
                System.out.println("1.Calculate the Delivery Service chargers ");
                System.out.println("2.Remove an existing Delivery detail from the List");
                System.out.println("3.List Of Delivery Details");
                System.out.println("4.Search Delivery Details By the Name");
                System.out.println("5.Exit to Delivery Home");
                System.out.println();
                System.out.println("Enter your Choice...");
                selection = input.nextInt();

                if (selection == 5) {
                    exit = true;
                }

                if (selection < 1 || selection > 5) {
                    System.out.println("Please enter a valid Choice");
                }
            } while (selection < 1 || selection > 5);

            String backToHome;
            switch (selection) {
                case 1:
                    do {
                        System.out.println("Enter the Delivery Name");
                        String deliveryName = input.next(); // Use next() for single word input

                        System.out.println("Enter the Delivery Location");
                        String deliveryLocation = input.next(); // Use next() for single word input

                        System.out.println("Enter The Delivery Location Distance (K.M)");
                        String deliveryItem = input.next(); // Use next() for single word input

                        int result = deliveryActivaterService.addItems(deliveryName, deliveryLocation, deliveryItem);
                        String msg = (result == 1) ? "Successfully added the object!" : "please enter a valid name";
                        System.out.println(msg);
                        System.out.println("Press 0 to go back to home or press any key to continue....");

                        backToHome = input.next();
                    } while (!backToHome.equals("0"));
                    break;

                case 2:
                    do {
                        System.out.println("Enter the item name:");
                        String deliveryName = input.next(); // Use next() for single word input
                        int result = deliveryActivaterService.removeItems(deliveryName);
                        String msg = (result == 1) ? "Successfully Removed the object!" : "please enter a valid name";
                        System.out.println(msg);
                        System.out.println("Press 0 to go back to home or press any key to continue....");

                        backToHome = input.next();
                    } while (!backToHome.equals("0"));
                    break;

                case 3:
                    do {
                        List<Delivery> itemsList = deliveryActivaterService.listItems();
                        System.out.println("-----------------------------------Delivery list--------------------------------------------");
                        System.out.println("Delivery ID:" + "\t" + "Delivery Name:" + "\t" + "Delivery Location:" + "\t" + "Delivery Price:" + "\t");

                        for (Delivery tempItem : itemsList) {
                            System.out.println(tempItem.getDeliveryID() + "\t         " + tempItem.getDeliveryName() + "\t         " + tempItem.getDeliveryLocation() + "\t         " + tempItem.getDeliveryChargers() + "\t              \n");
                        }
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("Press 0 to go back to home or press any key to continue....");

                        backToHome = input.next();
                    } while (!backToHome.equals("0"));
                    break;

                case 4:
                    do {
                        System.out.println("Enter the item name");
                        String deliveryName = input.next(); // Use next() for single word input
                        int result = deliveryActivaterService.searchitems(deliveryName);
                        String msg = (result == 1) ? "Object found!" : "Object not found!";
                        System.out.println(msg);
                        System.out.println("Press 0 to go back to home or press any key to continue....");

                        backToHome = input.next();
                    } while (!backToHome.equals("0"));
                    break;

                case 5:
                    return;
            }
        } while (!exit);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("============Delivery consumer stopped.============");
        context.ungetService(deliveryService);
    }
}