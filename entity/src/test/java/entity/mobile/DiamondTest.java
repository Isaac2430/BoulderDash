/*
 * 
 */
package entity.mobile;

import static org.junit.Assert.*;

/**
 *  <h1>la Classe DiamondTest.</h1>
 * 
 */

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe DiamondTest</h1>
 * 
 * C'est une classe de test pour la classe Diamond.
 *
 * @author Adri
 */
public class DiamondTest {
	
	/** The diamond. */
	private Diamond diamond;
	
	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	/**
	 * Méthode où l'objet diamond est créé.
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		this.diamond = new Diamond();
	}
	
	/**
	 * Test du getter des diamonds.
	 */
	@Test
	public void testGetDiamonds() {
		assertEquals(0, this.diamond.getDiamonds());
	}

}
