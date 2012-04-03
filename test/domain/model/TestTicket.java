package domain.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTicket {

	private String firstName;
	private String lastName;
	private Event event;
	private int numberOfSeats;
	
	@Before
	public void setUp() {
		this.firstName = "John";
		this.lastName = "Doe";		
		this.event = new Event(1,1,1,1,1, true, java.sql.Date.valueOf("2012-04-03"), "Test");
		this.numberOfSeats = 2;
	}
	
	@Test
	public void testTicketCreation() {
		Ticket t = new Ticket(firstName, lastName, event, numberOfSeats);
		
		assertTrue(t.getFirstName() == firstName);
		assertTrue(t.getLastName() == lastName);
		assertTrue(t.getEvent().getDate() == event.getDate());
		assertTrue(t.getEvent().getEventType() == event.getEventType());
		assertTrue(t.getEvent().getHall() == event.getHall());
		assertTrue(t.getEvent().getNumberOfSeats() == event.getNumberOfSeats());
		assertTrue(t.getEvent().getShowing() == event.getShowing());
		assertTrue(t.getEvent().getTitle() == event.getTitle());
		assertTrue(t.getEvent().getUniqueId() == event.getUniqueId());		
		assertTrue(t.getNumberOfSeats() == numberOfSeats);
	}
}
