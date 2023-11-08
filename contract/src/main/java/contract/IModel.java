/*
 * 
 */
package contract;
import entity.IMap;
import entity.mobile.IMobile;

// TODO: Auto-generated Javadoc
/**
 * <h1>Interface IModel</h1>.
 *
 * @author KETATE
 */
public interface IModel {
	
	/**
	 * Methode getMap .
	 *
	 * @return the map
	 */
	IMap getMap();
	
	/**
	 * Méthode getMyPlayer.
	 *
	 * @return the my player
	 */
    IMobile getMyPlayer();

}
