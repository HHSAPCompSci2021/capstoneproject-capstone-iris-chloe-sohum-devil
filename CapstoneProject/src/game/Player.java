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
 * @version 5/20/2022
 */
public class Player extends Rectangle2D.Double{
	
	public static final int PLAYER_WIDTH = 40;
	public static final int PLAYER_HEIGHT = 60;
	private PImage image;
	private ArrayList<Ingredients> ingredient;
	private Disaster disaster;
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
		disaster = null;
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
	public void pickUp(Ingredients i) {
		ingredient.add(i);
//		System.out.println(i.getName());
		
//		for (Object e: stuff) {
//			if(e instanceof Ingredients) {
//				ingredient.add((Ingredients)e);
//			} else if (e instanceof Disaster) {
//				disaster.add((Disaster)e);
//			}
//		}
//		holding = true;
	}
	
	/**
	 * allows the player to drop off items
	 */
	public ArrayList<Ingredients> dropOffOrder() {
		ArrayList<Ingredients> temp = ingredient;
		ingredient = new ArrayList<Ingredients>();
		return temp;
	}
	
	/**
	 * method to drop off the equipment for the disasters
	 * 
	 * @return the disaster that the equipment is being dropped off for
	 */
	public Disaster dropOffEquipment() {
		Disaster temp = disaster;
		disaster = null;
		return temp;
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
	
	/**
	 * get the ingredients inside the order
	 * 
	 * @return and arraylist of the ingredients in the order
	 */
	public ArrayList<Ingredients> getOrder() {
		return ingredient;
	}
	
	/**
	 * get the equipment needed for the disaster
	 * 
	 * @return the disaster that is being run
	 */
	public Disaster getEquipment() {
		return disaster;
	}
	
	/**
	 * subtract a life from the player
	 */
	public void loseLife() {
		lives = lives - 1;
	}
	
	/**
	 * add a life to the player
	 */
	public void gainLife() {
		lives = lives + 1;
	}
	
	/**
	 * get the lives the player has
	 * 
	 * @return an integer for the number of lives that the person has
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * get the x coordinate of the player
	 * 
	 * @return a double with the x coordinate of the player
	 */
	public double getX() { 
		return x; 
	}
	
	/**
	 * get the y coordinate of the player
	 * 
	 * @return a double with the y coordinate of the player
	 */
	public double getY() { 
		return y; 
	}
	
	/**
	 * add 10 points to the players currency
	 */
	public void addCurrency() {
		
		currency = currency + 10;
	}
	
	/**
	 * get the currency of the player
	 * 
	 * @return an integer with the number of points the player has
	 */
	public int getCurrency() {
		return currency;
	}
	
	/**
	 * check is ten seconds have passed
	 * 
	 * @param start the current time
	 * @return true is more than ten seconds have passed
	 */
	public boolean tenSeconds(LocalTime start) {
		if((LocalTime.now().toSecondOfDay() - start.toSecondOfDay()) > 10) {
			return true;
		} else	
			return false;
	}
}
