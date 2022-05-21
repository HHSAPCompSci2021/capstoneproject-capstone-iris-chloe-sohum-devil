package game;
import java.util.*;

import processing.core.PApplet;

/**
 * The hole in the ground that the player drops food through
 * 
 * @author Iris Chou
 * @version 5/21/2022
 */
public class Hole {
	
	private int x;
	private int y;
	
	/**
	 * Constructor for the hole with a pair of xy-coordinates
	 * 
	 * @param xcord the x-coordinates of the hole
	 * @param ycord the y-coordinates of the hole
	 */
	public Hole(int xcoord, int ycoord) {
		x = xcoord;
		y = ycoord;
	}
	
	/**
	 * Drop a set of ingredients into the hole
	 * 
	 * @return returns true if the passed in order exist in the list of orders
	 */
	public boolean drop(ArrayList<Ingredients> temp, ArrayList<Orders> orders) {
		for(Ingredients i : temp) {
			System.out.println(i.getName());
		}
		
		for(int i = 0; i < orders.size(); i++) {
			ArrayList<Ingredients> orderIngredients = orders.get(i).getIngredients();
			boolean equal = true;
			if(orderIngredients.size() != temp.size()) {
				//System.out.println("Sizes are different");
				equal = false;
			} else if (!temp.containsAll(orderIngredients)) {
				equal = false;
				//System.out.println("Does not contain everything");
			}
			
			if(equal) {
				//System.out.println("Dish is correct");
				orders.remove(i);
				return true;
			}
		}
		return false;
		
//		ArrayList<Ingredients> ingredients = copyIngredientList(temp);
//		
//		for(int i = 0; i < orders.size(); i++) {
//			ArrayList<Ingredients> orderIngredients = orders.get(i).getIngredients();
//			boolean equal = true;
//			if (orderIngredients.size() != ingredients.size()) {
//				equal = false;
//			}
//			else {
//				for(int j = 0; j < orderIngredients.size(); j++) {
//					if(ingredients.indexOf(orderIngredients.get(j)) == -1)
//						equal = false;
//					else
//						ingredients.remove(ingredients.indexOf(orderIngredients.get(j)));
//				}
//			}
//			
//			if(equal) {
//				orders.remove(i);
//				return true;
//			}
//			ingredients = copyIngredientList(temp);
//		}
//		return false;
	}
	
	/**
	 * moves the current listof ingredients into a new temporary ingredients list
	 * 
	 * @param temp an arraylist of ingredients to be put into a new temporary arraylist
	 * @return an arraylist of ingredients that matches the arraylist put in as a parameter
	 */
	private ArrayList<Ingredients> copyIngredientList(ArrayList<Ingredients> temp) {
		ArrayList<Ingredients> ingredients = new ArrayList<Ingredients>();
		for(Ingredients i : temp) {
			ingredients.add(i);
		}
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
