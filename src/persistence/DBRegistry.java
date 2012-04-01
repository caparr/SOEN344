package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBRegistry {

	private static DBRegistry registry = null;
	private Connection connection = null;	
	
	private DBRegistry() {
		this.connect();
	}
	
	
	/**
	 * Returns the <code>DBRegistry</code> instance with a connection to the database.
	 * 
	 * @return DBRegistry
	 */
	public static DBRegistry getInstance() {
		if (registry == null) {
			registry = new DBRegistry();
		}
		return registry;
	}
	
	private boolean connect() {
		try {
			Class.forName("org.sqlite.JDBC").newInstance();
			connection = DriverManager.getConnection("jdbc:sqlite:soen344.db");		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return true;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
