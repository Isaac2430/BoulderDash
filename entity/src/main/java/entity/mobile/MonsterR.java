/*
 * 
 */
package entity.mobile;

import entity.Permeability;
import entity.Sprite;

// TODO: Auto-generated Javadoc
/**
 * 	<h1>Classe MonsterR</h1>.
 *
 * @author KETATE
 */

public class MonsterR extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('R', "redMonster.png");

	/**
	 * Constructeur du monstre rouge.
	 */
	public MonsterR() {
		super(SPRITE, Permeability.KILLABLE);
	}

	/**
	 * Methode win qui détermine la victoire du joueur.
	 */
	@Override
	public void win() {
		return;
	}

	/**
	 * Getter des diamonds.
	 *
	 * @return 0
	 */
	@Override
	public int getDiamonds() {
		return 0;
	}

	/**
	 * Getter des diamonds.
	 */
	@Override
	public void grabDiamond() {
		return;
	}
}