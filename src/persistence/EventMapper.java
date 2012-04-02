package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.model.Event;


public class EventMapper {
	
	public static synchronized List<Event> findAll() {
		List<Event> events = map(EventTDG.findAll());		
		return events;
	}
	

	
	public static List<Event> map (ResultSet resultSet) {		
		ArrayList<Event> results = new ArrayList<Event>();
		try {
			while (resultSet.next()) {				
				int uniqueId = resultSet.getInt("id");
				int eventType = resultSet.getInt("eventType");
				int hall = resultSet.getInt("hall");
				int showing = resultSet.getInt("showing");
				int numberOfSeats = resultSet.getInt("numberOfSeats");
				boolean status = resultSet.getBoolean("status");				
				Date date = resultSet.getDate("date");
				String title = resultSet.getString("title");				
				Event resultEvent = new Event(uniqueId, eventType, hall, showing, numberOfSeats, status, date, title);
				
				results.add(resultEvent);				
			}
			resultSet.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	
}
