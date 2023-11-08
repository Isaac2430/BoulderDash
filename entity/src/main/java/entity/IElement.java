/*
 * 
 */
package entity;


import fr.exia.showboard.ISquare;

// TODO: Auto-generated Javadoc
/**
 * <h1>Interface IElement.</h1>
 * @author KETATE
 *
 */
public interface IElement extends ISquare {
	/**
	 * Getter de sprite.
	 *
	 * @return le sprite
	 */
	Sprite getSprite();

	/**
	 * Getter de la permeability.
	 *
	 * @return la permeability
	 */
	Permeability getPermeability();

	/**
	 * Gets the checks for changed.
	 *
	 * @return the checks for changed
	 */
	Boolean getHasChanged();

	/**
	 * Sets the checks for changed.
	 *
	 * @param hasChanged the new checks for changed
	 */
	void setHasChanged(Boolean hasChanged);

}