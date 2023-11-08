/*
 * 
 */
package model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class DBConnection.
 *
 * @author KETATE
 */
public class DBConnection {

	/** the database url. */
	private static String URL = "jdbc:mysql://localhost/boulderdash?autoReconnect=true&useSSL=false";
	
	/** the user. */
	private static String USER = "root";
	
	/** the password. */
	private static String PASSWD = "";

	/** The connection. */
	private Connection connection = null;

	/** The instance. */
	private DBConnection INSTANCE;

	/**
	 * Gets the instance.
	 *
	 * @return single instance of DBConnection
	 */
	public DBConnection getInstance() {
		if (INSTANCE != null) {
			INSTANCE = new DBConnection();
		}
		return INSTANCE;
	}

	/**
	 * Connects to the database.
	 *
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(URL, USER, PASSWD);
	}
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * Gets the URL.
	 *
	 * @return the url
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public  String getUSER() {
		return USER;
	}

	/**
	 * Gets the password.
	 *
	 * @return the passwd
	 */
	public  String getPASSWD() {
		return PASSWD;
	}
}