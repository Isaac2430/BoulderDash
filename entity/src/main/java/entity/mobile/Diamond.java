/*
 * 
 */
package entity.mobile;

import entity.Permeability;
import entity.Sprite;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe Diamond</h1>.
 *
 * @author KETATE
 */
public class Diamond extends Mobile{

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('*', "diamond.png");


	/**
	 * Constructeur du Diamand.
	 */
	 public Diamond() {
		super(SPRITE, Permeability.DIAMOND);
	}

	 /**
 	 * Méthode win.
 	 */
	@Override
	public void win() {
		// TODO Auto-generated method stub
		return;
	}

	/**
	 * Getter des diamonds.
	 *
	 * @return 0
	 */
	@Override
	public int getDiamonds() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Méthode qui permet d'obtenir les diamonds.
	 */
	@Override
	public void grabDiamond() {
		return;
	}
}