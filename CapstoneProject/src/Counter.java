/*
 * The table that the player can place one dish on
 * 
 * @author Iris Chou
 * @version 5/6/2022
 */

public class Counter implements Interactions{

	private Orders holding;
	
	public Counter () {
		holding = null;
	}
	
	public void place(Orders order) {
		holding = order;
	}
	
	public Orders pickUp() {
		holding = null;
	}
}
