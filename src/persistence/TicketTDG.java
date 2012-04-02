package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Matthew Tam
 * Handles all the persistent logic regarding Ticket
 */
public class TicketTDG {

	/**
	 * @param firstName
	 * @param lastName
	 * @param eventId
	 * @param numberOfSeats
	 * @return isSuccessful transaction or not
	 */
	public static boolean insert(String firstName, String lastName, int eventId,
			int numberOfSeats) throws SQLException {
		boolean isSuccessful = false;
		PreparedStatement psEvent = null;
		PreparedStatement psTicket = null;
		
			
		String queryEvent = "UPDATE EVENT " +
				"SET numberOfSeats = numberOfSeats - ? " + 
				"WHERE id = ?";
		
		String queryTicket = "INSERT INTO TICKET (firstName, lastName, eventId, numberOfSeats) " +
				"values (?, ?, ?, ?)";

		
		try {
			DBRegistry.getInstance().getConnection().setAutoCommit(false); // allows for both query executions to happen at the same time
			
			psEvent = DBRegistry.getInstance().getConnection().prepareStatement(queryEvent);
			psEvent.setInt(1, numberOfSeats);
			psEvent.setInt(2, eventId);
			psEvent.executeUpdate();
			
			psTicket = DBRegistry.getInstance().getConnection().prepareStatement(queryTicket);
			psTicket.setString(1, firstName); // first name of the individual the client is booking for
			psTicket.setString(2, lastName); // last name of the individual the client is booking for
			psTicket.setInt(3, eventId); // the event the client is booking for
			psTicket.setInt(4, numberOfSeats); // number of seats the client is booking			
			psTicket.executeUpdate();
			
			DBRegistry.getInstance().getConnection().commit();
			
			if (psTicket != null) {
				isSuccessful = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (psEvent != null)
				psEvent.close();
			if (psTicket != null)
				psTicket.close();			
			DBRegistry.getInstance().getConnection().setAutoCommit(true);
		}
		
		return isSuccessful;
		
	}
	
	public static boolean checkAvailableSeating(int eventId, int numberOfSeats) {
		
		boolean isAvailable = false;
		int availableSeating = 0;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		String query = "SELECT numberOfSeats FROM EVENT where id = ?";		
		
		try {
			ps = DBRegistry.getInstance().getConnection().prepareStatement(query);
			ps.setInt(1, eventId);
			resultSet = ps.executeQuery();
			availableSeating = resultSet.getInt("numberOfSeats");
			
			if (availableSeating >= numberOfSeats) {
				isAvailable = true;
			}
			ps.close();
		}
		catch (Exception e) {			
			e.printStackTrace();
		}		
		
		return isAvailable;		
		
	}
	
	public static ResultSet find(int eventId) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;	
		String query = "SELECT * FROM TICKET WHERE eventId = ?";	
		
		try {
			ps = DBRegistry.getInstance().getConnection().prepareStatement(query);
			ps.setInt(1, eventId);
			resultSet = ps.executeQuery();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}

}
