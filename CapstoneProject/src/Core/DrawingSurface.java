package Core;
import java.awt.Point;
import java.util.ArrayList;

import Screens.FirstScreen;
import Screens.Screen;
import Screens.ScreenSwitcher;
import Screens.SecondScreen;
import Screens.ThirdScreen;
import processing.core.PApplet;

/**
 * the drawing surface for the game, and uses the ScreenSwitcher
 * 
 * @author cpoon870
 * @version 5/13/2022
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher{
	
public float ratioX, ratioY;
	
	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;

	/**
	 * creates a new drawing surface for the game
	 */
	public DrawingSurface() {
		
		screens = new ArrayList<Screen>();
		
		keys = new ArrayList<Integer>();
		
		
		FirstScreen screen1 = new FirstScreen(this);
		screens.add(screen1);
		
		SecondScreen screen2 = new SecondScreen(this);
		screens.add(screen2);
		
		ThirdScreen screen3 = new ThirdScreen(this);
		screens.add(screen3);
		
		activeScreen = screens.get(0);
	}
	
	/**
	 * the setup for the drawing surface
	 * loads the screens
	 */
	public void setup() {
		for (Screen s : screens)
			s.setup();
	}
	
	/**
	 * draws the contents of the screens onto the window
	 */
	public void draw() {
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

		push();
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		pop();
	}
	
	/**
	 * checks what key was pressed and prevents the program from closing on escape key
	 */
	public void keyPressed() {
		keys.add(keyCode);
		if (key == ESC)  // This prevents a processing program from closing on escape key
			key = 0;
		activeScreen.keyPressed();
	}

	/**
	 * checks if the key was released
	 */
	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	/**
	 * returns whether or not a key is pressed
	 * @param code an integer for what was pressed
	 * @return a boolean for whether or not a key was pressed
	 */
	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	/**
	 * checks whether or not a mouse was pressed
	 */
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	/**
	 * checks whether or not the mouse was moved
	 */
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	/**
	 * checks whether or not the mouse was dragged
	 */
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	/**
	 * checks whether or not the mouse was released
	 */
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	/**
	 * take the assumed coordinates the person wants to an actual point on the grid
	 * @param assumed the assumed point the user clicks on
	 * @return the point on the grid the user is clicking on
	 */
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}

	/**
	 * take the actual coordinates of something and convert it to the pixels
	 * @param actual the point the user clicks on the grid
	 * @return a Point for the actual place the user clicked
	 */
	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}

	/**
	 * calls the method to switch between screens
	 */
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}
}
