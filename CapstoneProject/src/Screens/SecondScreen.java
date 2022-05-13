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
import processing.core.PImage;



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
		counter = new Counter(order, 10, 10);
		d1 = new Disaster ("Fire", 1, 10); 
		d2 = new Disaster ("Flood", 2, 10 ); 
		d3 = new Disaster ("Blackout", 3,10); 
		hole = new Hole (5, 7); 
		ingredients = new Ingredients(2, 9,9); 
		order = new Orders(); 
		player = new Player (surface.loadImage("src/Player.png"), 4, 4); 
		
		
	}

	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() {
		surface.background(0,255,255);   
		grid = new Character[20][20]; 
		

		counter.draw(surface,5,5); 
		hole.draw(surface, 5, 5); 
		ingredients.draw(surface, ingredients.getX(), ingredients.getY()); 
		order.draw(surface,5); 
		d1.drawDisaster(surface); 
		d2.drawDisaster(surface); 
		d3.drawDisaster(surface);
		player.draw(surface); 
		
	}

	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME_SCREEN);
	}
 
	
	
	
}