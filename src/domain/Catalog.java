package domain;

import java.util.List;

import persistence.EventMapper;

import domain.model.Event;


//Stores Events
public class Catalog {
	
	private List<Event> eventRepository;
	private static Catalog catalog = null;
	
	private Catalog() {
		eventRepository = EventMapper.findAll();
	}
	
	public static Catalog getInstance() {
		if (catalog == null) {
			catalog = new Catalog();
		}
		return catalog;
	}
	
	public void viewAllEvents() {		
		System.out.println("Event List");
		System.out.println("====================================================================");		
		for (Event e: eventRepository) {
			System.out.print(e.getUniqueId() + " ");
			System.out.print(e.getTitle() + " ");
			System.out.print(e.getDate() + " ");
			System.out.print(e.getHall() + " ");
			System.out.println(e.getEventType());
		}
		
		System.out.println("====================================================================");
	}

}
