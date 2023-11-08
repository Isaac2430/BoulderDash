/*
 * 
 */
package entity.mobile;

import java.io.IOException;

import entity.IMap;
import entity.Permeability;
import entity.Sprite;
import entity.motionless.MotionlessElementsFactory;

// TODO: Auto-generated Javadoc
/**
 * <h1>La Classe MyPlayer.</h1>
 *
 * @author KETATE
 */
public class MyPlayer extends Mobile {

	/** La Constante SPRITE. */
	private static final Sprite sprite = new Sprite('H', "pNope.png");
	/** La Constante spriteTurnLeft. */
	private static final Sprite spriteTurnLeft = new Sprite('H', "pLeft.png");
	/** La Constante spriteTurnRight. */
	private static final Sprite spriteTurnRight = new Sprite('H', "pRight.png");
	/** La Constante spriteTurnUp. */
	private static final Sprite spriteTurnUp = new Sprite('H', "pUp.png");
	/** La Constante spriteTurnDown. */
	private static final Sprite spriteTurnDown = new Sprite('H', "pDown.png");
	/** La Constante spriteDead. */
	private static final Sprite spriteDead = new Sprite('H', "pDead.png");
	/** La Constante spriteWin. */
	private static final Sprite spriteWin = new Sprite('H', "pWin.png");

	/** The nb diamonds. */
	private int nb_diamonds;

	/**
	 * Constructeur d'un nouveau joueur.
	 *
	 * @param x   le x
	 * @param y   le y
	 * @param map la map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public MyPlayer(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.WALL);
		spriteTurnLeft.loadImage();
		spriteTurnRight.loadImage();
		spriteTurnUp.loadImage();
		spriteTurnDown.loadImage();
		spriteDead.loadImage();
		spriteWin.loadImage();
	}


	/**
	 * Méthode pour déplacer le joueur à gauche
	 * 
	 * Elle vérifie que les permeability sont respectées puis elle génère le sprite.
	 */
	@Override
	public final void moveLeft() {
		if ((getMap().getOnTheMapXY((getX() - 1), ((getY()))).getPermeability() == Permeability.WALL) || (getMap().getOnTheMapXY((getX() - 1), ((getY()))).getPermeability() == Permeability.BOULDER)) {
			doNothing();
			pushBoulderLeft();
			this.setSprite(spriteTurnLeft);
		} else {
			super.moveLeft();
			this.setSprite(spriteTurnLeft);
			dig();
			grabDiamond();
			this.setHasMoved();
		}
	}

	/**
	 * Méthode pour déplacer le joueur à droite
	 * 
	 * Elle vérifie que les permeability sont respectées puis elle génère le sprite.
	 */
	@Override
	public final void moveRight() {
		if (getMap().getOnTheMapXY(getX() + 1, getY()).getPermeability() == Permeability.WALL || (getMap().getOnTheMapXY((getX() + 1), ((getY()))).getPermeability() == Permeability.BOULDER)) {
			doNothing();
			pushBoulderRight();
			this.setSprite(spriteTurnRight);
		} else {
			super.moveRight();
			this.setSprite(spriteTurnRight);
			dig();
			grabDiamond();
			this.setHasMoved();
		}
	}

	/**
	 * Méthode pour déplacer le joueur en bas
	 * 
	 * Elle vérifie que les permeability sont respectées puis elle génère le sprite.
	 */
	public final void moveDown() {
		if ((getMap().getOnTheMapXY((getX()), (getY() + 1)).getPermeability() != Permeability.WALL) && (getMap().getOnTheMapXY((getX()), (getY() + 1))).getPermeability() != Permeability.BOULDER) {
			super.moveDown();
			this.setSprite(spriteTurnDown);
			dig();
			grabDiamond();
			this.setHasMoved();
		} else {
			doNothing();
		}
	}

	/**
	 * Méthode pour déplacer le joueur au dessus
	 * 
	 * Elle vérifie que les permeability sont respectées puis elle génère le sprite.
	 */
	public final void moveUp() {
		if ((getMap().getOnTheMapXY((getX()), (getY() - 1)).getPermeability() != Permeability.WALL) && (getMap().getOnTheMapXY((getX()), (getY() - 1))).getPermeability() != Permeability.BOULDER) {
			grabDiamond();
			super.moveUp();
			this.setSprite(spriteTurnUp);
			dig();
			grabDiamond();
			this.setHasMoved();
		} else {
			doNothing();
		}
	}

	/**
	 * La mort du joueur
	 * 
	 * Elle détermine la mort du joueur en générant le sprite approprié.
	 */
	@Override
	public final void die() {
		super.die();
		this.setSprite(spriteDead);
	}

	/**
	 * La victoire du joueur
	 * 
	 * Elle détermine la victoire du joueur en générant le sprite approprié.
	 */
	@Override
	public final void win() {
		this.setSprite(spriteWin);
	}

	/**
	 * La méthode lorsque Le joueur ne fait rien, il génère un sprite approprié pour cet événement.
	 */
	@Override
	public final void doNothing() {
 		super.doNothing();
		this.setSprite(sprite);
		this.dig();
		this.grabDiamond();
	}

	/**
	 * La méthode pour creusser la terre
	 * 
	 * Elle crée le background là où il y a la terre.
	 */
	public void dig() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.DIGGABLE) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX(), this.getY());
			this.setHasMoved();
		}
	}


	/**
	 * Obtenir des diamands
	 * 
	 * La méthode qui permet au joueur de gagner les diamonds durant la partie.
	 */
	public void grabDiamond() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.DIAMOND) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX(), this.getY());
			nb_diamonds++;
		}
	}

	/**
	 * Méthode pour pousser le rocher à droite
	 * 
	 * Elle vérifie que les permeability sont respectées puis elle génère le sprite.
	 */
	public void pushBoulderRight() {
		if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.BOULDER && this.getMap().getOnTheMapXY(this.getX() + 2, this.getY()).getPermeability() == Permeability.WALKABLE) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX() + 1, this.getY());
			super.moveRight();
			this.getMap().setOnTheMapXY(MobileElementsFactory.createRock(), this.getX() + 1, this.getY());
			this.setHasMoved();
		}
	}

	/**
	 * Méthode pour pousser le rocher à gauche
	 * 
	 * Elle vérifie que les permeability sont respectées puis elle génère le sprite.
	 */
	public void pushBoulderLeft() {
		if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.BOULDER && this.getMap().getOnTheMapXY(this.getX() - 2, this.getY()).getPermeability() == Permeability.WALKABLE) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX() - 1, this.getY());
			super.moveLeft();
			this.getMap().setOnTheMapXY(MobileElementsFactory.createRock(), this.getX() - 1, this.getY());
			this.setHasMoved();
		}
	}

	/**
	 * getter des diamands.
	 *
	 * @return nb_diamonds (le nombre de diamonds)
	 */
	public int getDiamonds() {
		return nb_diamonds;
	}
}