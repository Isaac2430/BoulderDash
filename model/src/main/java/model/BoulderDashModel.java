/*
 * 
 */
package model;

import java.io.IOException;

import contract.IModel;
import entity.IMap;
import entity.mobile.IMobile;
import entity.mobile.MyPlayer;

// TODO: Auto-generated Javadoc
/**
 * <h1>The Class BoulderDashModel.</h1>
 *
 * @author Laetitia
 *
 */
/**
 * @author KETATE
 *
 */
public class BoulderDashModel implements IModel {

	/** The map. */
	private IMap map;

	/** The my player. */
	private IMobile myPlayer;

	/**
	 * Instantiates a new boulder dash model.
	 *
	 * @param mapFile the map file
	 * @param myPlayerStartX the my player start X
	 * @param myPlayerStartY the my player start Y
	 */
	public BoulderDashModel(final String mapFile, final int myPlayerStartX, final int myPlayerStartY) {
		try {
			this.setMap(new Map(mapFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.setMyPlayer(new MyPlayer(myPlayerStartX, myPlayerStartY, this.getMap()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	@Override
	public final IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the map to set
	 */
	private void setMap(final IMap map) {
		this.map = map;
	}

	/**
	 * gets the player.
	 *
	 * @return the my player
	 */
	@Override
	public final IMobile getMyPlayer() {
		return this.myPlayer;
	}

	/**
	 * Sets the my player.
	 *
	 * @param myPlayer the player to set
	 */
	private void setMyPlayer(final IMobile myPlayer) {
		this.myPlayer = myPlayer;
	}

}
