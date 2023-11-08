/*
 * 
 */

package main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import contract.IBoulderDashController;
import contract.IModel;
import controller.Controller;
import model.BoulderDashModel;
import model.DAO.DAOMap;
import view.View;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * *
 * <h1>Classe Main</h1>.
 *
 * @author KETATE
 */

public abstract class Main {


    /** The filenames. */
    private static String[] filenames = new String[] {"sprites/map.txt", "sprites/background.png", "sprites/boulder.png", "sprites/diamond.png", "sprites/door.png", "sprites/greenMonster.png", "sprites/ground.png", "sprites/pDead.png", "sprites/pDown.png", "sprites/pLeft.png", "sprites/pNope.png", "sprites/pRight.png", "sprites/pUp.png", "sprites/pWin.png", "sprites/redMonster.png", "sprites/wall.png"};

    /** The view. */
    private static View view;
    
    /** The model. */
    private static IModel model;
    
    /** The controller. */
    private static  IBoulderDashController controller;

    /**
     * Constructeur de la classe main.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        checkFiles();
        menu();
        game();

        System.exit(0);
    }


    /**
     * La méthode qui vérifie que le fichier de la map existe.
     */
    static void checkFiles() {
        File file;
        for (String filename : filenames) {
            file = new File(filename);
            if (!file.exists()){
                JOptionPane.showMessageDialog(null, "File \"" + filename + "\" is missing.\nPlease put the file back in its place and then restart.", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
                return;
            }
        }
    }
    
    /**
     * La méthode qui demande à l'utilisateur son choix par rapport à l'utilisation de la bdd.
     */
    static void menu() {
    	String message = "Voulez-vous charger sélectionner un nouveau niveau ?";
    	int choice = JOptionPane.showConfirmDialog(null, message, "Question", JOptionPane.YES_NO_OPTION);

       
        DAOMap databaseConnection = null;
        Object[] maps = null;
        

        if (choice == 0) {
            try {
                databaseConnection = new DAOMap();
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Can't connect to database!\nLaunching game without loading a new map.", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                maps = databaseConnection.getLevels();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Can't retrieve map from database!\nLaunching game without loading a new map.", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String map = (String)JOptionPane.showInputDialog(null, "Which map do you want to load?", "BoulderDash - Load map", JOptionPane.PLAIN_MESSAGE, null, maps, maps[0]);

            if (map != null) {
                try {
                    databaseConnection.loadlevel(filenames[0], map);
                } catch ( SQLException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Can't load map into map file!\nLaunching game without loading a new map.", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            return;
        }
    }
    
    /**
     * La methode qui lance le jeu.
     */
    static void game() {
        do {
            model = new BoulderDashModel(filenames[0], 1, 1);

            if (model.getMap().isCorrect()) {
                view = new View(model.getMap(), model.getMyPlayer());
                controller = new Controller(view, model);
                view.setOrderPerformer(controller.getOrderPerformer());

                controller.play();

            } else {
                JOptionPane.showMessageDialog(null, "The map isn't in the right format!\nCheck your map file (map.txt).", "BoulderDash - Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        while(true);
    }
}