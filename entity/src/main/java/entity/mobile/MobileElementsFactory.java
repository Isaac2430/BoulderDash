/*
 * 
 */
package entity.mobile;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe MobileElementsFactory</h1>.
 *
 * @author KETATE
 */
public class MobileElementsFactory {

	/** The Constant monsterG. */
	private final static MonsterG monsterG = new MonsterG();
	
	/** The Constant monsterR. */
	private final static MonsterR monsterR = new MonsterR();
	
	/** The Constant diamond. */
	private final static Diamond diamond = new Diamond();
	
	/** The Constant boulder. */
	private final static Boulder boulder = new Boulder();
	
	/** The mobile elements. */
	private static Mobile[] mobileElements = { monsterR, monsterG, diamond, boulder};

	/**
	 * Obtenir le symbole du fichier
	 * Cette methode permet d'obtenir le nom de l'image à partir de son symbole sur la map.
	 *
	 * @param fileSymbol the file symbol
	 * @return the from file symbol
	 */
	public static Mobile getFromFileSymbol(final char fileSymbol) {
		for (final Mobile mobileElement : mobileElements) {
			if (mobileElement.getSprite().getConsoleImage() == fileSymbol) {
				return mobileElement;
			}
		}
		return boulder;
	}

	/**
	 * Créer le monstre rouge
	 * C'est la méthode qui crée le monstre en générant l'image .
	 *
	 * @return Red Monster
	 */
	public static Mobile createMonsterR() {
		return monsterR;
	}
	
	/**
	 * Créer le monstre vert
	 * C'est la méthode qui crée le monstre en générant l'image  .
	 *
	 * @return Green Monster
	 */
	public static Mobile createMonsterG() {
		return monsterG;
	}

	/**
	 * Créer le diamand
	 * C'est la méthode qui crée le diamond en générant l'image .
	 *
	 * @return diamond
	 */
	public static Mobile createDiamond() {
		return diamond;
	}

	/**
	 * Créer le rocher
	 * C'est la méthode qui crée le rock en générant l'image .
	 *
	 * @return boulder
	 */
	public static Mobile createRock() {
		return boulder;
	}

}