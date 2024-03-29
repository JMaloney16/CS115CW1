
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author Jack Maloney
 *
 */

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		//read in the shape files and place them on the Queue
		while(in.hasNextLine()){

			Scanner line = new Scanner(in.nextLine());
			String shapeType = line.next();

			switch (shapeType){
				case "circle":
					shapeQueue.enqueue(createCircle(line));
					break;
				case "oval":
					shapeQueue.enqueue(createOval(line));
					break;
				case "square":
					shapeQueue.enqueue(createSquare(line));
					break;
				case "rect":
					shapeQueue.enqueue(createRect(line));
					break;
				case "arc":
					shapeQueue.enqueue(createArc(line));
					break;
				case "image":
					shapeQueue.enqueue(createImage(line));
					break;
				default:
					System.out.println("Not a correct shape format!: " + shapeType);
			}

		}
		in.close();
		return shapeQueue;
	}

	/*The shape methods read the lines of the file saving each attribute to the corresponding variable and then return
	a new object of the shape */
    /**
     * Method to convert a string format circle to a Circle object
     * @param line Scanner with string input stream
     * @return Circle object
     */
	private static Circle createCircle(Scanner line) {
		int px = line.nextInt();
		int py = line.nextInt();
		int vx = line.nextInt();
		int vy = line.nextInt();
		boolean filled = line.nextBoolean();
		int diameter = line.nextInt();
		int r = line.nextInt();
		int g = line.nextInt();
		int b = line.nextInt();
		int insertionTime = line.nextInt();
		if (line.hasNext()) { //If the shape pulses
			boolean doesPulse = line.nextBoolean();
			double pulseSize = 2; // If a specific multiplier isn't specified the pulse size is 2
			if (line.hasNext()){
				pulseSize = line.nextDouble();
			}
			line.close();
			return new Circle(insertionTime, px, py, vx, vy, diameter, Color.rgb(r, g, b), filled, pulseSize, doesPulse);
		} else {
			line.close();
			return new Circle(insertionTime, px, py, vx, vy, diameter, Color.rgb(r, g, b), filled);
		}
	}

    /**
     * Method to convert a string format oval to a Oval object
     * @param line Scanner with string input stream
     * @return Oval object
     */
	private static Oval createOval(Scanner line){
		int px = line.nextInt();
		int py = line.nextInt();
		int vx = line.nextInt();
		int vy = line.nextInt();
		boolean filled = line.nextBoolean();
		int width = line.nextInt();
		int height = line.nextInt();
		int r = line.nextInt();
		int g = line.nextInt();
		int b = line.nextInt();
		int insertionTime = line.nextInt();
		if (line.hasNext()){
			boolean doesPulse = line.nextBoolean();
			double pulseSize = 2;
			if (line.hasNext()) {
				pulseSize = line.nextDouble();
			}
			line.close();
			return new Oval(insertionTime, px, py, vx, vy, width, height, Color.rgb(r,g,b), filled, pulseSize, doesPulse);
		}else {
			line.close();
			return new Oval(insertionTime, px, py, vx, vy, width, height, Color.rgb(r, g, b), filled);
		}
	}

    /**
     * Method to convert a string format square to a Square object
     * @param line Scanner with string input stream
     * @return Square object
     */
	private static Square createSquare(Scanner line){
		int px = line.nextInt();
		int py = line.nextInt();
		int vx = line.nextInt();
		int vy = line.nextInt();
		boolean filled = line.nextBoolean();
		int side = line.nextInt();
		int r = line.nextInt();
		int g = line.nextInt();
		int b = line.nextInt();
		int insertionTime = line.nextInt();
		if (line.hasNext()){
			boolean doesPulse = line.nextBoolean();
			double pulseSize = 2;
			if (line.hasNext()){
				pulseSize = line.nextDouble();
			}
			line.close();
			return new Square(insertionTime, px, py, vx, vy, side, Color.rgb(r,g,b), filled, pulseSize, doesPulse);
		}else {
			line.close();
			return new Square(insertionTime, px, py, vx, vy, side, Color.rgb(r, g, b), filled);
		}
	}

	/**
	 * Method to convert a string format rectangle to a Rect object
	 * @param line Scanner with string input stream
	 * @return Rect object
	 */
	private static Rect createRect(Scanner line){
		int px = line.nextInt();
		int py = line.nextInt();
		int vx = line.nextInt();
		int vy = line.nextInt();
		boolean filled = line.nextBoolean();
		int width = line.nextInt();
		int height = line.nextInt();
		int r = line.nextInt();
		int g = line.nextInt();
		int b = line.nextInt();
		int insertionTime = line.nextInt();
		if (line.hasNext()){
			boolean doesPulse = line.nextBoolean();
			double pulseSize = 2;
			if (line.hasNext()){
				pulseSize = line.nextDouble();
			}
			line.close();
			return new Rect(insertionTime, px, py, vx, vy, width, height, Color.rgb(r,g,b), filled, pulseSize, doesPulse);
		}else {
			line.close();
			return new Rect(insertionTime, px, py, vx, vy, width, height, Color.rgb(r, g, b), filled);
		}
	}

	/**
	 * Method to convert a string format arc to an Arc object
	 * @param line Scanner with string input stream
	 * @return Arc object
	 */
	private static Arc createArc(Scanner line){
		int px = line.nextInt();
		int py = line.nextInt();
		int vx = line.nextInt();
		int vy = line.nextInt();
		boolean filled = line.nextBoolean();
		int width = line.nextInt();
		int height = line.nextInt();
		int startAngle = line.nextInt();
		int arcExtent = line.nextInt();
		String closure = line.next().toUpperCase();
		int r = line.nextInt();
		int g = line.nextInt();
		int b = line.nextInt();
		int insertionTime = line.nextInt();
		if (line.hasNext()){
			boolean doesPulse = line.nextBoolean();
			double pulseSize = 2;
			if (line.hasNext()) {
				pulseSize = line.nextDouble();
			}
			line.close();
			return new Arc(insertionTime, px, py, vx, vy, width, height, startAngle, arcExtent, closure,
					Color.rgb(r, g, b), filled, pulseSize, doesPulse);
		} else {
			line.close();
			return new Arc(insertionTime, px, py, vx, vy, width, height, startAngle, arcExtent, closure,
					Color.rgb(r, g, b), filled);
		}
	}

	/**
	 * Method to convert a string format image to an Img object
	 * @param line Scanner with string input stream
	 * @return Img object
	 */
	private static Img createImage(Scanner line){
		int px = line.nextInt();
		int py = line.nextInt();
		int vx = line.nextInt();
		int vy = line.nextInt();
		int width = line.nextInt();
		int height = line.nextInt();
		Image insertImage = new Image(line.next());
		int insertionTime = line.nextInt();
		if (line.hasNext()) {
			boolean doesPulse = line.nextBoolean();
			double pulseSize = 2;
			if (line.hasNext()) {
				pulseSize = line.nextDouble();
			}
			line.close();
			return new Img(insertionTime, px, py, vx, vy, width, height, insertImage, pulseSize, doesPulse);
		}else {
			line.close();
			return new Img(insertionTime, px, py, vx, vy, width, height, insertImage);
		}
	}


	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
	    // HINT: You might want to open a file here.
		File file = new File(filename);
		Scanner in = null;
		try{
			in = new Scanner(file);
		}
		catch (FileNotFoundException e){
			System.out.println("File does not exist.");
			System.exit(0);
		}

	    return ReadShapeFile.readDataFile(in);
	}
}
