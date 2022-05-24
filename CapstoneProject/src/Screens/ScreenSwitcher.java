package Screens;

import game.Player;

/**
 * interface for the screens
 * 
 * @author cpoon870
 * @version 5/20/2022
 */
public interface ScreenSwitcher {
	public static final int MENU_SCREEN = 0;
	public static final int GAME_SCREEN = 1;
	public static final int END_SCREEN = 2;
	
	/**
	 * allows the screens to be switched
	 * @param i the screen to switch to
	 */
	public void switchScreen(int i);
}
