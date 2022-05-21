package game;

import processing.core.PApplet;

/**
 * The table that the player can place one dish on
 * 
 * @author Iris Chou
 * @version 5/21/2022
 */

public class Counter {

	private Orders holding;
	private static final String IMAGE = "Counter.png";
	private int x;
	private int y;
	
	/**
	 * Constructor for the counter with a pair of xy-coordinates
	 * 
	 * @param xcord the x-coordinate of the counter
	 * @param ycord the y-coordinate of the counter
	 */
	public Counter(int xcord, int ycord) {
		holding = null;
		x = xcord;
		y = ycord;
	}
	
	/**
	 * Constructor initializes itself with a pair of xy-coordinates and an order already placed on it
	 * 
	 * @param order the dish that should be placed on the counter
	 * @param xcord the x-coordinate of the counter
	 * @param ycord the y-coordinate of the counter
	 */
	public Counter(Orders order, int xcord, int ycord) {
		holding = order;
		x = xcord;
		y = ycord;
	}
	
	/**
	 * The passed in dish gets placed on the counter and is stored there.
	 * If there is already a dish on the counter, the new dish will not be placed and old dish will stay there.
	 * 
	 * @param order the dish that is getting placed on the counter
	 * @return returns true if the dish is successfully placed (nothing already on the counter), false otherwise
	 */
	public boolean place(Orders order) {
		if(holding == null) {
			holding = order;
			return true;
		}
		return false;
	}
	
	/**
	 * The dish that was on the counter is taken off the counter.
	 * 
	 * @return the dish that is on the counter (null is returned if nothing was on the table)
	 * @post the counter becomes empty (not storing a dish)
	 */
	public Orders pickUp() {
		Orders temp = holding;
		holding = null;
		return temp;
	}
	
	/**
	 * Gets a String containing the image file name for the Counter
	 * 
	 * @return String with the Counter's image file name
	 */
	public String getImage() {
		return IMAGE;
	}
	
	/**
	 * Draws the counter to the screen
	 * 
	 * @param drawer PApplet for the counter to be drawn on
	 * @param width the width of the grids
	 * @param height the height of the grids
	 */
	public void draw(PApplet drawer, double width, double height) {
		drawer.image(drawer.loadImage("img/Counter.png"), (float)width*x, (float)height*y, (float)width, (float)height);
	}
	
	/**
	 * Gets the x-coordinate of the counter
	 * 
	 * @return x-coordinate of counter
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y-coordinate of the counter
	 * 
	 * @return y-coordinate of counter
	 */
	public int getY() {
		return y;
	}
}
