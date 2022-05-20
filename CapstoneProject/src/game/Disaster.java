package game;

import java.time.*;
import processing.core.PApplet;

/**
 * A disaster in the game that the player has to account for and fix in a set amount of time.
 * Each type of disaster has its own unique fix.
 * 
 * @author Iris Chou
 * @version 5/20/2022
 */

public class Disaster {
	private String type;
	private boolean resolved;
	private boolean started;
	private String picture;
	private int x;
	private int y;
	private LocalTime time;
	
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
			picture = "Sandbag.png";
		}
		else if(type.equals("Blackout")) {
			picture = "Lightswitch.png";
		}
		resolved = false;
		x = xcord;
		y = ycord;
		time = LocalTime.now();
		started = false;
	}
	
	/**
	 * Checks if this disaster has been resolved
	 * 
	 * @return returns true if disaster is resolved, false otherwise
	 */
	public boolean isResolved() {
		if((LocalTime.now().toSecondOfDay() - time.toSecondOfDay()) > 10) {
			resolved = false;
		}
		return resolved;
	}
	
	/**
	 * Resolves the disaster
	 * 
	 * @post sets isResolved() to true
	 */
	public void disasterResolved() {
		resolved = true;
		started = false;
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
	public void drawEquipment(PApplet drawer, int x, int y, double width, double height) {
		drawer.image(drawer.loadImage("img/" + picture), x, y, (float)width, (float)height);
	}
	
	/**
	 * Resets the disaster by changing the timer by to 0, resolves the disaster, and starts the disaster
	 */
	public void reset() {
		time = LocalTime.now();
		disasterResolved();
		started = true;
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
			drawer.image(drawer.loadImage("img/Fire.png"), 0, 0, drawer.width, drawer.height);
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
	
	/**
	 * Gets a number corresponding to the disaster type
	 * 1 = Fire, 2 = Flood, 3 = Blackout
	 * 
	 * @return integer representing a disaster type
	 */
	public int getDisaster() {
		if(type.equals("Fire")) {
			return 1;
		}
		else if (type.equals("Flood")) {
			return 2;
		}
		else{
			return 3;
		}
	}
	
	public boolean isStarted() {
		return started;
	}
}
