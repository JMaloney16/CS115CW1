

/**
 * ClosedShape.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * A ClosedShape is any shape that can be drawn without
 * taking a pencil off a piece of paper.
 * It's representation on computer has a line colour
 * and a position on the drawable screen component.
 * It can be filled in with colour or opaque.
 * This class is a super class for all shapes.
 */

public class ClosedShape {
	
	/**
	 *  The x position of the Shape.
	 */
	protected int x;
 	/**
 	 * The y position of the Shape.
 	 */
 	protected int y;

	/**
	 *  The x position of the Shape.
	 */
	protected int xVec;
	
	/**
	 * The y position of the Shape.
	 */
	protected int yVec;

	/**
	 * The line colour of the shape, or the filled in
	 * colour if the Shape has fill.
	 */
	protected Color colour;

	/**
	 * Determines if the Shape has a fill colour or not.
	 */
	protected boolean isFilled;

	/**
	 * Encodes the insertion time into the scene
	 */
	private int insertionTime;

	/**
	 * Boolean that determines whether a shape should pulse
	 */
	protected boolean doesPulse = false;
	/**
	 * The multiplier by which to calculate the size shapes should pulse to
	 */
	protected double pulseSize;
	/**
	 * Used to determine whether the shape needs to increase in size or shrink during pulsing
	 */
	protected boolean enlargement = false;

	/**
	 * The width the shape will pulse to
	 */
	protected double pulseWidth;
	/**
	 * The height the shape will pulse to
	 */
	protected double pulseHeight;
	/**
	 * The starting width of the shape, used to stop the shape from increasing or decreasing in size indefinitely
	 */
	protected int originalWidth;
	/**
	 * The starting height of the shape
	 */
	protected int originalHeight;

	/**
	 * Creates a closed shape object.
	 * @param x The x position.
	 * @param y the y position.
	 * @param colour The line or fill colour.
	 * @param isFilled True if the shape is filled, false if not.
	 */
	protected ClosedShape (int insertionTime, int x, int y, int vx, int vy, Color colour, boolean isFilled ) {
		this.x = x;
		this.y = y;
		this.xVec = vx;
		this.yVec = vy;
		this.colour = colour;
		this.isFilled = isFilled;
		this.insertionTime = insertionTime;
	}

	protected ClosedShape (int insertionTime, int x, int y, int vx, int vy, Color colour, boolean isFilled,
                           double pulseSize, boolean doesPulse ){
	    this(insertionTime, x, y, vx, vy, colour, isFilled);
	    this.doesPulse = doesPulse;
	    this.pulseSize = pulseSize;
    }

	/**
	 * The method returns a string suitable for printing.
	 * @return string to print out shape.
	 */
	public String toString () {
		String result = "";
		result += "Its position is " + x + " " + y + "\n";
		result += "Its velocity is " + xVec + " " + yVec + "\n";
		result += "Its colour is " + colour + "\n";
		if (isFilled)
			result += "It is filled" + "\n";
		else
			result += "It is not filled" + "\n";
		result += "It should be inserted at " + insertionTime + "\n";
		return result;
	}

	/**
	 * Resets the x position.
	 */
 	public void setX (int x) {
		this.x = x;
	}

 	/**
 	 * Resets the y position.
 	 */
 	public void setY (int y) {
		this.y = y;
	}

	/**
	 * Resets the x vector
	 */
	 public void setVecX (int x) {
		this.xVec = x;
	 }//end setVecX

	/**
	 * Resets the y position.
	 */
	 public void setVecY (int y) {
		this.yVec = y;
	}//end setVecY

	 /**
	  * Resets the colour.
	  */
	 public void setColour (Color colour) {
	 	this.colour = colour;
	 }

	 /**
	  * Sets the shape to filled.
	  */
	 public void setFilled () {
		 isFilled = true;
	 }

	 /**
	  * Sets the shape to unfilled.
	  */
	 public void unsetFilled () {
	 	isFilled = false;
	 }

	 /**
	  * Sets the insertion time.
	  */
	 public void setInsertionTime (int time) {
		 insertionTime = time;
	 }

	 /**
	  * @return The x position value.
	  */
	 public int getX() {
	 	return x;
	 }

	 /**
	  * @return The y position value.
	  */
	 public int getY() {
	 	return y;
	 }

	 /**
	  * @return The colour.
	  */
	 public Color getColour() {
	 	return colour;
	 }

	 /**
	  * @return True if the shape is filled, false if not.
	  */
	 public boolean isFilled() {
	 	return isFilled;
	 }

	 /**
	  * @return the insertion time.
	  */
	 public int getInsertionTime () {
		 return insertionTime;
	 }


	 /**
	  * Puts the shape back in bounds in X
	  */
	 public void putInBoundsX (double winX) {
	 	if (x < 0) x = 0;
	 	if (x + this.getWidth() > winX) {
	 		x = (int) (winX - Math.ceil (this.getWidth ()));
	 	}
	 }//end inBoundsX;

	 /**
	  * Puts the shape back in bounds
	  */
	 public void putInBoundsY (double winY) {
	 	if (y < 0) y = 0;
	 	if (y + this.getHeight() > winY) {
	 		y = (int) (winY - Math.ceil (this.getHeight ()));
	 	}
	 }//end inBoundsY;

	 /**
	  * Bounces the shape off a vertical wall
	  */
	 public void bounceX () {
	 	xVec = -xVec;
	 }

	 /**
	  * Bounces the shape off a horizontal wall
	  */
	 public void bounceY () {
	 	yVec = -yVec;
	 }

	 /**
	  * Returns true if the shapes have gone out of bounds in X
	  */
	 public boolean outOfBoundsX (double winX) {
	 	return (x + this.getWidth()> winX) || (x < 0);
	 }

	 /**
	  * Returns true if the shapes have gone out of bounds in Y
	  */
	 public boolean outOfBoundsY (double winY) {
	 	return (y + this.getHeight() > winY) || (y < 0);
	 }

	 /**
	  * Takes in a direction and a velocity and moves the shape
	  * in that direction on unit
	  */
	 public void move () {
	 	x += xVec;
	 	y += yVec;
	 }

	 /**
	  * Draws the object to the current component.
	  * @param g The graphics object associated with the drawing component.
	  */
	 public void draw (GraphicsContext g) {
	 	System.out.println ("You forgot to override this method! (draw)");
	 	System.out.println ("Don't modify this method.");
	 }

	 /**
	  * Get the width of the current component
	  */
	 public int getWidth () {
	 	System.out.println ("You forgot to override this method! (getWidth)");
	 	System.out.println ("Don't modify this method.");
	 	return 1;
	 }

	/**
	 * Set the height of the shape
	 * @param newWidth Value to set the width to
	 */
	 public void setWidth(int newWidth){
         System.out.println("Must be overwritten!");
     }

	 /**
	  * Get the width of the current component
	  */
	 public int getHeight () {
	 	System.out.println ("You forgot to override a method! (getHeight)");
	 	System.out.println ("Don't modify this method.");
	 	return 1;
	 }

	/**
	 * Set the height of the shape
	 * @param newHeight Value to set height to
	 */
	 public void setHeight(int newHeight){
         System.out.println("Must be overwritten!");
     }

	/**
	 * @return The original width of the shape
	 */
	public int getOriginalWidth() {
		return originalWidth;
	 }

	/**
	 * Reset the original width of the shape
	 * @param originalWidth New value of the originalWidth
	 */
	 public void setOriginalWidth(int originalWidth) {
		this.originalWidth = originalWidth;
	 }

	/**
	 * @return The original height of the shape
	 */
	public int getOriginalHeight() {
		return originalHeight;
	 }

	/**
	 * Reset the original height of the shape
	 * @param originalHeight New value of the originalHeight
	 */
	 public void setOriginalHeight(int originalHeight) {
		this.originalHeight = originalHeight;
     }

	/**
	 * @return The current value of the enlargement attribute
	 */
    public boolean isEnlargement() {
        return enlargement;
    }

	/**
	 * Reset the value of the enlargement attribute
	 * @param enlargement New value of enlargment
	 */
	public void setEnlargement(boolean enlargement) {
        this.enlargement = enlargement;
    }

	/**
	 * @return The multiplier used for calculating pulse sizes
	 */
	public double getPulseSize() {
        return pulseSize;
    }

	/**
	 * Reset the pulse multiplier
	 * @param pulseSize The new value for the pulse multiplier
	 */
	public void setPulseSize(double pulseSize) {
        this.pulseSize = pulseSize;
    }

	/**
	 * @return The width the shape pulses to
	 */
	public double getPulseWidth() {
        return pulseWidth;
    }

	/**
	 * Reset the value of the width to pulse to
	 * @param pulseWidth The new width to pulse to
	 */
	public void setPulseWidth(double pulseWidth) {
        this.pulseWidth = pulseWidth;
    }

	/**
	 * @return The height the shape pulses to
	 */
    public double getPulseHeight() {
        return pulseHeight;
    }

	/**
	 * Reset the value of the height to pulse to
	 * @param pulseHeight The new height to pulse to
	 */
	public void setPulseHeight(double pulseHeight) {
        this.pulseHeight = pulseHeight;
    }

	/**
	 * @return Whether the shape pulses or not
	 */
	public boolean isDoesPulse() {
		return doesPulse;
	}

	/**
	 * Reset the value of the doesPulse attribute
	 * @param doesPulse New value to set doesPulse to
	 */
	public void setDoesPulse(boolean doesPulse) {
		this.doesPulse = doesPulse;
	}
}
