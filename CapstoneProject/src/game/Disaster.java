package game;

import processing.core.PApplet;

/**
 * A disaster in the game that the player has to account for and fix in a set amount of time.
 * Each type of disaster has its own unique fix.
 * 
 * @author Iris Chou
 * @version 5/6/2022
 */

public class Disaster {
	private String type;
	private boolean resolved;
	private String picture;
	private int x;
	private int y;
	
	/**
	 * Constructor that takes in a String to identify the disaster's type
	 * 
	 * @param s String of the disaster type, where capitalization matters ("Fire", "Flood", "Blackout")
	 * @throws IllegalArgumentException
	 */
	public Disaster(String s, int xcord, int ycord) throws IllegalArgumentException{
		if (!s.equals("Fire") && !s.equals("Flood") && !s.equals("Blackout"))
			throw new IllegalArgumentException();
		type = s;
		if(type.equals("Fire")) {
			picture = "Fire Extinguisher.png";
		}
		else if (type.equals("Flood")) {
			picture = "Sandbags.png";
		}
		else if(type.equals("Blackout")) {
			picture = "Lightswitch.png";
		}
		resolved = false;
		x = xcord;
		y = ycord;
	}
	
	/**
	 * Checks if this disaster has been resolved
	 * 
	 * @return returns true if disaster is resolved, false otherwise
	 */
	public boolean isResolved() {
		return resolved;
	}
	
	/**
	 * Resolves the disaster
	 * 
	 * @post sets isResolved() to true
	 */
	public void disasterResolved() {
		resolved = true;
	}
	
	/**
	 * Gets a String containing the image file name for the disaster resolving equipment (sandbags, fire extinguisher, lightswitch)
	 * 
	 * @return String with the disaster equipment image file name
	 */
	public String getImage() {
		return picture;
	}
	
	/**
	 * Draws the disaster resolving equipment to the screen
	 * 
	 * @param drawer PApplet for the disaster resolving equipment to be drawn on
	 * @param width the width of the grids
	 * @param height the height of the grids
	 */
	public void drawEquipment(PApplet drawer, double width, double height) {
		drawer.image(drawer.loadImage("src/" + picture), (float)width*x, (float)height*y, (float)width, (float)height);
	}
	
	/**
	 * Draws the disaster to the screen
	 * 
	 * @param drawer PApplet for the disaster to be drawn on
	 * @post drawer is set to noStroke() if the disaster is a Flood or Blackout
	 * @post drawer fill() is set to blue (70, 95, 240) if the disaster is a Flood
	 * @post drawer fill() is set to black if the disaster is a Blackout
	 */
	public void drawDisaster(PApplet drawer) {
		switch(type) {
		case "Fire":
			drawer.image(drawer.loadImage("src/Fire.png"), 0, 0, drawer.width, drawer.height);
			break;
		case "Flood":
			drawer.fill(70, 95, 240);
			drawer.noStroke();
			drawer.rect(0, 0, drawer.width, drawer.height);
			break;
		case "Blackout":
			drawer.noStroke();
			drawer.fill(0);
			drawer.rect(0, 0, drawer.width, drawer.height);
			break;
		}
	}
	
	/**
	 * Gets the x-coordinate of the disaster resolving equipment
	 * 
	 * @return x-coordinate of disaster resolving equipment
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y-coordinate of the disaster resolving equipment
	 * 
	 * @return y-coordinate of disaster resolving equipment
	 */
	public int getY() {
		return y;
	}
}
