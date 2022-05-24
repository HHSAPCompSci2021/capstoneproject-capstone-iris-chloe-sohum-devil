package game;

/**
 *  A superclass for anything that can be interacted with (picked up and dropped/used)
 *  
 * @author cpoon870
 * @version 5/6/2022
 */
public interface Interactions {
	
	/**
	 * picks up each object
	 */
	public Object pickUp();
	
	/**
	 * puts down each object
	 */
	public Object dropOff();
	
	/**
	 * subtracts a life from the player
	 * 
	 * @return true if the player should lose a life
	 */
	public boolean loseLife();
}
