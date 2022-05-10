import java.util.ArrayList;

/**
  * The order class will be used to create an order, randomizing between the possible ingredients
  * 
  * @author cpoon870
  * @version 05/10/2022
  */
public class Orders extends DrawingSurface implements Interactions{

	private ArrayList<Ingredients> ingredientsList;
	private int orderNum;
	
	/**
	 * creates a new order with a random amount of ingredients needed, from 1 to 5 ingredients
	 * random adds ingredients to the order
	 */
	public Orders() {
		orderNum = (int)(Math.random() * 4) + 1;
		for(int i = 0; i < orderNum; i ++) {
			ingredientsList.add(new Ingredients((int)(Math.random() * 5) + 1, 200, 200));
		}
	}
	
	/**
	 * draws the order to the screen on the bar at the top
	 */
	public void draw() {
		
	}
	
	/**
	 * checks whether or not each order has been completed
	 * 
	 * @return true if an order has been completed
	 */
	public boolean completed() {
		Hole hole = new Hole();
		boolean complete = true;
		ArrayList<Ingredients> holeContents = hole.dropped();
		for(int i = 0; i < ingredientsList.size(); i ++) {
			if(!holeContents.contains(ingredientsList.get(i))) {
				complete = false;
			}
		}
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
	public Orders pickUp() {
		return this;
	}

	@Override
	public Orders dropOff() {
		return this;
	}

	@Override
	public boolean loseLife() {
		if(filled()) {
			return true;
		} else {
			return false;
		}
	}
	
}
