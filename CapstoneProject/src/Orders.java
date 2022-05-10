import java.util.ArrayList;

/**
  * The order class will be used to create an order, randomizing between the possible ingredients
  * 
  * @author cpoon870
  * @version 05/10/2022
  */
public class Orders {

	private ArrayList<Ingredients> ingredientsList;
	private int orderNum;
	
	public Orders() {
		orderNum = (int)(Math.random() * 5);
		for(int i = 0; i < orderNum; i ++) {
			ingredientsList.add(new Ingredients((int)(Math.random() * 5) + 1, 200, 200));
		}
	}
	
	public void draw() {
		
	}
	
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
	
}
