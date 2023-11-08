/*
 * 
 */
package entity.motionless;

import entity.Permeability;
import entity.Sprite;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe MotionlessElement</h1>.
 *
 * @author KETATE
 */
class Wall extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('#', "Wall.png");

    /**
     * Constructeur d'un wall.
     */
    Wall() {
        super(SPRITE, Permeability.WALL);
    }
}