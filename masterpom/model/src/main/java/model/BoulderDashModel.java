package model;

import java.io.IOException;

import contract.IModel;
import entity.IMap;
import entity.mobile.IMobile;
import entity.mobile.MyPlayer;

/**
 * <h1> La classe BoulderDashModel.</h1>

 */
public class BoulderDashModel implements IModel {

	private IMap map;
	private IMobile myPlayer;

	/**
	 * Constructeur d'un nouveau boulder dash model.
	 *
	 * @param myPlayerStartX le départ de mon joueur X
	 * @param myPlayerStartY le départ de mon joueur  Y
	 * @throws IOException signal une exception 
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
	 * A ce niveau on obtient la carte(map)
	 * 
	 * @return this.map
	 */
	@Override
	public final IMap getMap() {
		return this.map;
	}

	/**
	 * definition de la carte.
	 *
	 * @param map la carte à definir
	 */
	private void setMap(final IMap map) {
		this.map = map;
	}

	/**
	 * obtenir le joueur
	 * @return this.myPlayer
	 */
	@Override
	public final IMobile getMyPlayer() {
		return this.myPlayer;
	}

	/**
	 * definir mon joueur
	 *
	 * @param myPlayer le joueur à definir
	 */
	private void setMyPlayer(final IMobile myPlayer) {
		this.myPlayer = myPlayer;
	}

}
