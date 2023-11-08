/*
 * 
 */
package entity.motionless;

import entity.Permeability;
import entity.Sprite;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe Ground</h1>.
 *
 * @author KETATE
 */
public class Ground extends MotionlessElement{

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "Ground.png");

    /**
     * Constructeur du Ground.
     */
    Ground() {
        super(SPRITE, Permeability.DIGGABLE);
    }

}