/*
 * 
 */
package entity.motionless;

import entity.Permeability;
import entity.Sprite;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe Background</h1>.
 *
 * @author KETATE
 */
public class Background extends MotionlessElement{
	
	/** La Constante SPRITE. */
    private static final Sprite SPRITE = new Sprite('.', "Background.png");

    /**
     * Constructeur d'un nouveau background.
     */
    Background() {
        super(SPRITE, Permeability.WALKABLE);
    }

}