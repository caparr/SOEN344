package domain.model;

import java.util.Date;

public class Event {

	private int uniqueId;
	private int eventType;
	private int hall;
	private int showing;
	private int numberOfSeats;
	
	private boolean status; // open or closed
	
	private Date date;
	private String title;	
	
	public Event(int uniqueId, int eventType, int hall, int showing, int numberOfSeats,
			boolean status,	Date date, String title) {
		super();
		this.uniqueId = uniqueId;
		this.eventType = eventType;
		this.hall = hall;
		this.showing = showing;
		this.numberOfSeats = numberOfSeats;
		this.status = status;
		this.date = date;
		this.title = title;
	}
	
	public int getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	public int getEventType() {
		return eventType;
	}
	public void setEventType(int eventType) {
		this.eventType = eventType;
	}
	public int getHall() {
		return hall;
	}
	public void setHall(int hall) {
		this.hall = hall;
	}
	public int getShowing() {
		return showing;
	}
	public void setShowing(int showing) {
		this.showing = showing;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		return this.uniqueId + " " + this.title;
	}
	
	
	// Hardcoded conversions
	

	
	/**
	 * Hardcoded show times to respect the two shows available at a hall. 
	 * The event will either be in the afternoon or at night time
	 * @return the showTime of the event
	 */
	public String getShowTime() {
		String showTime;
		
		switch (getShowing()) {
			case 1:
				showTime = "16h00";
				break;
			case 2:
				showTime = "22h00";
				break;
			default:
				showTime = "N/A";
				break;					
		}
		
		return showTime;
	}
	
}
