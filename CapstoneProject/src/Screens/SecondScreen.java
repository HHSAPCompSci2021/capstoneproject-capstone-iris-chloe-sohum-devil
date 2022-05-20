package Screens;

/**
 * game screen with the grid 
 * 
 * @author sphadke983, Iris Chou, cpoon870
 * @version 5/20/2022
 */

import java.awt.Desktop.Action;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.*;
import java.time.LocalTime;
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
	
	private DrawingSurface surface ;
	private Object[][] grid; 
	private Rectangle button; 
	
	private Counter counter; 
	private Disaster d1; 
	private Disaster d2; 
	private Disaster d3; 
	private Hole hole; 
	private Ingredients[] ingredients;
	private Interactions interactions; 
	private ArrayList<Orders> orders; 
	private ArrayList<Object> holding; 
	private Player player; 
	private int start;
	private LocalTime end = LocalTime.now();
	private PImage background;
	
	/**
	 * Intializes the values for each of the objects in the grid 
	 * @param surface
	 */
	
	public SecondScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		
	/*	counter = new Counter(order, 10, 10);
		d1 = new Disaster ("Fire", 1, 10); 
		d2 = new Disaster ("Flood", 2, 10 ); 
		d3 = new Disaster ("Blackout", 3,10); 
		hole = new Hole (5, 7); 
		ingredients = new Ingredients(2, 9,9); 
		order = new Orders(); 
		player = new Player (surface.loadImage("src/Player.jpg"), 4, 4); 		
		player = new Player (surface.loadImage("src/Player.png"), 4, 4); 

*/
	}

	// The statements in the setup() function 
	// execute once when the program begins
	/**
	 * sets up the screen and loads the proper images to the screen
	 */
	public void setup() {
		//600 * 800 window?
		counter = new Counter(10, 4);
		d1 = new Disaster ("Fire", 700, 200); 
		d2 = new Disaster ("Flood", 700, 300); 
		d3 = new Disaster ("Blackout", 700, 400); 
		hole = new Hole (5, 7); 
		ingredients = new Ingredients[6];
		for(int i = 0; i < ingredients.length; i++) {
			ingredients[i] = new Ingredients(surface, i+1, i*135, 550);
		}
		orders = new ArrayList<Orders>();
		orders.add(new Orders(surface));
		player = new Player (surface.loadImage("img/Player.jpg"), 300, 300);
		background = surface.loadImage("img/UpdatedKitchenGrid.png");
		
	}

	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	/**
	 * draws out the pictures to the screen to allow the user to play the game
	 * also draws out disasters and ends the game once the user has 0 lives
	 */
	public void draw() {
		surface.image(background, 0, 0, 800, 600);
		surface.fill(0);
		surface.textSize(30);
		surface.text("Lives: "+player.getLives(), 650, 50);
		surface.text("Points: "+player.getCurrency(), 650, 100);

		grid = new Character[20][20];
		counter.draw(surface, 50,50);
		hole.draw(surface, 50, 50);
		for(int i = 0; i < ingredients.length; i++) {
			ingredients[i].draw(surface, 40, 40);
		}
		for(int i = 0; i < orders.size(); i++) {
			orders.get(i).draw(surface, i);
		}

		if(!d1.isResolved() && d1.isStarted()) {
			reset();
		}
		if(!d2.isResolved() && d2.isStarted()) {
			reset();
		}
		if(!d3.isResolved() && d3.isStarted()) {
			reset();
		}
		
		if(LocalTime.now().getSecond() == 0 && !d1.isStarted()) {
			d1.reset();
		} else if (LocalTime.now().getSecond() == 20 && !d2.isStarted()) {
			d2.reset();
		} else if (LocalTime.now().getSecond() == 40 && !d3.isStarted()) {
			d3.reset();
		}
		
		if(d1.isStarted()) {
			d1.drawDisaster(surface);
			System.out.println("Drawing Fire");
		}
		if(d2.isStarted()) {
			d2.drawDisaster(surface);
			System.out.println("Drawing Flood");
		}
		if(d3.isStarted()) {
			d3.drawDisaster(surface);
			System.out.println("Drawing Blackout");
		}
		
		d1.drawEquipment(surface, 75, 75);
		d2.drawEquipment(surface, 75, 75);
		d3.drawEquipment(surface, 75, 75);
		
//		if(LocalTime.now().toSecondOfDay() - end.toSecondOfDay() > 30 && LocalTime.now().toSecondOfDay() - end.toSecondOfDay() < 45) {
//			d1.drawDisaster(surface);
//			end = LocalTime.now();
//		} else if (LocalTime.now().toSecondOfDay() - end.toSecondOfDay() > 45 && LocalTime.now().toSecondOfDay() - end.toSecondOfDay() < 60) {
//			d1.drawDisaster(surface);
//			end = LocalTime.now();
//		} else if (LocalTime.now().toSecondOfDay() - end.toSecondOfDay() > 60) {
//			d3.drawDisaster(surface);
//		}

		player.draw(surface); 
		endGame();
		
	}

	/**
	 * finds the time when the mouse is pressed
	 */
	public void mousePressed() {
//		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
//		if (button.contains(p))
//			surface.switchScreen(ScreenSwitcher.GAME_SCREEN);
		start = LocalTime.now().toSecondOfDay();
	}
	
	/**
	 * subtracts a life from the player if the time it takes to release the mouse when resolving
	 * the disaster is more than 10 seconds
	 */
	public void mouseReleased() {
		if((start - LocalTime.now().toSecondOfDay()) > 10) {
			if(d1.getDisaster() == 1 || d2.getDisaster() == 1 || d3.getDisaster() == 1) {
				surface.background(168, 50, 50);
				player.loseLife();
			} else if(d1.getDisaster() == 2 || d2.getDisaster() == 2 || d3.getDisaster() == 2) {
				surface.background(50, 64, 168);
				player.loseLife();
			} else if(d1.getDisaster() == 3 || d2.getDisaster() == 3 || d3.getDisaster() == 3) {
				surface.background(0);
				player.loseLife();
			} 
		}
	}
	
	//arrow keys are used to move the player around 
	/**
	 * allows the player to move around the screen using arrow keys and pressing the space bar to pick up and drop off ingredients
	 */
	 public void keyPressed() {					

		if (surface.keyCode == KeyEvent.VK_UP) {
			player.walk(0, -1);
		}

		else if (surface.keyCode == KeyEvent.VK_DOWN) {
			player.walk(0, 1);
		}

		else if (surface.keyCode == KeyEvent.VK_RIGHT) {
			player.walk(1, 0);
		}

		else if (surface.keyCode == KeyEvent.VK_LEFT) {
			player.walk(-1, 0);
		} else if (surface.keyCode == KeyEvent.VK_SPACE) {
			for(Ingredients e: ingredients) {
				grabAction(e);
			}
			if (Math.abs(player.getX()- hole.getX()*50) < 10 && Math.abs(player.getY() - hole.getY()*50) < 10) { 
				ArrayList<Ingredients> plate = player.getOrder();
				Disaster equip = player.getEquipment();
//				for (Ingredients i : plate) {
//					System.out.println(i.getName());
//				}
				if (equip != null)
					player.dropOffEquipment();
				else if (!plate.isEmpty()) {
					boolean complete = hole.drop(player.dropOffOrder(), orders);
					if (complete) {
						player.addCurrency();
					}
				}
			}
		}
		if (surface.keyCode == KeyEvent.VK_ENTER) {
			if(Math.abs(player.getX()- d1.getX()) < 10 && Math.abs(player.getY() - d1.getY()) < 10) {
				d1.disasterResolved();
			}
			else if(Math.abs(player.getX()- d2.getX()) < 10 && Math.abs(player.getY() - d2.getY()) < 10) {
				d2.disasterResolved();
			}
			else if(Math.abs(player.getX()- d3.getX()) < 10 && Math.abs(player.getY() - d3.getY()) < 10) {
				d3.disasterResolved();
			}
		}
	
	}
	 
	 /**
	  * reset the disasters and orders each time a disaster is not resolved
	  * takes away a life from the player
	  */
	 private void reset() {
		orders = new ArrayList<Orders>();
		orders.add(new Orders(surface));
		d1.disasterResolved();
		d2.disasterResolved();
		d3.disasterResolved();
		player.loseLife();
		
	 }
	 
	 /**
	  * allows the player to pick up objects
	  * 
	  * @param a an ingredient for the player to pick up
	  */
	 public void grabAction(Ingredients a) { 
			if (Math.abs(player.getX() - a.getX()) < 10) { 
				if (Math.abs(player.getY() - a.getY()) < 10) { 
					player.pickUp(a);
				} 
			}
			
			
			
//			} else if (player.getX() - hole.getX() < 10 && player.getY() - hole.getY() < 10) {
//				holding = null;
//				player.addCurrency();
//				orders = new ArrayList<Orders>();
//				orders.add(new Orders(surface));
//			}
//			else {
//				a.draw(surface, (int)player.getX(), (int)player.getY(), 50, 50);
	 
	 
	 }
	 
	 /**
	  * ends the game by switching to the end game screen, which allows the player to start again
	  */
	 public void endGame() {
		 if(player.getLives() <= 0) {
			 surface.switchScreen(ScreenSwitcher.END_SCREEN);
		 }
	 }
	 
	 
	 /**
	  * adds points to the player when they complete an order
	  */
	 public void orderCompletedPoints() { 
		 if (hole.drop(player.getOrder(), orders)) { 
			 player.addCurrency();
		 }
	 }
	 
} 
