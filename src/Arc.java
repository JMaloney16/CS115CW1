/**
 * Arc.java
 * @version 1.0
 * @author Jack Maloney
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.util.Enumeration;

/**
 * Arc is an arc shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the oval's bounding rectangle
 */
public class Arc extends ClosedShape {

    private int width, height, startAngle, arcExtent; //Start angle and extent of the arc are in degrees
    private ArcType closure;

    /**
     * Creates an arc
     *
     * @param x             The x position
     * @param y             The y position
     * @param vx            The display component's x velocity.
     * @param vy            The display component's y velocity.
     * @param width         The width of the arc (in pixels)
     * @param height        The height of the arc (in pixels)
     * @param startAngle    The starting angle of the arc in degrees
     * @param arcExtent     The angular extent of the arc in degrees
     * @param closure       The closure type of the arc (round, open or chord)
     * @param colour        The colour of the arc
     * @param isFilled      True if the arc is filled with colour, false if opaque
     */
    public Arc(int insertionTime, int x, int y, int vx, int vy, int width, int height, int startAngle, int arcExtent,
            String closure, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.arcExtent = arcExtent;
        try {
            this.closure = ArcType.valueOf(closure);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(closure + " is not a valid ArcType! The shape has been set to ROUND");
            this.closure = ArcType.ROUND;
        }
    }

    public Arc(int insertionTime, int x, int y, int vx, int vy, int width, int height, int startAngle, int arcExtent,
               String closure, Color colour, boolean isFilled, double pulseSize){
        this(insertionTime, x, y, vx, vy, width, height, startAngle, arcExtent, closure, colour, isFilled);
        this.pulseSize = pulseSize;
    }
    /**
     * Method to convert an arc to a string
     */
    public String toString(){
        String result = "This is an arc\n";
        result += super.toString();
        result += "It's width is " + this.width + ", it's height is " + this.height + ", it's starting angle is " +
                startAngle + " and it's angular extent is " + arcExtent + "\n";
        return result;
    }

    /**
     * @param width Resets the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height Resets the width
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return The width of the arc
     */
    @Override
    public int getWidth(){
        return width;
    }

    /**
     * @return The height of the arc
     */
    @Override
    public int getHeight(){
        return height;
    }

    /**
     * @return The starting angle of the arc
     */
    public int getStartAngle() {
        return startAngle;
    }

    /**
     * @param startAngle Resets the starting angle
     */
    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    /**
     * @return The angular extent of the arc
     */
    public int getArcExtent() {
        return arcExtent;
    }

    /**
     * @param arcExtent Resets the angular extent
     */
    public void setArcExtent(int arcExtent) {
        this.arcExtent = arcExtent;
    }

    /**
     * Draw the arc.
     * @param g The graphics object associated with the drawing component.
     */
    public void draw (GraphicsContext g){
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled){
            g.fillArc(x, y, width, height, startAngle, arcExtent, closure);
        }else{
            g.strokeArc(x, y, width, height, startAngle, arcExtent, closure);
        }
    }
}
