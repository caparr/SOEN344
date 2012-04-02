package persistence;

import java.sql.SQLException;
import domain.model.Ticket;



/**
 * @author Matthew Tam
 * Acts as an intermediary between TicketTDG and Catalog, 
 * mapping persistent logic to domain logic and vice versa 
 */
public class TicketMapper {

	
	/**
	 * bookTicket(Ticket t) from Catalog will invoke this method. 
	 * To manage concurrency issues, this method can only be accessed by one client at a time.
	 * @param t
	 * @return
	 */
	public static synchronized boolean insert (Ticket t) {
		
		
		String firstName = t.getFirstName();
		String lastName = t.getLastName();
		int eventId = t.getEvent().getUniqueId();
		int numberOfSeats = t.getNumberOfSeats();
		boolean isSuccessful = false;		
		
		if (TicketTDG.checkAvailableSeating(eventId, numberOfSeats)) {
			try {
				isSuccessful = TicketTDG.insert(firstName, lastName, eventId, numberOfSeats);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return isSuccessful;
	}
}
