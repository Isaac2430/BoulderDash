package model;

import java.io.BufferedReader;

import entity.IElement;
import entity.IMap;
import entity.mobile.MobileElementsFactory;
import entity.motionless.MotionlessElementsFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * <h1>la classe Map.</h1>
 *
 *	@author Adri
 */

class Map extends Observable implements IMap {

	/** la largeur. */
	private int width;

	/** la hauteur. */
	private int height;

	/** Sur la carte. */
	private IElement[][] onTheMap;

	private boolean isCorrect = true;

	private List<Integer> hasChanged = new ArrayList<Integer>();

	/**
	 * Constructeur d'une nouvelle carte avec le contenu du fichier fileName .
	 *
	 * @param fileName le nom du fichier ou se trouve la carte
	 * @throws IOException Signale qu'une exception I/O s'est produite.
	 */
	Map(final String fileName) throws IOException {
		super();
		this.loadFile(fileName);
	}

	/**
	 * on charge le fichier.
	 *
	 * @param fileName le nom du fichier
	 * @throws IOException Signale qu'une exception I/O s'est produite..
	 */
	private void loadFile(final String fileName) throws IOException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line;

		try {
			line = buffer.readLine();
			this.setWidth(Integer.parseInt(line));
			line = buffer.readLine();
			this.setHeight(Integer.parseInt(line));
		} catch (Exception | Error e) {
			isCorrect = false;
		}

		if (isCorrect) {
			this.onTheMap = new IElement[this.getWidth()][this.getHeight()];

			int y = 0;
			line = buffer.readLine();
			while (line != null) {
				if (line.toCharArray().length == this.width) {
					for (int x = 0; x < line.toCharArray().length; x++) {
						if (line.toCharArray()[x] == 'R' || line.toCharArray()[x] == 'O' || line.toCharArray()[x] == 'G' || line.toCharArray()[x] == '*') {
							this.setOnTheMapXY(MobileElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
						} else {
							this.setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
						}
					}
				} else {
					this.isCorrect = false;
				}
				line = buffer.readLine();
				y++;
			}
			buffer.close();

			if (y != this.height) {
				this.isCorrect = false;
			}
		}
	}

	/*
	 * Getter de element sur la map
	 *
	 */
	@Override
	public final IElement getOnTheMapXY(final int x, final int y) {
		return this.onTheMap[x][y];
	}

	/**
	 * Definition de XY sur la carte.
	 *
	 * @param element l'element
	 * @param x       X
	 * @param y       Y
	 */
	public void setOnTheMapXY(IElement element, int x, int y) {
		this.onTheMap[x][y] = element;
		this.hasChanged.add(x);
		this.hasChanged.add(y);

	}

	/**
	 * definition du changement du mobile
	 *
	 */
	@Override
	public final void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Obtenir la largeur
	 * 
	 * @return this.width
	 */
	@Override
	public final int getWidth() {
		return this.width;
	}

	/**
	 * definir la largeur.
	 *
	 * @param width la nouvelle largeur
	 */
	private void setWidth(final int width) {
		this.width = width;
	}

	/**
	 * Obtenir la longeur
	 * 
	 * @return this.height
	 *
	 */
	@Override
	public final int getHeight() {
		return this.height;
	}

	/**
	 * definir la longueur.
	 *
	 * @param height la nouvelle longeur
	 */
	private void setHeight(final int height) {
		this.height = height;
	}

	/**
	 * obtenir l'observable 
	 *  @return this
	 */
	@Override
	public Observable getObservable() {
		return this;
	}

	/**
	 * Méthode isCorrect qui vérifie le fichier
	 * @return isCorrect
	 */
	public boolean isCorrect() {
		return isCorrect;
	}

	/**
	 * Getter de HasChanged
	 * 
	 * @return hasChanged
	 */
	public List<Integer> getHasChanged() {
		return hasChanged;
	}

}
