/**
 * Rect.java
 * @version 1.0
 * @author Jack Maloney
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rect extends ClosedShape {
    //The height and length of the rectangle
    private int width,height;
    /**
     * Creates a closed shape object.
     *
     * @param x             The x position.
     * @param y             the y position.
     * @param vx            The display component's x velocity.
     * @param vy            The display component's y velocity.
     * @param colour        The line or fill colour.
     * @param isFilled      True if the shape is filled, false if not.
     */
    public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @param pulseSize The multiplier to calculate the size to pulse to
     */
    public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled,
                double pulseSize){
        this(insertionTime, x ,y ,vx, vy, width, height, colour, isFilled);
        this.pulseSize = pulseSize;
    }
    /**
     * @return The width of the rectangle
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * @param width Resets the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return The height of the rectangle
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * @param height Reset the height of the rectangle
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return Converts the rectangle to a string
     */
    public String toString(){
        String result = "This is a rectangle\n";
        result += super.toString();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * Draw the rectangle.
     * @param g The graphics object associated with the drawing component.
     */
    public void draw (GraphicsContext g){
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled){
            g.fillRect(x, y, width, height);
        }
        else {
            g.strokeRect(x, y, width, height);
        }
    }
}
