package de.asc.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * database wrapper
 * 
 * 
 * @author andi
 *
 */
public class Database {
	private static String url = "jdbc:postgresql://localhost:5432/timetracker";
    private static String userid = "time";
    private static String password = "jonas";

    private static Connection connection = null;
    
	/**
     * 
     * @throws SQLException
     */
    public static void connect() throws SQLException {
    	if (connection == null)
    		connection = DriverManager.getConnection(url, userid, password);
    }

    /**
     * 
     * @throws SQLException
     */
    public static void disconnect() throws SQLException {
    	if (connection != null)
    		connection.close();
    }

    /**
     * 
     * @return
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
    	connect();
		return connection;
	}
    
}