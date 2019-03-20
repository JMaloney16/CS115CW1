/**
 * Img.java
 * @version 1.0
 * @author Jack Maloney
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

/**
 * Img is a shape that can be drawn to the screen
 * Its position is determined by the upper left corner of
 * the image's bounding rectangle.
 */
public class Img extends ClosedShape {
    private Image image;
    private int width,height;

    /**
     * Creates a closed shape object
     *
     * @param x     The x position.
     * @param y     The y position.
     * @param vx    The display component's x velocity.
     * @param vy    The display component's y velocity.
     * @param width The width of the image
     * @param height The height of the image
     * @param image The image file to be used
     */
    public Img(int insertionTime, int x, int y, int vx, int vy, int width, int height, Image image) {
        super(insertionTime, x, y, vx, vy, Color.rgb(0,0,0), true);
        this.image = image;
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @param pulseSize The multiplier to calculate the size to pulse to
     */
    public Img(int insertionTime, int x, int y, int vx, int vy, int width, int height, Image image,
               double pulseSize, boolean doesPulse) {
        this(insertionTime, x, y, vx, vy, width, height, image);
        this.pulseSize = pulseSize;
        this.doesPulse = doesPulse;
    }

    /**
     * @return The image file being used
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image Reset the image used
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return The width of the image
     */
    @Override
    public int getWidth(){
        return width;
    }

    /**
     * @param width Reset the width of the image
     */
    public void setWidth(int width){
        this.width = width;
    }

    /**
     * @return The height of the image
     */
    @Override
    public int getHeight(){
        return height;
    }

    /**
     * @param height Reset the height of the image
     */
    public void setHeight(int height){
        this.height = height;
    }

    /**
     * @return Converts the image to a string
     */
    public String toString(){
        String result = "This is an image\n";
        result += super.toString();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        result += "The image file is: " + this.image + "\n";
        return result;
    }

    /**
     * Draw the image
     * @param g The graphics object associated with the drawing component.
     */
    public void draw (GraphicsContext g){
        g.drawImage(image, x, y, width, height);
    }

}
