/*
 * 
 */
package entity ;

import java.util.List;
import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * <h1>Interface IMap.</h1>
 *
 * @author KETATE
 * @version 0.1
 */
public interface IMap {

    /**
     * Getter de width (la largeur).
     *
     * @return width
     */
    int getWidth();

    /**
     * Getter de height(la hauteur).
     *
     * @return height
     */
    int getHeight();

    /**
     * Obtenir la map XY.
     *
     * @param x
     *            Coordonnée x
     * @param y
     *            Coordonnée y
     * @return la route
     */
    IElement getOnTheMapXY(int x, int y);
    
    /**
     * Modifie la map XY .
     *
     * @param element the element
     * @param x the x
     * @param y the y
     */
    void setOnTheMapXY(IElement element, final int x, final int y);

    /**
     * Setter du mobile qui a changé.
     */
    void setMobileHasChanged();

    /**
     * Obtenir l'observable.
     *
     * @return observable
     */
    Observable getObservable();

    /**
     * Checks if is correct.
     *
     * @return true, if is correct
     */
    boolean isCorrect();

    /**
     * Gets the checks for changed.
     *
     * @return the checks for changed
     */
    List<Integer> getHasChanged();


}