package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			System.out.println(e);
		}
		
		return resultSet;
	}
	
	
	/**
	 * Hard code insert of events into the database 
	 */
	public static void insert() {
		PreparedStatement ps = null;
			
		String query = "INSERT INTO event (title, status, date, eventType, hall) " +
				"values (?, ?, ?, ?, ?)";

		try {
			ps = DBRegistry.getInstance().getConnection().prepareStatement(query);
			ps.setString(1, "Dave Chappelle"); // title
			ps.setInt(2, 1); // status
			ps.setDate(3, java.sql.Date.valueOf("2012-04-30"));
			ps.setInt(4, 1); // eventType
			ps.setInt(5, 1); // hall
			ps.executeUpdate();			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
