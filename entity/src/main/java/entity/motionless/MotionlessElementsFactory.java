/*
 * 
 */
package entity.motionless;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe MotionlessElements</h1>.
 *
 * @author KETATE
 * @version 0.1
 */
public abstract class MotionlessElementsFactory {

	/** The Constant wall. */
	private static final Wall wall = new Wall();
	
	/** The Constant door. */
	private static final Door door = new Door();
	
	/** The Constant background. */
	private static final Background background = new Background();
	
	/** The Constant ground. */
	private static final Ground ground = new Ground();

	/** The motionless elements. */
	private static MotionlessElement[] motionlessElements = {wall, background, door, ground};

	/**
	 * Methode qui crée le wall.
	 *
	 * @return wall
	 */
	public static MotionlessElement createWall() {
		return wall;
	}

	/**
	 * Méthode qui crée la porte.
	 *
	 * @return door
	 */
	public static MotionlessElement createDoor() {
		return door;
	}

	/**
	 * Méthode qui crée le background.
	 *
	 * @return background
	 */
	public static MotionlessElement createBackground() {
		return background;
	}
	
	/**
	 * Méthode qui crée le ground.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createGround() {
		return ground;
	}

	/**
	 * Méthode qui obtient le nom de l'image à partir du symbole.
	 *
	 * @param fileSymbol the file symbol
	 * @return the from file symbol
	 */
	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
				return motionlessElement;
			}
		}
		return background;
	}
}