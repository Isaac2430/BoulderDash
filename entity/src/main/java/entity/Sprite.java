/*
 * 
 */
package entity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * <h1>La classe Sprite</h1>.
 *
 * @author KETATE
 * @version 0.1
 */

public class Sprite {

    /** The image. */
    private Image   image;
    
    /** The image name. */
    private String  imageName;
    
    /** The console image. */
    private char    consoleImage;
    
    /** The image loaded. */
    private boolean imageLoaded;
    
    /**
     * Constructeur d'un sprite.
     *
     * @param character the character
     * @param imageName the image name
     */
    public Sprite(final char character, final String imageName) {
        this.setConsoleImage(character);
        this.setImageName(imageName);
    }
    
    /**
     * Constructeur d'un sprite au cas où les valeurs ne sont pas bien entrées.
     *
     * @param character the character
     */
    public Sprite(final char character) {
        this(character, "noimage.jpg");
    }

    /**
     * Getter de l'image.
     *
     * @return this.image
     */
    public final Image getImage() {
        return this.image;
    }

    /**
     * Méthode pour chargé une image.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public final void loadImage() throws IOException {
        this.setImage(ImageIO.read(new File("sprites\\" + this.getImageName())));
    }
    
    /**
     * Getter de consoleImage.
     *
     * @return consoleImage
     */
    public final char getConsoleImage() {
        return this.consoleImage;
    }
    
    /**
     * Setter de l'image.
     *
     * @param image the new image
     */
    private void setImage(final Image image) {
        this.image = image;
    }
    
    /**
     * Setter de consoleImage.
     *
     * @param consoleImage the new console image
     */
    private void setConsoleImage(final char consoleImage) {
        this.consoleImage = consoleImage;
    }
    
    /**
     * Getter de imageName.
     *
     * @return imageName
     */
    public final String getImageName() {
        return this.imageName;
    }
    
    /**
     * Setter de imageName.
     *
     * @param imageName the new image name
     */
   
    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }
    
    /**
     * Méthode qui vérifie si l'image a été chargé.
     *
     * @return true, if is image loaded
     */

    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }

    /**
     * Setter imageLoaded.
     *
     * @param isImageLoaded the new image loaded
     */
    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded;
    }
}
