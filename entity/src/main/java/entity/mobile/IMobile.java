/*
 * 
 */
package entity.mobile;

import java.awt.Point;

import fr.exia.showboard.*;


import entity.IElement;

// TODO: Auto-generated Javadoc
/**
 * <h1>L'Interface IMobile.</h1>
 * 
 * @author KETATE
 * @see IPawn
 * @see IElement
 */
public interface IMobile extends IPawn, IElement {

    /**
     * Méthode pour se déplacer au dessus.
     */
    void moveUp();

    /**
     * Méthode pour se déplacer à gauche.
     */
    void moveLeft();

    /**
     * Méthode pour se déplacer en bas..
     */
    void moveDown();

    /**
     * Méthode pour se déplacer à droite.
     */
    void moveRight();

    /**
     * Méthode Donothing (Ne rien faire).
     */
    void doNothing();
    /**
     * Getter de x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Getter de y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Vérifie si le joueur est en vie.
     *
     * @return alive
     */
    Boolean isAlive();


    /**
     * Getter de la position.
     *
     * @return the position
     */
    @Override
    Point getPosition();

	/**
	 * Méthode Die.
	 */
	public void die();

    /**
     * Méthode Win.
     */
    public void win();
	
	/**
	 * Getter des diamands.
	 *
	 * @return int
	 */
	public int getDiamonds();

    /**
     * Getter diamands.
     *
     * @return int
     */
    public void grabDiamond();

}