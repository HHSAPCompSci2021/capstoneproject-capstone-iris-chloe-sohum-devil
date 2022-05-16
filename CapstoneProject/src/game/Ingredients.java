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
 * @version 5/15/2022
 */
public class Ingredients implements Interactions{

	private PImage picture;
	private int name;
	private int x;
	private int y;
	private DrawingSurface surface;
	
	/**
	 * creates a new ingredient based off the integer assigned for the name
	 * 1-onion, 2-squirrel, 3-tomato, 4-rabbit, 5-cheese, 6-slime
	 * 
	 * @param name the integer that assigns the ingredients to a name
	 * @param x the x coordinate of the ingredient
	 * @param y the y coordinate of the ingredient
	 */
	public Ingredients(PApplet drawer, int name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		if(name == 1) {
			picture = drawer.loadImage("img/onion.jpg");
		} else if (name == 2) {
			picture = drawer.loadImage("img/squirrel.jpg");
		} else if (name == 3) {
			picture = drawer.loadImage("img/tomato.png");
		} else if (name == 4) {
			picture = drawer.loadImage("img/rabbit.png");
		} else if (name == 5) {
			picture = drawer.loadImage("img/cheese.jpg");
		} else if (name == 6) {
			picture = drawer.loadImage("img/slime.png");
		}
	}
	
	/**
	 * draws the ingredients onto the screen
	 * 
	 * @param drawer a PApplet to draw the ingredients on
	 */
	public void draw(PApplet drawer) {
		
//		if (image != null)
//			g.image(image,(float)x,(float)y,(float)width,(float)height);
//		else {
//			g.fill(100);
//			g.rect((float)x,(float)y,(float)width,(float)height);
//		}

//		drawer.image(picture, x, y);
//		drawer.rect(x,  y,  50,  50);
//		String food = new String();
//		if(name == 1) {
//			food = "onion";
//		} else if (name == 2) {
//			food = "squirrel";
//		} else if (name == 3) {
//			food = "tomato";
//		} else if (name == 4) {
//			food = "rabbit";
//		} else if (name == 5) {
//			food = "cheese";
//		} else if (name == 6) {
//			food = "slime";
//		}
//		drawer.text(food, x, y);
//		drawer.stroke(0);
		
		drawer.image(picture, x, y);
	}
	
	/**
	 * Draws the ingredient onto the screen at the given location (in pixels)
	 * 
	 * @param drawer a PApplet to draw the ingredients on
	 * @param width the width of the ingredient (in pixels)
	 * @param height the height of the ingredient (in pixels)
	 */
	public void draw(PApplet drawer, double width, double height) {
		drawer.image(picture, x, y, (float)width, (float)height);
	}
	
	public void draw(PApplet drawer, int xLoc, int yLoc, double width, double height) {
		drawer.image(picture, xLoc, yLoc, (float)width, (float)height);
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
	
	/**
	 * gets the type of ingredients
	 * @return a string with the name of the ingredient
	 */
	public String getName() {
		String food = "";
		if(name == 1) {
			food = "onion";
		} else if (name == 2) {
			food = "squirrel";
		} else if (name == 3) {
			food = "tomato";
		} else if (name == 4) {
			food = "rabbit";
		} else if (name == 5) {
			food = "cheese";
		} else if (name == 6) {
			food = "slime";
		}
		return food;
	}
	
}
