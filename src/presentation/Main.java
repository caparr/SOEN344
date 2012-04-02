package presentation;

import java.util.Scanner;

import domain.Catalog;
import domain.model.Ticket;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the Ticket Management Studio V1.0");
		System.out.println("Here are the list of commands");
		while(true) {
			System.out.println("====================================");
			System.out.println("1.\tView all events");
			System.out.println("2.\tBook pending tickets");
			System.out.println("3.\tView all bookings for an event");
			System.out.println("4.\tExit program");
			System.out.println("====================================");
			System.out.print("Please enter the number of the method you wish to invoke: ");
			try {
				String input = scan.nextLine();
				switch(Integer.parseInt(input)) {
				
					case 1:
						viewAllEvents();
						System.out.println("Bringing you back to the menu...\n\n");
						break;
					case 2:
						bookTickets();
						System.out.println("Bringing you back to the menu...\n\n");
						break;
					case 3:
						System.out.print("Enter the eventId to retrieve the ticket list: ");
						int eventId = Integer.parseInt(scan.nextLine());
						viewAllTicketsForEvent(eventId);					
						break;
					case 4:
						System.out.println("Bye!");
						System.exit(0);
						break;
					default:
						System.out.println("Incorrect input");
						System.out.println("Bringing you back to the menu...");
							
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}		
	}
	
	
	public static void viewAllEvents() {
		Catalog.getInstance().viewAllEvents();
	}
	
	public static void bookTickets() {
		Ticket t1 = new Ticket("John", "Doe", Catalog.getInstance().search(1), 5),
		t2 = new Ticket("Jane", "Doe", Catalog.getInstance().search(1), 3),
		t3 = new Ticket("Judy", "Star", Catalog.getInstance().search(1), 10),
		t4 = new Ticket("June", "Hunter", Catalog.getInstance().search(1), 2);

		Thread thread1 = new Thread(new Client(t1), "thread1"),
		thread2 = new Thread(new Client(t2), "thread2"),
		thread3 = new Thread(new Client(t3), "thread3"),
		thread4 = new Thread(new Client(t4), "thread4");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
	
	public static void viewAllTicketsForEvent(int eventId) {		
		Catalog.getInstance().viewAllTicketsForEvent(eventId);
	}
}
