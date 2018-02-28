import java.util.*;

public class RestaurantQueueTester {

	static String customerStorage;
	static String orderStorage;
	static int timeStorage;
	static Queue<RestaurantOrder> line = new LinkedList<RestaurantOrder>();
	
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		String scnrSelection;
		boolean continueLoop = true;
		int minutesPassed = -1;
		
		
		System.out.println("--- Welcome To Restaurant Order Manager ---");
		System.out.println();
		
		while(continueLoop) {
			
			minutesPassed++;
		
			if(!line.isEmpty()) {
				if(line.peek().getTime() == minutesPassed) {
				System.out.println("An order has been automatically removed");
				System.out.println();
				line.remove();
				minutesPassed = 0;
				}
			}
			
			System.out.println("Select an option");
			System.out.println("[A]dd an order");
			System.out.println("[P]rint order queue");
			System.out.println("[R]emove an order");
			System.out.println("[Q]uit order program");
			
			scnrSelection = scnr.nextLine();
			
			
			
			if(scnrSelection.equalsIgnoreCase("A")) {
				addCustomer();
			} else if(scnrSelection.equalsIgnoreCase("P")) {
				printCustomerList(minutesPassed);
			} else if(scnrSelection.equalsIgnoreCase("R")) {
				removeCustomer();
			} else if(scnrSelection.equalsIgnoreCase("Q")) {
				continueLoop = false;
				System.out.println();
				System.out.println("Shutting Down...");
			} else {
				System.out.println("Error: Please Select A Valid Option");
				System.out.println();
				minutesPassed--;
			}
		}
	}
	
	private static void addCustomer() {
		Scanner scnr = new Scanner(System.in);
		String scnrSelection;
		String orderString;
		int menuSelect;
		
		System.out.println("Are you sure you would like to add an order?");
		System.out.println("[Y]es");
		System.out.println("[N]o");
		
		scnrSelection = scnr.nextLine();
		
		if(scnrSelection.equalsIgnoreCase("Y")) {
			System.out.println("Enter The Customer's Name");
			customerStorage = scnr.nextLine();
			System.out.println("Enter The Order Number");
			System.out.println("(1) - Burger {6 Minutes}");
			System.out.println("(2) - Pizza {4 Minutes}");
			System.out.println("(3) - Salad {5 Minutes}");
			
			if(scnr.hasNextInt()) {
				menuSelect = scnr.nextInt();
				
				if(menuSelect == 1) {
					RestaurantOrder newOrder = new RestaurantOrder(customerStorage, "Burger", 6);	
					line.add(newOrder);
				} else if(menuSelect == 2) {
					RestaurantOrder newOrder = new RestaurantOrder(customerStorage, "Pizza", 4);	
					line.add(newOrder);
				} else if(menuSelect == 3) {
					RestaurantOrder newOrder = new RestaurantOrder(customerStorage, "Salad", 5);
					line.add(newOrder);
				}
				
				System.out.println("The order has been added to the queue");
			} else {
				System.out.println("Please Select A Valid Input");
			}
		} else if(scnrSelection.equalsIgnoreCase("N")) {
			System.out.println("Order insertion has been canceled");
		} else {
			System.out.println("Error: Please enter a valid input");
		}
		
		System.out.println();
		
	}
	
	private static void removeCustomer() {
		Scanner scnr = new Scanner(System.in);
		String scnrSelection;
		
		System.out.println("Are you sure you would like to remove the next order?");
		System.out.println("[Y]es");
		System.out.println("[N]o");
				
		scnrSelection = scnr.nextLine();
		
		if(scnrSelection.equalsIgnoreCase("Y")) {
			if(line.isEmpty()) {
				System.out.println("The order queue is empty, there is nothing to remove");
			} else {
				line.remove();
				System.out.println("The order has been removed");
			}
		} else if(scnrSelection.equalsIgnoreCase("N")) {
			System.out.println("Order deletion has been canceled");
		} else {
			System.out.println("Error: Please enter a valid input");
		}
		
		System.out.println();
	}
	
	private static void printCustomerList(int elapsedTime) {
		int totalTime = 0;
		boolean firstOrder = true;
		if(!line.isEmpty()) {
			System.out.println("Number of orders: " + line.size());
			for(RestaurantOrder o : line) { 
				System.out.println("----------------------------------------");
				System.out.println("Customer Name: " + o.getCustomer()); 
				System.out.println("Customer Order: " + o.getOrder());
				if(firstOrder) {
					System.out.println("Order Cook Time: " + (o.getTime() - elapsedTime) + " Minute(s)");
					firstOrder = false;
				} else {
					System.out.println("Order Cook Time: " + o.getTime() + " Minute(s)");
				}
				totalTime += o.getTime();
			}
			System.out.println("----------------------------------------");
			System.out.println("Total Wait Time Remaining: " + (totalTime - elapsedTime) + " Minute(s)");
			System.out.println();
			
		} else {
			System.out.println("The order queue is empty, there is nothing to print");
		}
	}
}
