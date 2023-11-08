/*
 * 
 */
package contract;

import fr.exia.showboard.BoardFrame;

// TODO: Auto-generated Javadoc
/**
 * <h1>Interface IView</h1>.
 *
 * @author KETATE
 */
public interface IView {

	/**
	 * Display message.
	 *
	 * @param message the message
	 */
	void displayMessage(final String message);
	
	/**
	 * Follow my player.
	 */
	void followMyPlayer();

	/**
	 * Update view.
	 */
	void updateView();

	/**
	 * Gets the board frame.
	 *
	 * @return the board frame
	 */
	BoardFrame getBoardFrame();

}
