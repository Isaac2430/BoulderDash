/*
 * 
 */
package entity.mobile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.IMap;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe MyPlayerTest</h1>
 * 
 * C'est une classe de test pour la classe MyPlayer.
 *
 * @author Adri
 */
public class MyPlayerTest {
	
	/** The my player. */
	private MyPlayer myPlayer;
	
	/** The map. */
	static IMap map;
	
	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	/**
	 * Méthode où est créé l'objet myPlayer
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		this.myPlayer = new MyPlayer(0, 0, map);
	}

	/**
	 * Test get diamonds.
	 */
	@Test
	/**
	 * Test sur le getter de diamonds GetDiamonds
	 */
	public void testGetDiamonds() {
		int expected = 1;
		assertEquals(expected, this.myPlayer.getDiamonds());
	}

}
