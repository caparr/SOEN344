package presentation;

import domain.Catalog;
import domain.model.Ticket;

/**
 * @author Matthew Tam
 * Domain object Client
 */
public class Client implements Runnable {
	private Ticket buyingTicket;
	private Thread runner;
	
	
	public Client(Ticket t) {
		runner = new Thread();
		this.buyingTicket = t;
		runner.start();
	}
	
	public void run() {
		Catalog.getInstance().bookTicket(this.buyingTicket);
	}
}
