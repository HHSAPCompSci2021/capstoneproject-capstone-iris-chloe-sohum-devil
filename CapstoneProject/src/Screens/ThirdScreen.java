package Screens;

import java.awt.Point;
import java.awt.Rectangle;

import Core.DrawingSurface;

/**
 * The ending screen for the player that can take the player back to the menu screen
 * 
 * @author irisc
 * @version 5/17/2022
 */
public class ThirdScreen extends Screen{
	private DrawingSurface surface;
	private Rectangle button;

	/**
	 * Makes a new screen on the drawing surface with a button
	 * 
	 * @param surface the drawing surface to draw the player on
	 */
	public ThirdScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

		button = new Rectangle(300,500,225,100);
	}


	/**
	 * Draws the screen including the button and appropriate text
	 */
	public void draw() {

		surface.background(255,255,255);
		
		
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Play again";
		float w = surface.textWidth(str);
		surface.textSize(25);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
		
		surface.text("Game over", 25, 25);
		
	}



	/**
	 * checks if the mouse was pressed and if it is inside the button
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.MENU_SCREEN);
	}
}
