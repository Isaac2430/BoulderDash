package model.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 *la classe DAOMap
 *
 *@author Adri
 *
 */
public class DAOMap {

	private DBConnection myConnection;
	public DAOMap() throws ClassNotFoundException, SQLException {
		this.myConnection = new DBConnection();
		this.myConnection.connect();
	}

	/**
	 * Obtenir le niveau à partir de la bdd
	 * @return le niveau
	 * @throws SQLException
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
	 * chargement du niveau
	 * @param id
	 * @throws IOException
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