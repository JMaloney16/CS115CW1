
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

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
				default:
					System.out.println("Not a correct shape format!");
			}

		}
		in.close();
		//Right now, returning an empty Queue.  You need to change this.
		return shapeQueue;
	}

	private static Circle createCircle(Scanner line){
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
		line.close();
		System.out.println(insertionTime + " " + " " + px +  " " + py + " " + vx + " " + vy + " " + diameter
				+ " " + Color.rgb(r,g,b) + " " + filled);
		return new Circle(insertionTime, px, py, vx, vy, diameter, Color.rgb(r,g,b), filled);
	}
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
		line.close();
		//		System.out.println(insertionTime + " " + " " + px +  " " + py + " " + vx + " " + vy + " " + width + " " +
//				height + " " + Color.rgb(r,g,b) + " " + filled);
		return new Oval(insertionTime, px, py, vx, vy, width, height, Color.rgb(r,g,b), filled);
	}

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
		line.close();
		return new Square(insertionTime, px, py, vx, vy, side, Color.rgb(r,g,b), filled);
	}

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
		line.close();
		return new Rect(insertionTime, px, py, vx, vy, width, height, Color.rgb(r,g,b), filled);
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
