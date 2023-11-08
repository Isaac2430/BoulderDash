/*
 * 
 */
package entity;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.mobile.Boulder;
import entity.mobile.Diamond;
import entity.mobile.MonsterG;
import entity.mobile.MonsterR;
import entity.motionless.Background;
import entity.motionless.Door;
import entity.motionless.Ground;

// TODO: Auto-generated Javadoc
/**
 *  <h1>la Classe ElementTest.</h1>
 *  
 *  Cette classe est la classe de test de la classe Element
 *  
 * C'est une classe de test sur la collection des objets. Elle vérifie que chaque objet est créé avec la bonne permeability
 * 
 */

public class ElementTest {
	
	/** The boulder. */
	static Boulder boulder;
	
	/** The monster G. */
	static MonsterG monsterG;
	
	/** The monster R. */
	static MonsterR monsterR;
	
	/** The diamond. */
	static Diamond diamond;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	/**
	 * Méthode où les objets sont créés : Boulder, MonsterG, MonsterR, Diamond.
	 * 
	 * @throws Exception
	 */
	public static void setUpBeforeClass() throws Exception {
		boulder = new Boulder();
		monsterG = new MonsterG();
		monsterR = new MonsterR();
		diamond = new Diamond();
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
	 * Test get sprite.
	 */
	@Test
	public void testGetSprite() {
		//fail("Not yet implemented");
	}
	
	/**
	 * Test sur le getter de permeability
	 * 
	 * Cette méthode vérifie la permeability de chaque objet créé.
	 */
	@Test
	public void testGetPermeability() {
		//fail("Not yet implemented");
		Permeability testboulder = Permeability.BOULDER;
		Permeability testmonsterG = Permeability.KILLABLE;
		Permeability testmonsterR = Permeability.KILLABLE;
		Permeability testdiamond = Permeability.DIAMOND;
		assertEquals(testboulder, ElementTest.boulder.getPermeability());
		assertEquals(testmonsterG, ElementTest.monsterG.getPermeability());
		assertEquals(testmonsterR, ElementTest.monsterR.getPermeability());
		assertEquals(testdiamond, ElementTest.diamond.getPermeability());
	}
}
