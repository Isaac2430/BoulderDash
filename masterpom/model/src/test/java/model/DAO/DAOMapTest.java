package model.DAO;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * <h1>Classe DAOMapTest</h1>
 * C'est une classe de test pour la classe DAOMap
 * 
 * @author Adri
 *
 */
public class DAOMapTest {
	
	DAOMap daoMap;
	private String mapFile = "map.txt";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	/**
	 * Test de vérification sur la levée d'exception
	 * 
	 * @throws Exception
	 */
	@Test (expected = Exception.class)
	public void testLoadMap() throws Exception {
		this.daoMap.loadlevel(mapFile, "0");
	}

}
