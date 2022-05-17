package game;
import java.util.*;

import processing.core.PApplet;

/**
 * The hole in the ground that the player drops food through
 * 
 * @author Iris Chou
 * @version 5/17/2022
 */
public class Hole {
	
	private int x;
	private int y;
	
	/**
	 * Constructor for the hole with a pair of xy-coordinates
	 * 
	 * @param xcord
	 * @param ycord
	 */
	public Hole(int xcoord, int ycoord) {
		x = xcoord;
		y = ycoord;
	}
	
	/**
	 * Drop a set of ingredients into the hole
	 * 
	 * @param ingredients the ingredients being dropped into the hole
	 * @return An arrayList of the ingredients dropped into the hole
	 */
	public ArrayList<Ingredients> drop(ArrayList<Ingredients> ingredients, ArrayList<Orders> orders) {
		return ingredients;
	}
	
	/**
	 * Draws the hole to the screen
	 * 
	 * @param drawer PApplet for the hole to be drawn on
	 * @param width the width of the grids
	 * @param height the height of the grids
	 * @post drawer is set to noStroke()
	 * @post drawer fill() is set to black
	 * @post drawer's ellipseMode() is set to CORNER
	 */
	public void draw(PApplet drawer, double width, double height) {
		drawer.noStroke();
		drawer.fill(0);
		drawer.ellipseMode(drawer.CORNER);
		drawer.ellipse((float)width*x, (float)height*y, (float)width, (float)height);
	}
	
	/**
	 * Gets the x-coordinate of the hole
	 * 
	 * @return x-coordinate of hole
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y-coordinate of the hole
	 * 
	 * @return y-coordinate of hole
	 */
	public int getY() {
		return y;
	}
}
