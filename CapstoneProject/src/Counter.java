/**
 * The table that the player can place one dish on
 * 
 * @author Iris Chou
 * @version 5/6/2022
 */

public class Counter {

	private Orders holding;
	
	public Counter() {
		holding = null;
	}
	
	public Counter(Orders order) {
		holding = order;
	}
	
	public void place(Orders order) {
		holding = order;
	}
	
	public Orders pickUp() {
		Orders temp = holding;
		holding = null;
		return temp;
	}
}
