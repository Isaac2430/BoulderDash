/*
 * 
 */
package entity.mobile;

import entity.Permeability;
import entity.Sprite;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe MonsterG</h1>.
 *
 * @author KETATE
 */
public class MonsterG extends Mobile{

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('G', "greenMonster.png");

	/**
	 * Constructeur d'un nouveau monstre vert.
	 */
	public MonsterG() {
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
	 * Getter du diamond.
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