/*
 * 
 */
package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Observable;

import contract.IOrderPerformer;
import contract.IView;
import contract.UserOrder;
import entity.mobile.IMobile;

import javax.swing.*;

import fr.exia.showboard.BoardFrame;

import entity.IMap;

// TODO: Auto-generated Javadoc
/**
 *  <h1>la Classe View.</h1>
 *
 * @author KETATE
 */
public final class View extends Observable implements IView, KeyListener {

	/**  les fenetres du jeu (Frame). */
	private BoardFrame boardFrame;

	/**  The Game View (une partie de la carte que nous voyons). */
	final Rectangle gameView = new Rectangle(0, 0, 11, 11);

	/** la carte. */
	private IMap map;

	/**  le joueur. */
	private IMobile myPlayer;

	/** l'executant de la commande. */
	private IOrderPerformer orderPerformer;


	/**
	 * Constructeur le nouveau View.
	 *
	 * @param map the map
	 * @param myPlayer the my player
	 */
	public View(final IMap map, final IMobile myPlayer) {
		try {
			this.setmap(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setmyPlayer(myPlayer);
		try {
			this.getmyPlayer().getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.boardFrame = new BoardFrame();
		this.boardFrame.setDimension(new Dimension(this.getmap().getWidth(), this.getmap().getHeight()));
		this.boardFrame.setDisplayFrame(this.gameView);
		this.boardFrame.addKeyListener(this);

		this.boardFrame.addPawn(this.getmyPlayer());

		this.updateView();
	}

	/**
	 * Méthode pour suivre un joueur sur la map afin de génerer la map.
	 */
	@Override
	public final void followMyPlayer() {
		if (this.getmyPlayer().getX() >= this.gameView.width / 2 && this.getmyPlayer().getX() <= this.getmap().getWidth() - this.gameView.width / 2 - 1) {
			this.getgameView().x = this.getmyPlayer().getX() - this.gameView.width / 2;
		}
		if (this.getmyPlayer().getY() >= this.gameView.height / 2 && this.getmyPlayer().getY() <= this.getmap().getHeight() - this.gameView.height / 2 - 1) {
			this.getgameView().y = this.getmyPlayer().getY() - this.gameView.height / 2;
		}
	}

	/**
	 *  mettre à jour la vue avec la nouvelle position des cadres.
	 */
	public void updateView() {
		for (int x = 0; x < this.getmap().getWidth(); x++) {
			for (int y = 0; y < this.getmap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
		this.getmap().getObservable().addObserver(boardFrame.getObserver());
	}

	/**
	 * code clé à la commande de l'utilisateur.
	 *
	 * @param keyCode la clé du code
	 * @return la commande de l'utilisateur
	 */
	private static UserOrder keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;
	}

	/**
	 * Méthode qui affiche le message.
	 *
	 * @param message the message
	 */
	@Override
	public final void displayMessage(final String message) {
		//JOptionPane.showMessageDialog(null, message);
		int choice = JOptionPane.showInternalConfirmDialog(null, message, "BoulderDash",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

		if (choice == 0) {
			boardFrame.dispose();
		} else {
			System.exit(0);
		}
	}



	/**
	 * Méthode qui gère l'appuie sur une touche.
	 *
	 * @param keyEvent the key event
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Méthode qui gère l'appuie sur une touche.
	 *
	 * @param keyEvent the key event
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(final KeyEvent keyEvent) {
		// Nop
	}

	/**
	 *obtenir la carte.
	 *
	 * @return la carte
	 */
	private IMap getmap() {
		return this.map;
	}

	/**
	 * afficher la carte.
	 *
	 * @param map la nouvelle carte
	 * @throws IOException Signale qu'une exception I/O s'est produite.
	 */
	private void setmap(final IMap map) throws IOException {
		this.map = map;
		for (int x = 0; x < this.getmap().getWidth(); x++) {
			for (int y = 0; y < this.getmap().getHeight(); y++) {
				this.getmap().getOnTheMapXY(x, y).getSprite().loadImage();
			}
		}
	}

	/**
	 * obtenir le joueur.
	 *
	 * @return le joueur
	 */
	private IMobile getmyPlayer() {
		return this.myPlayer;
	}

	/**
	 * definir le joueur.
	 *
	 * @param myPlayer the new my player
	 */
	private void setmyPlayer(final IMobile myPlayer) {
		this.myPlayer = myPlayer;
	}


	/**
	 * obtenir le gameView.
	 *
	 * @return le gameView
	 */
	private Rectangle getgameView() {
		return this.gameView;
	}

	/**
	 * obtenir l'interprète de la commande.
	 *
	 * @return l'interprète de commande
	 */
	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
	 * definir le order performer.
	 *
	 * @param orderPerformer le nouveau order performer
	 */
	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	/**
	 * obtenir la commande BoardFrame.
	 *
	 * @return le BoardFrame
	 */
	public BoardFrame getBoardFrame() {
		return boardFrame;
	}
	
	/**
	 * Méthode qui gère l'appuie sur une touche.
	 *
	 * @param e the e
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}