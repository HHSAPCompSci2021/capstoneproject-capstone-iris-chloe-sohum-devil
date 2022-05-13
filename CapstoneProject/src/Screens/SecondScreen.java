package Screens;



import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import Core.DrawingSurface;



public class SecondScreen extends Screen {
	
	private DrawingSurface surface;
	private boolean[][] grid; 
	
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
		
		grid = new boolean[20][20]; 
		
		Ingredients a = new Ingredients(1, 0, 0); 
		
		grid[0][0] = a != null; 
		

	}

	
}