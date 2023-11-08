/*
 * 
 */
package entity.motionless;

import entity.Permeability;
import entity.Sprite;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe Door</h1>.
 *
 * @author KETATE
 */
public class Door extends MotionlessElement {
	
	    /** The Constant SPRITE. */
    	private static final Sprite SPRITE = new Sprite('D', "Door.png");

	    /**
	     * Constructeur du Door.
	     */
	    Door() {
	        super(SPRITE, Permeability.EXIT);
	    }
	}