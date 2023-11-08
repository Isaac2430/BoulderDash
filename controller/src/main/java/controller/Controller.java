/*
 * 
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import contract.IOrderPerformer;
import contract.IBoulderDashController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;
import entity.Permeability;
import entity.mobile.MobileElementsFactory;
import entity.motionless.MotionlessElementsFactory;

// TODO: Auto-generated Javadoc
/**
 * <h1>Classe Controller</h1>
 * 
 * C'est la classe qui joue le rôle d'interface entre le view et le model.
 * 
 * @author KETATE
 *
 */
public final class Controller implements IBoulderDashController, IOrderPerformer {

	/** The Constant speed. */
	private static final int speed = 300;
    
    /** The view. */
    private IView view;
    
    /** The model. */
    private IModel model;
    
    /** The stack order. */
    private UserOrder stackOrder;
    
    /** The diamond goal. */
    private final int diamondGoal = 12;
    
    /** The has won. */
    private boolean hasWon = false;
    
    /** The rand. */
    private final Random rand = new Random();
    
    /** The rdirection. */
    private int rdirection;
    
    /** The g direction. */
    private int gDirection;
    
    /** The can change. */
    private boolean canChange = true;
    
    /** The compteur. */
    private int compteur;
    
    /**
     * Le constructeur du controller.
     *
     * @param view the view
     * @param model the model
     */
    public Controller(final IView view, final IModel model) {
        this.setView(view);
        this.setModel(model);
        this.clearStackOrder();
    }
    
    /**
     * Méthode jouer
     * 
     * Elle lance le jeu, règle la vitesse du jeu, met à jour la vue ainsi que les entités mobiles sur la map.
     */
    @Override
    public final void play() {
        while (this.getModel().getMyPlayer().isAlive() == true && hasWon == false) {

            // --- Vitesse du jeu ---
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // --- Joueur ---
            this.movePlayer();
            this.killPlayer();
            this.winPlayer();

            gDirection = gDirection + 1;
            rdirection = rand.nextInt(4);

            // --- Mise à jour des entités mobiles sur la map
            for (int y = this.getModel().getMap().getHeight() - 1; y > 0; y--) {
                for (int x = this.getModel().getMap().getWidth() - 1; x > 0; x--) {

                    for (int g = 0; g < this.getModel().getMap().getHasChanged().size(); g = g + 2) {
                        if (this.getModel().getMap().getHasChanged().get(g) == x || this.getModel().getMap().getHasChanged().get(g + 1) == y) {
                            this.canChange = false;
                        }
                    }

                    if (canChange) {
                        // --- Boulders ---
                        this.gravityBoulder(x, y);
                        this.gravityDiagBoulder(x, y);

                        // --- Diamonds ---
                        this.gravityDiamond(x, y);
                        this.gravityDiagDiamond(x, y);

                        // --- Monsters ---
                        this.killMonster(x, y);
                        this.moveGMonster(x, y);
                        this.moveRMonster(x, y);
                    }
                    this.canChange = true;
                }
            }

            // --- Mise à jour du View ---
            this.getModel().getMap().getHasChanged().clear();
            this.canChange = true;
            this.getView().followMyPlayer();
            this.getView().updateView();
            this.getView().getBoardFrame().setTitle("BoulderDash - Diamond Counter: " + this.getModel().getMyPlayer().getDiamonds());
        }
    }


    /**
     * La méthode movePlayer(déplacer le joueur)
     * 
     * Elle permet de déplacer le joueur en appelant une méthode spécifique par rapport aux commandes du clavier.
     *  
     */
    public void movePlayer() {
        switch (this.getStackOrder()) {
            case UP:
                this.getModel().getMyPlayer().moveUp();

                break;
            case DOWN:
                this.getModel().getMyPlayer().moveDown();

                break;
            case RIGHT:
                this.getModel().getMyPlayer().moveRight();

                break;
            case LEFT:
                this.getModel().getMyPlayer().moveLeft();

                break;
            case NOP:
            default:
                this.getModel().getMyPlayer().doNothing();
                break;
        }
        this.clearStackOrder();
    }

    /**
     * La méthode killPlayer (mort du joueur)
     * 
     * Elle vérifie si les conditions sont respectées par rapport à la mort du joueur puis elle appelle la fonction die() et envoie un message.
     * 
     */
    public void killPlayer() {
        if ((this.getModel().getMap().getOnTheMapXY((this.getModel().getMyPlayer().getX()), ((this.getModel().getMyPlayer().getY()))).getPermeability() == Permeability.KILLABLE)) {
            this.getModel().getMyPlayer().die();
            this.getView().displayMessage("Vous avez échoué! Voulez-vous continuer ?");
        }
    }
    
    /**
     * La méthode winPlayer (victoire du joueur)
     * Elle vérifie si les conditions sont respectées pour la victoire du joueur puis elle appelle la fonction win() et envoie un message.
     */
    public void winPlayer() {
        if ((this.getModel().getMap().getOnTheMapXY((this.getModel().getMyPlayer().getX()), ((this.getModel().getMyPlayer().getY()))).getPermeability() == Permeability.EXIT) && this.getModel().getMyPlayer().getDiamonds() >= diamondGoal) {
            this.hasWon = true;
            this.getModel().getMyPlayer().win();
            this.getView().displayMessage("Vous avez gagné, Felicitation! Voulez-vous recommencer ?");
        }
    }


    /**
     * Méthode gravityBoulder 
     * Elle gère la gravité de la pierre de facon verticale.
     *
     * @param x the x
     * @param y the y
     */
    public void gravityBoulder(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.BOULDER && this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.WALKABLE) {
            if (x != this.getModel().getMyPlayer().getX() || y + 1 != this.getModel().getMyPlayer().getY()) {
                this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
                this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createRock(), x, y + 1);
            }
        }
    }
    
    /**
     * La méthode qui gère la gravité diagonal des rochers.
     *
     * @param x the x
     * @param y the y
     */
    public void gravityDiagBoulder(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.BOULDER && this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.BOULDER) {
            if (this.getModel().getMap().getOnTheMapXY(x + 1, y + 1).getPermeability() == Permeability.WALKABLE && this.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == Permeability.WALKABLE) {
                if (x + 1 != this.getModel().getMyPlayer().getX() || y + 1 != this.getModel().getMyPlayer().getY()) {
                    if (x + 1 != this.getModel().getMyPlayer().getX() || y != this.getModel().getMyPlayer().getY()) {
                        this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
                        this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createRock(), x + 1, y);
                    }
                }
            }
        }
        if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.BOULDER && this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.BOULDER) {
            if (this.getModel().getMap().getOnTheMapXY(x - 1, y + 1).getPermeability() == Permeability.WALKABLE && this.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == Permeability.WALKABLE) {
                if (x - 1 != this.getModel().getMyPlayer().getX() || y + 1 != this.getModel().getMyPlayer().getY()) {
                    if (x - 1 != this.getModel().getMyPlayer().getX() || y != this.getModel().getMyPlayer().getY()) {
                        this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
                        this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createRock(), x - 1, y);
                    }
                }
            }
        }
    }
    
    /**
     * La méthode qui gère la gravité verticale des diamands.
     *
     * @param x the x
     * @param y the y
     */
    public void gravityDiamond(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.DIAMOND && this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.WALKABLE) {
            if (x != this.getModel().getMyPlayer().getX() || y + 1 != this.getModel().getMyPlayer().getY()) {
                this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
                this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createDiamond(), x, y + 1);
            } else if (x == this.getModel().getMyPlayer().getX() && y + 1 == this.getModel().getMyPlayer().getY()) {
                this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
                this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createDiamond(), x, y + 1);
            }
        }
    }
    
    /**
     * La méthode qui gère la gravité diagonal des diamands.
     *
     * @param x the x
     * @param y the y
     */
    public void gravityDiagDiamond(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.DIAMOND && this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.DIAMOND) {
            if (this.getModel().getMap().getOnTheMapXY(x + 1, y + 1).getPermeability() == Permeability.WALKABLE && this.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == Permeability.WALKABLE) {
                this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
                this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createDiamond(), x + 1, y);
            }
        }
        if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.DIAMOND && this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.DIAMOND) {
            if (this.getModel().getMap().getOnTheMapXY(x - 1, y + 1).getPermeability() == Permeability.WALKABLE && this.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == Permeability.WALKABLE) {
                this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
                this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createDiamond(), x - 1, y);
            }
        }
    }


    /**
     * Méthode killMonster
     * La méthode qui gère la mort d'un monstre
     * Elle vérifie que les conditions sont respectées pour la mort d'un monstre  puis elle génère les diamonds par rapport au cas spécifique.
     *
     * @param x the x
     * @param y the y
     */
    public void killMonster(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.KILLABLE && this.getModel().getMap().getOnTheMapXY(x, y - 1).getPermeability() == Permeability.BOULDER || this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.KILLABLE && this.getModel().getMap().getOnTheMapXY(x, y - 1)
                .getPermeability() == Permeability.DIAMOND) {
            this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createDiamond(), x, y);

            for (int i = x - 1; i < x + 2; i++) {
                for (int j = y - 1; j < y + 2; j++) {
                    if (getModel().getMap().getOnTheMapXY(i, j).getPermeability() == Permeability.WALKABLE) {
                        this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createDiamond(), i, j);
                    }
                }
            }
        }
    }

       
    /**
     * Méthode générale de déplacement des monstres verts sur la map .
     *
     * @param x the x
     * @param y the y
     */
    public void moveGMonster(int x, int y) {
        if (gDirection <= 10) {
            MGMoveRight(x, y);
        } else if (gDirection <= 20) {
            MGMoveLeft(x, y);
        } else {
            gDirection = 0;
        }

    }

    /**
     * Méthode qui gère le déplacement du monstre vert vers la droite.
     *
     * @param x the x
     * @param y the y
     */
    public void MGMoveRight(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'G' && this.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == Permeability.WALKABLE) {
            this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
            this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterG(), x + 1, y);
        }
    }

   /**
    * Méthode qui gère le déplacement du monstre vert vers la gauche.
    *
    * @param x the x
    * @param y the y
    */
    public void MGMoveLeft(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'G' && this.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == Permeability.WALKABLE) {
            this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
            this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterG(), x - 1, y);
        }
    }

   /**
    * Méthode génèrale de déplacement des monstres rouges en respectant chaque cas
    * (NB : Le monstre rouge est cencé se deplacer dans toute les directions).
    *
    * @param x the x
    * @param y the y
    */
    public void moveRMonster(int x, int y) {
        switch (rdirection) {
            case 1:
                MRMoveRight(x, y);
                break;
            case 0:
                MRMoveLeft(x, y);
                break;
            case 2:
                MRMoveUp(x, y);
                break;
            case 3:
                MRMoveDown(x, y);
                break;

            default:
                break;
        }
    }

    /**
     * Méthode qui gère le déplacement du monstre rouge vers la droite.
     *
     * @param x the x
     * @param y the y
     */
    public void MRMoveRight(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'R' && this.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == Permeability.WALKABLE) {
            this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
            this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterR(), x + 1, y);
        }
    }

    /**
     * Méthode qui gère le déplacement du monstre rouge vers la gauche.
     *
     * @param x the x
     * @param y the y
     */
    public void MRMoveLeft(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'R' && this.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == Permeability.WALKABLE) {
            this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
            this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterR(), x - 1, y);
        }
    }

    /**
     * Méthode qui gère le déplacement du monstre rouge vers le haut.
     *
     * @param x the x
     * @param y the y
     */
    public void MRMoveUp(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'R' && this.getModel().getMap().getOnTheMapXY(x, y - 1).getPermeability() == Permeability.WALKABLE) {
            this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
            this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterR(), x, y - 1);
        }
    }

    /**
     * Méthode qui gère le déplacement du monstre rouge vers le bas.
     *
     * @param x the x
     * @param y the y
     */
    public void MRMoveDown(int x, int y) {
        if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'R' && this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.WALKABLE) {
            this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
            this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterR(), x, y + 1);
        }
    }


    /**
     * Getter du view.
     *
     * @return this.view
     */
    private IView getView() {
        return this.view;
    }

    /**
     * Setter du view.
     *
     * @param view the new view
     */
    private void setView(final IView view) {
        this.view = view;
    }

    /**
     * Getter du model.
     *
     * @return this.model
     */
    private IModel getModel() {
        return this.model;
    }

    /**
     * Setter du model.
     *
     * @param model the new model
     */
    private void setModel(final IModel model) {
        this.model = model;
    }

    /**
     * Getter du StackOrder.
     *
     * @return this.stackOrder
     */
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Setter de stackOrder.
     *
     * @param stackOrder the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Méthode clearStackOrder
     * Elle réinitialise le stackOrder.
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    /**
     * Getter du OrderPerformer.
     *
     * @return this
     */
    @Override
    public IOrderPerformer getOrderPerformer() {
        return this;
    }

    /**
     * Méthode orderPerform()
     * Elle modifie le stackOrder.
     *
     * @param userOrder the user order
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }
    
    /**
     * le Getteur du compteur.
     *
     * @return the compteur
     */
	public int getCompteur() {
		return compteur;
	}
	
	/**
	 * le Setteur du compteur.
	 *
	 * @param compteur the new compteur
	 */
	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	
}