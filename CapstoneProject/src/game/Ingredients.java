package game;
import java.awt.Image;

import Core.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Ingredients can be picked up and have their own icons on the grid, extends the interactions class
 * The ingredients are: onion, squirrel, rotten tomato, rabbit, smelly cheese, radioactive slime
 * 
 * @author cpoon870 & Iris Chou
 * @version 5/12/2022
 */
public class Ingredients extends DrawingSurface implements Interactions{

	private PImage picture;
	private int name;
	private int x;
	private int y;
	
	/**
	 * creates a new ingredient based off the integer assigned for the name
	 * 1-onion, 2-squirrel, 3-tomato, 4-rabbit, 5-cheese, 6-slime
	 * 
	 * @param name the integer that assigns the ingredients to a name
	 * @param x the x coordinate of the ingredient
	 * @param y the y coordinate of the ingredient
	 */
	public Ingredients(int name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public void setup() {
		if(name == 1) {
			picture = loadImage("src/onion.jpg");
		} else if (name == 2) {
			picture = loadImage("src/squirrel.jpg");
		} else if (name == 3) {
			picture = loadImage("src/tomato.png");
		} else if (name == 4) {
			picture = loadImage("src/rabbit.png");
		} else if (name == 5) {
			picture = loadImage("src/cheese.jpg");
		} else if (name == 6) {
			picture = loadImage("src/slime.png");
		}
	}
	
	/**
	 * draws the ingredients onto the screen
	 * 
	 * @param drawer a PApplet to draw the ingredients on
	 */
	public void draw(PApplet drawer) {
		
		drawer.image(picture, x, y);
		
	}
	
	/**
	 * Draws the ingredient onto the screen at the given location (in pixels)
	 * 
	 * @param drawer a PApplet to draw the ingredients on
	 * @param xLoc the x-location for the ingredient to be drawn at
	 * @param xLoc the y-location for the ingredient to be drawn at
	 */
	public void draw(PApplet drawer, double xLoc, double yLoc) {
		drawer.image(picture, (int)xLoc, (int)yLoc);
	}

	@Override
	/**
	 * Returns this ingredient, so it can be picker up
	 * 
	 * @return returns this ingredient (itself)
	 */
	public Ingredients pickUp() {
		return this;
		
	}

	@Override
	public Ingredients dropOff() {
		return this;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loseLife() {
		return false;
	}
	
	/**
	 * Gets the x-coordinate of the ingredient
	 * 
	 * @return x-coordinate of ingredient
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y-coordinate of the ingredient
	 * 
	 * @return y-coordinate of ingredient
	 */
	public int getY() {
		return y;
	}
	
}
