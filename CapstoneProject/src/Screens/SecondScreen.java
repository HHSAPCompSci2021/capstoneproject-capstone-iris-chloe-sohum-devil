package Screens;



import java.awt.Desktop.Action;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import Core.DrawingSurface;
import game.Ingredients;
import game.Player;



public class SecondScreen extends Screen {
	
	private DrawingSurface surface;
	private Object[][] grid; 
	private Rectangle button;

	
	public SecondScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

	}

	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		
		

	}

	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() {
		surface.background(0,255,255);   
		grid = new Character[20][20]; 
		
		Object a = new Ingredients("Onions", 19, 10); 
		

	}

	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME_SCREEN);
	}
 
	public void getIngredients(Ingredients a1) { 
		grid[a1.getX()][a1.getY()] = a1; 
	}
	
	public void getPlayer (Player a2) { 
		
		
	}
	
	public void getOrders () { 
		
		
	}
	
	
}