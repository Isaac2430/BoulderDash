package model.DAO;

import static org.junit.Assert.*;

/**
 *  <h1>la Classe DBConnectionTest.</h1>
 * 
 */

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * <h1>Classe DBConnectionTest</h1>
 * 
 * C'est une classe de test pour la classe DBConnection
 * 
 * @author Adri
 *
 */
public class DBConnectionTest {
	
	private static String URL = "jdbc:mysql://localhost/jpublankproject1?autoReconnect=true&useSSL=false";
	private static String USER = "root";

	private static String PASSWD = "";
	
	/**
	 * Test du getter de l'URL : getURL
	 */
	@Test
	public final void testGetURL() {
		//fail("Not yet implemented"); // TODO
		assertEquals(DBConnectionTest.URL, DBConnection.getURL());
	}
	
	/**
	 * Test du getter du USER : getUSER
	 */
	@Test
	public final void testGetUSER() {
		assertEquals(DBConnectionTest.USER, DBConnection.getUSER());
	}

	/**
	 * Test du getter du PASSWD : getPASSWD
	 */
	@Test
	public final void testGetPASSWD() {
		//fail("Not yet implemented"); // TODO
		assertEquals(DBConnectionTest.PASSWD, DBConnection.getPASSWD());
	}
}
