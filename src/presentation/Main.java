package presentation;

import domain.Catalog;
import domain.model.Ticket;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Catalog.getInstance().viewAllEvents();
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

}
