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

// TODO: Auto-generated Javadoc
/**
 *  <h1>la Classe SpriteTest.</h1>
 *  
 *  Classe de test sur les sprites afin de vérifier si les noms des images sont les mêmes que celles attendus.
 *  
 *  @author Adri
 * 
 */

public class SpriteTest {
	
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
	 * Méthode où les objets sont crées
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
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test sprite char string.
	 */
	@Test
	/**
	 * Méthode testSpriteCharString
	 * 
	 * Elle vérifie que chaque sprite créé reçoit l'image qui lui est approprié en partant du nom de l'image
	 * 
	 */
	public void testSpriteCharString() {
		//Tester si les valeurs attendues sont les mêmes
		String fileI1 = "boulder.png";
		assertEquals(fileI1, SpriteTest.boulder.getSprite().getImageName());
		String fileI2 = "greenMonster.png";
		assertEquals(fileI2, SpriteTest.monsterG.getSprite().getImageName());
		String fileI3 = "redMonster.png";
		assertEquals(fileI3, SpriteTest.monsterR.getSprite().getImageName());
		String fileI4 = "diamond.png";
		assertEquals(fileI4, SpriteTest.diamond.getSprite().getImageName());
	}
}
