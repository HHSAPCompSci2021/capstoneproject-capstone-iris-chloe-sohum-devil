package game;

import java.awt.geom.Rectangle2D;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import game.Disaster;
import game.Ingredients;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * runs the player for the game, allows the player to move around the screen, pick up, and drop off objects
 * 
 * @author cpoon870 & sphadke983 
 * @version 5/13/2022
 */
public class Player extends Rectangle2D.Double{
	
	public static final int PLAYER_WIDTH = 40;
	public static final int PLAYER_HEIGHT = 60;
	private PImage image;
	private ArrayList<Ingredients> ingredient;
	private ArrayList<Disaster> disaster;
	private boolean holding;
	private int lives = 3;
	private int currency = 0;
	
	/**
	 * creates a new player
	 * @param img the image for the player
	 * @param x the x coordinate of the player
	 * @param y the y coordinate of the player
	 */
	public Player (PImage img, int x, int y) { 
		super(x,y,PLAYER_WIDTH,PLAYER_HEIGHT);
		image = img;
		ingredient = new ArrayList<Ingredients>();
		disaster = new ArrayList<Disaster>();
		holding = false;
	}

	/**
	 * moves the player five steps at a time
	 * @param dir1 the x direction
	 * @param dir2 the y direction
	 */
	public void walk(int dir1, int dir2) {
		super.x += (5*dir1);
		super.y += (5*dir2); 
	}
	
	/**
	 * allows the player to pick up objects
	 * @param stuff the list of stuff the player should pick up
	 */
	public void pickUp(ArrayList<Object> stuff) {
		
		for (Object e: stuff) {
			if(e instanceof Ingredients) {
				ingredient.add((Ingredients)e);
			} else if (e instanceof Disaster) {
				disaster.add((Disaster)e);
			}
		}
		holding = true;
	}
	
	/**
	 * allows the player to drop off items
	 */
	public ArrayList<Object> dropOff(ArrayList<Object> stuff) {
		ingredient = null;
		disaster = null;
		holding = false;
		return stuff;
	}
	
	/**
	 * draws the player onto the screen
	 * @param g the PApplet to draw the player onto
	 */
	public void draw(PApplet g) {
		if (image != null)
			g.image(image,(float)super.x,(float)super.y,(float)width,(float)height);
		else {
			g.fill(100);
			g.rect((float)x,(float)y,(float)width,(float)height);
		}
	}
	
	public void loseLife() {
		lives = lives - 1;
	}
	
	public void gainLife() {
		lives = lives + 1;
	}
	
	
	public double getX() { 
		return x; 
	}
	
	public double getY() { 
		return y; 
	}
	
	public void addCurrency(int value) {
		currency++;
	}
	
	public int getCurrency() {
		return currency;
	}
	
	public boolean tenSeconds(LocalTime start) {
		if((LocalTime.now().toSecondOfDay() - start.toSecondOfDay()) > 10) {
			return true;
		} else	
			return false;
	}
}
