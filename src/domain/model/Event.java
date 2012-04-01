package domain.model;

import java.util.Date;

public class Event {

	private int uniqueId;
	private int eventType;
	private int hall;	
	
	private boolean status; // open or closed
	
	private Date date;
	private String title;	
	
	public Event(int uniqueId, int eventType, int hall, boolean status, 
			Date date, String title) {
		super();
		this.uniqueId = uniqueId;
		this.eventType = eventType;
		this.hall = hall;		
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
	
	
}
