package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Matthew Tam
 * Handles all the persistent logic regarding Event
 */
public class EventTDG {
	
	
	
	/**
	 * Returns the ResultSet of all Events
	 */
	public static ResultSet findAll() {
		
		PreparedStatement ps = null;
		ResultSet resultSet = null;	
		String query = "SELECT * FROM EVENT";	
		
		try {
			ps = DBRegistry.getInstance().getConnection().prepareStatement(query);
			resultSet = ps.executeQuery();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	
	/**
	 * Hard code insert of events into the database 
	 */
	public static void insert() {
		PreparedStatement ps = null;
			
		String query = "INSERT INTO event (title, status, date, eventType, hall, showing, numberOfSeats) " +
				"values (?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = DBRegistry.getInstance().getConnection().prepareStatement(query);
			ps.setString(1, "Dave Chappelle"); // title
			ps.setInt(2, 1); // status
			ps.setDate(3, java.sql.Date.valueOf("2012-04-30"));
			ps.setInt(4, 1); // eventType
			ps.setInt(5, 1); // hall
			ps.setInt(6, 1); // showing
			ps.setInt(7, getNumberOfSeats(1));
			ps.executeUpdate();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Hardcoded seats available in the event based on which hall they're at
	 * @return seatsAvailable
	 */
	private static int getNumberOfSeats(int numberOfSeats) {
		int seatsAvailable;
		
		switch (numberOfSeats) {
			case 1:
				seatsAvailable = 10;
				break;
			case 2:
				seatsAvailable = 5;
				break;
			default:
				seatsAvailable = 0;
				break;	
		}
		
		return seatsAvailable;
	}

}
