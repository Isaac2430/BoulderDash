/*
 * 
 */
package controller;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import contract.IOrderPerformer;
import contract.IView;
import contract.UserOrder;

// TODO: Auto-generated Javadoc
/**
 *  <h1>la Classe ControllerTest.</h1>
 * 	
 * C'est une classe de test pour la classe Controller
 * Elle effectue les tests sur les getters et les setters
 * 
 * @author Adri
 */

public class ControllerTest {
	
	/** The view. */
	private IView view;
	
	/** The model. */
	private IModel model;

	/** The controller. */
	private Controller controller;
	
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
	 * Methode où l'objet controller est crée.
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		this.controller = new Controller(view, model);
	}

	/**
	 * Test get order performer.
	 */
	@Test
	/**
	 * Test sur le Getter de OrderPerformer getOrderPerformer().
	 */
	public void testGetOrderPerformer() {
		assertNotNull(this.controller.getOrderPerformer());
	}

	/**
	 * Test get compteur.
	 */
	@Test
	/**
	 * Test sur le Getteur de compteur : getCompteur
	 */
	public void testGetCompteur() {
		final int excepeted = 100;
		this.controller.setCompteur(excepeted);
		assertEquals(excepeted, this.controller.getCompteur());
	}

}
