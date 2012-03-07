package domain;

import java.util.Calendar;

public class Event {

	private long uniqueId;
	private String title;
	private Calendar date;
	private int maxCapacity;
	private boolean status; // open or closed
	
	@SuppressWarnings("serial")
	public Event()
	{
		uniqueId = 0;
		title = "";
		date = new Calendar() {
			
			@Override
			public void roll(int field, boolean up) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int getMinimum(int field) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getMaximum(int field) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getLeastMaximum(int field) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getGreatestMinimum(int field) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			protected void computeTime() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			protected void computeFields() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void add(int field, int amount) {
				// TODO Auto-generated method stub
				
			}
		};
		maxCapacity = 0;
		status = true;
	}
	public long getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
