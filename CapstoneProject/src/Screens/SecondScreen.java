package Screens;



import java.awt.Desktop.Action;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import Core.DrawingSurface;
import game.Counter;
import game.Disaster;
import game.Hole;
import game.Ingredients;
import game.Interactions;
import game.Orders;
import game.Player;
import processing.core.PApplet;



public class SecondScreen extends Screen {
	
	private DrawingSurface surface;
	private Object[][] grid; 
	private Rectangle button; 
	
	private Counter counter; 
	private Disaster d1; 
	private Disaster d2; 
	private Disaster d3; 
	private Hole hole; 
	private Ingredients ingredients; 
	private Interactions interactions; 
	private Orders order; 
	private Player player; 
	
	
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
		

		counter.draw(surface,10,10); 
		hole.draw(surface, 5, 5); 
		ingredients.draw(surface, ingredients.getX(), ingredients.getY()); 
		order.draw(surface,5); 
		d1.drawDisaster(surface); 
		d2.drawDisaster(surface); 
		d3.drawDisaster(surface);

	}

	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME_SCREEN);
	}
 
	
	
	
}