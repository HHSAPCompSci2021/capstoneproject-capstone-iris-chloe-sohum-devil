package game;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import game.Disaster;
import game.Ingredients;
import processing.core.PImage;

public class Player extends Rectangle2D.Double{
	
	public static final int PLAYER_WIDTH = 40;
	public static final int PLAYER_HEIGHT = 60;
	private PImage image;
	private int x, y;
	private ArrayList<Ingredients> ingredient;
	private ArrayList<Disaster> disaster;
	private boolean holding;
	
	public Player (PImage img, int x, int y) { 
		super(x,y,PLAYER_WIDTH,PLAYER_HEIGHT);
		image = img;
		ingredient = new ArrayList<Ingredients>();
		disaster = new ArrayList<Disaster>();
		holding = false;
	}

	// METHODS
	public void walk(int dir1, int dir2) {
		x = x + (5*dir1);
		y = y + (5*dir2);
	}
	
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
	
	public void dropOff() {
		ingredient = null;
		disaster = null;
		holding = false;
	}

}
