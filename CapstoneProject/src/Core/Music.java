package Core;

import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 * allows the game to play background music
 * 
 * @author cpoon870 and sphadke983
 * @version 5/20/2022
 */
public class Music {

	
	/**
	 * method to play music during the game
	 * 
	 * @param musicLoc a string with the path of the audio file
	 */
	public void playMusic(String musicLoc) { 
		
		
		try { 
			
			File musicPath = new File(musicLoc); 
			
			if(musicPath.exists()) { 
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip(); 
				clip.open(audioInput); 
				clip.start(); 
				
				JOptionPane.showMessageDialog(null, "Press OK to stop playing"); 
				
			}
			
			else { 
				
				System.out.print("Can't find file" );
			}
		}
		
		catch(Exception ex) { 
			ex.printStackTrace();
		}
		
	}
}
