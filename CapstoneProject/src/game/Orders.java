package game;
import java.util.ArrayList;
import processing.core.PApplet;

import Core.DrawingSurface;

/**
  * The order class will be used to create an order, randomizing between the possible ingredients
  * 
  * @author cpoon870 & Iris Chou
  * @version 05/13/2022
  */
public class Orders implements Interactions{

	private ArrayList<Ingredients> ingredientsList;
	private int orderNum;
	
	/**
	 * creates a new order with a random amount of ingredients needed, from 1 to 4 ingredients
	 * random adds ingredients to the order
	 */
	public Orders(PApplet drawer) {
		ingredientsList = new ArrayList<Ingredients>();
		orderNum = (int)(Math.random() * 4) + 1;
		for(int i = 0; i < orderNum; i ++) {
			ingredientsList.add(new Ingredients(drawer, (int)(Math.random() * 6) + 1, 200, 200));
		}
	}
	
	/**
	 * draws the order to the screen on the bar at the top
	 * 
	 * @param drawer PApplet for the order to be drawn on
	 * @param count the position that the order occupies on the order shelf (0 to 4)
	 * @post drawer is set to noStroke()
	 * @post the drawer fill() is set to white
	 */
	public void draw(PApplet drawer, int count) {
		double width = drawer.width * 3.0 / 20;
		double height = drawer.height / 5.0;
		double x = width * count + 5;
		drawer.fill(255);
		drawer.noStroke();
		drawer.rect((float)x, 0, (float)(width - 10), (float)height);
		for(int i = 0; i < ingredientsList.size(); i++) {
			ingredientsList.get(i).draw(drawer, x + 5 + (width - 10) / 2 * (i % 2), 5 + height / 2 * (i / 2));
		}
		String order = "";
		for(Ingredients e: ingredientsList) {
			order = order + e.getName();
		}
		drawer.text(order,  (float)(width-10),  (float)height);
	}
	
	/**
	 * checks whether or not each order has been completed
	 * 
	 * @return true if an order has been completed
	 */
	public boolean completed() {
		//Hole hole = new Hole();
		boolean complete = true;
//		ArrayList<Ingredients> holeContents = Hole.drop();
//		for(int i = 0; i < ingredientsList.size(); i ++) {
//			if(!holeContents.contains(ingredientsList.get(i))) {
//				complete = false;
//			}
//		}
		
		return complete;
	}
	
	/**
	 * checks whether there is more than 5 orders waiting to be filled
	 * 
	 * @return true if the order spots are filled up
	 */
	public boolean filled() {
		return false;
		
	}

	@Override
	/**
	 * Returns this order, so it can be picked up
	 * 
	 * @return returns this order (itself)
	 */
	public Orders pickUp() {
		return this;
	}

	@Override
	/**
	 * Returns this order, so it can be dropped off
	 * 
	 * @return returns this order (itself)
	 */
	public Orders dropOff() {
		return this;
	}

	/**
	 * takes a life away from the player if the orders are all filled
	 */
	public boolean loseLife() {
		if(filled()) {
			return true;
		} else {
			return false;
		}
	}
	
}
