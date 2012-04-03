package presentation;

import java.util.Scanner;

import domain.Catalog;
import domain.model.Ticket;


public class Main {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Ticket Management Studio V1.0");
		menuOptions();		
	}
	
	
	public static void viewAllEvents() {
		Catalog.getInstance().viewAllEvents();
		System.out.println("Bringing you back to the menu...\n\n");
		menuOptions();
	}
	
	public static void bookTickets() {
		Ticket[] t = new Ticket[15];
		t[0] = new Ticket("John", "Doe", Catalog.getInstance().search(1), 5);
		t[1] = new Ticket("Jane", "Doe", Catalog.getInstance().search(1), 3);
		t[2] = new Ticket("Judy", "Star", Catalog.getInstance().search(1), 10);
		t[3] = new Ticket("June", "Hunter", Catalog.getInstance().search(1), 2);
		t[4] = new Ticket("Roger", "Federer", Catalog.getInstance().search(1), 10);
		t[5] = new Ticket("Maria", "Sharapova", Catalog.getInstance().search(1), 10);
		t[6] = new Ticket("Josh", "Hum", Catalog.getInstance().search(1), 10);
		t[7] = new Ticket("Cool", "Dude", Catalog.getInstance().search(1), 10);
		t[8] = new Ticket("Sweet", "Lady", Catalog.getInstance().search(1), 10);
		t[9] = new Ticket("Katniss", "Everdeen", Catalog.getInstance().search(1), 10);
		t[10] = new Ticket("Harry", "Potter", Catalog.getInstance().search(1), 10);
		t[11] = new Ticket("Ron", "Weasley", Catalog.getInstance().search(1), 10);
		t[12] = new Ticket("Captain", "Teemo", Catalog.getInstance().search(1), 10);
		t[13] = new Ticket("Monkey D", "Luffy", Catalog.getInstance().search(1), 10);		
		t[14] = new Ticket("Ichigo", "Kurosaki", Catalog.getInstance().search(1), 10);

		Thread[] threads = new Thread[15];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Client(t[i]), "thread" + i);
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		
		try {
			for (int i = 0; i < threads.length; i++) {			
				threads[i].join();
			}
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Bringing you back to the menu...\n\n");
		menuOptions();
	}
	
	public static void viewAllTicketsForEvent(int eventId) {		
		Catalog.getInstance().viewAllTicketsForEvent(eventId);
		System.out.println("Bringing you back to the menu...\n\n");
		menuOptions();
	}
	
	public static void menuOptions() {
		System.out.println("Here are the list of commands");
		System.out.println("====================================");
		System.out.println("1.\tView all events");
		System.out.println("2.\tBook pending tickets");
		System.out.println("3.\tView all bookings for an event");
		System.out.println("4.\tExit program");
		System.out.println("====================================");
		System.out.println("Please enter the number of the method you wish to invoke: ");
		
		try {
			String input = scan.nextLine();
			switch(Integer.parseInt(input)) {
			
				case 1:
					viewAllEvents();						
					break;
				case 2:
					bookTickets();						
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
					break;
			}			
		}
		catch(NumberFormatException e1) {
			e1.printStackTrace();
			menuOptions();
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}

	}
}
