package Core;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
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
		
		//String filepath = "audio\//Volume Beta 08. Biome Fest.mp3"; 
		
		Music musicObject = new Music(); 
		//musicObject.playMusic(filepath);

	}
	

	

}
