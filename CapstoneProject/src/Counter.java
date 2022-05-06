/*
 * The table that the player can place one dish on
 * 
 * @author Iris Chou
 * @version 5/6/2022
 */

public class Counter extends Interactions{

	private Orders holding;
	
	public Counter () {
		super();
		holding = null;
	}
	
	public void place(Orders order) {
		holding = order;
	}
}
