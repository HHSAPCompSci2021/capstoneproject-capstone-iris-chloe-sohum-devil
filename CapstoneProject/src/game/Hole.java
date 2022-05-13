package game;
import java.util.*;

/**
 * The hole in the ground that the player drops food through
 * 
 * @author Iris Chou
 * @version 5/11/2022
 */
public class Hole {
	
	private int x;
	private int y;
	
	public Hole(int xcoord, int ycoord) {
		x = xcoord;
		y = ycoord;
	}
	
	// there could be a method to check what was put into the hole, and it could return an array list of items, it could be dropped()
	public static ArrayList<Ingredients> drop(ArrayList<Ingredients> ingredients) {
		return ingredients;
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
