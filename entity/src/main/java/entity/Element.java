/*
 * 
 */
package entity;

import java.awt.Image;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe Element</h1>
 * 
 * C'est la classe mère de tous les éléments presents dans le jeu.
 * @author KETATE
 *
 */
public abstract class Element implements IElement {

    /** The sprite. */
    private Sprite sprite;
    
    /** The permeability. */
    private Permeability permeability;
    
    /** The has changed. */
    private Boolean hasChanged = false;

    /**
     * Le constructeur d'element.
     *
     * @param sprite the sprite
     * @param permeability the permeability
     */
    public Element(final Sprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }


    /**
     * Getter de sprite.
     *
     * @return the sprite
     */
    public final Sprite getSprite() {
        return this.sprite;
    }

    /**
     * Setter de sprite.
     *
     * @param sprite (le nouveau sprite)
     */

    protected final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    /*
     * Getter de Permeability
     *
     * @see fr.exia.insanevehicles.model.element.IElement#getPermeability()
     */
    public final Permeability getPermeability() {
        return this.permeability;
    }

    /**
     * Setter de la permeability.
     *
     * @param permeability la nouvelle permeability
     */
    private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }

    /**
     * Getter de Image.
     *
     * @return the image
     */
    public final Image getImage() {
        return this.getSprite().getImage();
    }

    /**
     * Getter de hasChanged.
     *
     * @return hasChanged
     */
    
    public Boolean getHasChanged() {
        return hasChanged;
    }

    /**
     * Setter de hasChanged.
     *
     * @param hasChanged the new checks for changed
     */
    public void setHasChanged(Boolean hasChanged) {
        this.hasChanged = hasChanged;
    }
}