
/**
 * A disaster in the game that the player has to account for and fix in a set amount of time.
 * Each type of disaster has its own unique fix.
 * 
 * @author Iris Chou
 * @version 5/6/2022
 */

public class Disaster {
	private String type;
	private boolean resolved;
	
	/**
	 * Constructor that takes in a String to identify the disaster's type
	 * 
	 * @param s String of the disaster type, where capitalization matters ("Fire", "Flood", "Blackout")
	 * @throws IllegalArgumentException
	 */
	public Disaster(String s) throws IllegalArgumentException{
		if (!s.equals("Fire") && !s.equals("Flood") && !s.equals("Blackout"))
			throw new IllegalArgumentException();
		type = s;
		resolved = false;
	}
}
