package Screens;

/**
 * screens the player can use
 * 
 * @author cpoon870
 * @version 5/20/2022
 */
public abstract class Screen {

	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
	
	/**
	 * creates a new screen with a width and height
	 * @param width the width of the screen
	 * @param height the height of the screen
	 */
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}
	
	/**
	 * setup the screen
	 */
	public void setup() {
		
	}
	
	/**
	 * draw the screen
	 */
	public void draw() {
		
	}
	
	/**
	 * check if the mouse is pressed
	 */
	public void mousePressed() {
		
	}
	
	/**
	 * checks if the mouse is moved
	 */
	public void mouseMoved() {
		
	}
	
	/**
	 * checks if the mouse is dragged
	 */
	public void mouseDragged() {
		
	}
	
	/**
	 * checks if the mouse is released
	 */
	public void mouseReleased() {
		
	}
	
	/**
	 * checks if the key is pressed
	 */
	public void keyPressed() {
		
	}
	
	
	
}
