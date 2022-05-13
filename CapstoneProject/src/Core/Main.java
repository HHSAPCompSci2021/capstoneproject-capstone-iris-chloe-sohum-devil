package Core;
import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

/**
 * main class to run the program and open up a new drawing surface
 * 
 * @author cpoon870
 * @version 5/13/2022
 */
public class Main {

	public static void main(String[] args) {
		
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(500, 300);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();

	}

}
