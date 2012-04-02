package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.model.Event;
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
	
	public static synchronized List<Ticket> find(Event event) {
		List<Ticket> tickets = map(event, TicketTDG.find(event.getUniqueId()));
		return tickets;
	}
	
	public static List<Ticket> map(Event event, ResultSet resultSet) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		try {
			while (resultSet.next()) {
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");				
				int numberOfSeats = resultSet.getInt("numberOfSeats");
				Ticket t = new Ticket(firstName, lastName, event, numberOfSeats);
				tickets.add(t);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		
		return tickets;		
	}
	
}
