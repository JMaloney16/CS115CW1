/**
 * Square.java
 * @version 1.0
 * @author Jack Maloney
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the Square's bounding rectangle.
 */

public class Square extends ClosedShape {
    // The length of one side of the square
    private int side;
    /**
     * Creates a closed shape object.
     *
     * @param insertionTime
     * @param x             The x position.
     * @param y             the y position.
     * @param vx            The display component's x velocity.
     * @param vy            The display component's y velocity.
     * @param colour        The line or fill colour.
     * @param isFilled      True if the shape is filled, false if not.
     * @param side          The length of one side
     */
    public Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;
    }

    public Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled,
                  double pulseSize) {
        this(insertionTime, x, y, vx, vy, side, colour, isFilled);
        this.pulseSize = pulseSize;
    }
    /**
     * @return The length of the sides of the square
     */
    public int getSide() {
        return side;
    }

    /**
     * @param side Resets the side lengths of the square
     */
    public void setSide(int side) {
        this.side = side;
    }

    /**
     *
     * @return Square in string format
     */
    public String toString(){
        String result = "This is a square\n";
        result += super.toString();
        result += "Its side length is " + this.side + "\n";
        return result;
    }
    @Override
    public int getHeight(){
        return side;
    }
    @Override
    public int getWidth(){
        return side;
    }

    @Override
    public void setHeight(int height){
        this.side = height;
    }

    @Override
    public void setWidth(int width){
        this.side = width;
    }
    /**
     * Draw the square.
     * @param g The graphics object of the drawable component.
     */
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect(x, y, side, side);
        }
        else {
            g.strokeRect(x, y, side, side);
        }
    }
}
