package GUI;

import java.awt.Dimension;


import Server.*;
import javax.swing.JFrame;


/**
 * Constructor
 */
public class Runner {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 510;
	public static final String TITLE = "Runner";
	
	/**
	 * Main function
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String args[]) throws Exception{
		JFrame f = new JFrame(TITLE);
		
		Game game = new Game();		
		game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		game.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		game.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		
		f.add(game);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		
        Server server = new Server(game);
        server.start();     	
		
	}	
	
}