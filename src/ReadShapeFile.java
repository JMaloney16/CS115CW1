
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
			int diameter;
			int width;
			int height;
			String curLine = in.nextLine();
			Scanner line = new Scanner(curLine);
			String shapeType = line.next();

			int px = line.nextInt();
			int py = line.nextInt();
			int vx = line.nextInt();
			int vy = line.nextInt();
			boolean filled = line.nextBoolean();

			if (shapeType.equals("circle")){
				diameter = line.nextInt();
			} else if (shapeType.equals("oval")){
				width = line.nextInt();
				height = line.nextInt();
			}

			int r = line.nextInt();
			int g = line.nextInt();
			int b = line.nextInt();
			int insertionTime = line.nextInt();
			line.close();

			if(shapeType.equals("circle")){
				shapeQueue.enqueue(createCircle(insertionTime, px, py, vx, vy, diameter, r, g, b, filled));
			}else if(shapeType.equals("oval")){
				shapeQueue.enqueue(createOval(insertionTime, px, py, vx, vy, width, height, r, g, b, filled));
			}
		}
		in.close();
		//Right now, returning an empty Queue.  You need to change this.
		return shapeQueue;
	}

	private static Circle createCircle(int insertionTime, int px, int py, int vx, int vy, int diameter,
									   int r, int g, int b, boolean filled){

//		System.out.println(insertionTime + " " + " " + px +  " " + py + " " + vx + " " + vy + " " + diameter
//				+ " " + Color.rgb(r,g,b) + " " + filled);
		return new Circle(insertionTime, px, py, vx, vy, diameter, Color.rgb(r,g,b), filled);
	}
	private static Oval createOval(int insertionTime, int px, int py, int vx, int vy, int width, int height,
								   int r, int g, int b, boolean filled){
//		System.out.println(insertionTime + " " + " " + px +  " " + py + " " + vx + " " + vy + " " + width + " " +
//				height + " " + Color.rgb(r,g,b) + " " + filled);
		return new Oval(insertionTime, px, py, vx, vy, width, height, Color.rgb(r,g,b), filled);
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
