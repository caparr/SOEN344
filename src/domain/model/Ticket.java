package domain.model;

/**
 * @author Matthew Tam
 * Domain object Ticket
 */
public class Ticket {
	
	private String firstName;
	private String lastName;
	private Event event;
	private int numberOfSeats;
		
	
	public Ticket(String firstName, String lastName, Event event,
			int numberOfSeats) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.event = event;
		this.numberOfSeats = numberOfSeats;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	
	

}
