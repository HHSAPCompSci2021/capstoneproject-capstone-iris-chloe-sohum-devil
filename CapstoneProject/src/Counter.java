/**
 * The table that the player can place one dish on
 * 
 * @author Iris Chou
 * @version 5/6/2022
 */

public class Counter {

	private Orders holding;
	
	/**
	 * No argument constructor for the counter
	 */
	public Counter() {
		holding = null;
	}
	
	/**
	 * Constructor initializes itself with an order placed on it
	 * 
	 * @param order the dish that should be placed on the counter
	 */
	public Counter(Orders order) {
		holding = order;
	}
	
	/**
	 * The passed in dish gets placed on the counter and is stored there.
	 * If there is already a dish on the counter, the new dish will not be placed and old dish will stay there.
	 * 
	 * @param order the dish that is getting placed on the counter
	 * @return returns true if the dish is successfully placed (nothing already on the counter), false otherwise
	 */
	public boolean place(Orders order) {
		if(holding == null) {
			holding = order;
			return true;
		}
		return false;
	}
	
	/**
	 * The dish that was on the counter is taken off the counter.
	 * 
	 * @return the dish that is on the counter (null is returned if nothing was on the table)
	 * @post the counter becomes empty (not storing a dish)
	 */
	public Orders pickUp() {
		Orders temp = holding;
		holding = null;
		return temp;
	}
}
