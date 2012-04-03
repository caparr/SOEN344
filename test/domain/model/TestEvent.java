package domain.model;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class TestEvent {
	
	private int uniqueId;
	private int eventType;
	private int hall;
	private int showing;
	private int numberOfSeats;
	
	private boolean status; // open or closed
	
	private Date date;
	private String title;
	
	@Before
	public void setUp() {
		try {
			this.uniqueId = 1;
			this.eventType = 1;
			this.hall = 1;
			this.showing = 1;
			this.numberOfSeats = 1;
			this.status = true;
			this.date = java.sql.Date.valueOf("2012-04-03");
			this.title = "Test";			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEventCreation() {
		Event e1 = new Event (uniqueId, eventType, hall, showing, numberOfSeats,
				status,	date, title);
		
		assertTrue(e1.getUniqueId() == uniqueId);
		assertTrue(e1.getEventType() == eventType);
		assertTrue(e1.getHall() == hall);
		assertTrue(e1.getShowing() == showing);
		assertTrue(e1.getNumberOfSeats() == numberOfSeats);
		assertTrue(e1.isStatus() == status);
		assertTrue(e1.getDate() == date);
		assertTrue(e1.getTitle() == title);
		
	}

}
