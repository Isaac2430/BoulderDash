package model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * la classe DBConnection
 *
 */
public class DBConnection {

	/**
	 * l'url de la base de données
	 */
	private static String URL = "jdbc:mysql://localhost/jpublankproject1?autoReconnect=true&useSSL=false";
	/**
	 * l'utilisateur
	 */
	private static String USER = "root";
	/**
	 * le mot de passe 
	 */
	private static String PASSWD = "";

	private Connection connection = null;

	private DBConnection INSTANCE;

	/**
	 * obtenir une instance
	 */
	public DBConnection getInstance() {
		if (INSTANCE != null) {
			INSTANCE = new DBConnection();
		}
		return INSTANCE;
	}

	/**
	 * se connecter à la base de données
	 */
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(URL, USER, PASSWD);
	}
	
	/**
	 * obtenir la connection
	 * @return connection
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * obtenir l'url
	 * @return l'adresse URL
	 */
	public static String getURL() {
		return URL;
	}

	/**
	 * obtenir l'utilisateur
	 * @return l'utilisateur
	 */
	public static  String getUSER() {
		return USER;
	}

	/**
	 * obtenir le mot de passe
	 * @return le mot de passe
	 */
	public static  String getPASSWD() {
		return PASSWD;
	}
}