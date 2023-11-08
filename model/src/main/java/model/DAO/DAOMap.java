/*
 * 
 */
package model.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAOMap.
 *
 * @author KETATE
 */
public class DAOMap {

	/** The connection. */
	private DBConnection myConnection;

	/**
	 * Instantiates DAO map.
	 *
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public DAOMap() throws ClassNotFoundException, SQLException {
		this.myConnection = new DBConnection();
		this.myConnection.connect();
	}

	/**
	 * Gets the levels.
	 *
	 * @return the levels
	 * @throws SQLException the SQL exception
	 */
	public Object[] getLevels () throws SQLException {
		ArrayList<String> levels = new ArrayList<String>();

		String request = "SELECT id FROM maps;";
		Statement statement = myConnection.getConnection().createStatement();
		ResultSet result = statement.executeQuery(request);

		while (result.next()) {
			levels.add(result.getString(1));
		}

		return levels.toArray();
	}

	/**
	 * load the level.
	 *
	 * @param mapFile the map file
	 * @param id the id
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SQLException the SQL exception
	 */
	public void loadlevel(String mapFile, String id) throws IOException, SQLException {

		String request = "SELECT map FROM maps WHERE id =" + id + ";";
		Statement statement = myConnection.getConnection().createStatement();
		ResultSet result = statement.executeQuery(request);

		while (result.next()) {
			BufferedWriter writer = new BufferedWriter(new FileWriter(mapFile));
			writer.write(result.getString(1));
			writer.close();
		}


}

}