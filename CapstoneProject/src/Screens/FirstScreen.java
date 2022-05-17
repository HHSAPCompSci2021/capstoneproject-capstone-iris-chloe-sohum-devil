package Screens;

import java.awt.Point;
import java.awt.Rectangle;

import Core.DrawingSurface;

/**
 * the opening screen for the player that shows the controls for the game and a button to start
 * 
 * @author cpoon870
 * @version 5/13/2022
 */
public class FirstScreen extends Screen {

	private DrawingSurface surface;
	
	private Rectangle button;

	/**
	 * makes a new screen on the drawing surface with a button
	 * @param surface the drawing surface to draw the player on
	 */
	public FirstScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

		button = new Rectangle(300,500,225,100);
	}


	/**
	 * draws the button to click and the text for the instructions of the game
	 */
	public void draw() {

		surface.background(255,255,255);
		surface.textAlign(surface.CENTER, surface.CENTER);
		
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Click me to start!";
		float w = surface.textWidth(str);
		surface.textSize(25);
		surface.text(str, button.x, button.y, button.width, button.height);
		
		surface.textAlign(surface.BASELINE);
		surface.text("Here are the controls for the game:", 25, 25);
		surface.text("- To move around, use the up, down, left, and right arros keys", 25, 75);
		surface.text("- To pick up or drop off ingredients, press the spacebar (you\nmay only have one ingredient at a time)", 25, 125);
		surface.text("- To put out the fire, pick up the fire extinguisher, hold down\nthe left mouse key, and wave it in front of the fire for 2 seconds", 25, 225);
		surface.text("- To stop the flood, pick up and hold the sandbags by holding\ndown the enter/return key, and releasing it at the door", 25, 325);
		surface.text("- To turn the power back on, walk over to the light switch (the\nscreen is black), and press return key to turn the lights back on", 25, 425);
		
	}



	/**
	 * checks if the mouse was pressed and if it is inside the button
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME_SCREEN);
	}
	

}

