/*
 * 
 */
package entity.mobile;

import entity.Permeability;
import entity.Sprite;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe Boulder</h1>.
 *
 * @author KETATE
 */
public class Boulder extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('O', "boulder.png");

    /**
     * Définition du constructeur du Boulder.
     */
    public Boulder() {
        super(SPRITE, Permeability.BOULDER);
    }
    
    /**
     * Methoode moveRight.
     */
    @Override
    public void moveRight() {
    	super.moveRight();
    }
    
    /**
     * Méthode win.
     */
    @Override
    public void win() {
        
        return;
    }
    
    /**
     * Méthode moveLeft.
     */
    @Override
    public void moveLeft() {
    	super.moveLeft();
    }
    
    /**
     * Méthode moveDown.
     */
    @Override 
    public void moveDown() {
    	super.moveDown();
    }

    /**
     * Le Getter des diamands.
     *
     * @return 0
     */
    @Override
	public int getDiamonds() {
		return 0;
	}

    /**
     * Le Getter des diamands.
     */
    @Override
    public void grabDiamond() {
        return;
    }
	
	
}