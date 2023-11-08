/*
 * 
 */
package entity.mobile;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Permeability;
import entity.Sprite;

// TODO: Auto-generated Javadoc
/**
 *  <h1>la Classe BoulderTest.</h1>
 * 
 *  C'est une classe de test pour la classe Boulder
 *  
 *  @author Adri
 */

public class BoulderTest {
	
	/** The boulder. */
	private Boulder boulder;

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
	 * Méthode où l'objet boulder est créé.
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		this.boulder = new Boulder(); 
	}
	
	/**
	 * Test sur le getter des diamonds getDiamonds.
	 */
	@Test
	public void testGetDiamonds() {
		assertEquals(0, this.boulder.getDiamonds());
	}

}
