package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Instructions {

	
	Game game;
	
	/**
	 * Constructor
	 * 
	 * @param game
	 */
	public Instructions(Game game) {
		this.game = game;
	}
	
	/**
	 * Draws the instructions graphically on screen
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setFont(new Font("Snap ITC", Font.BOLD, 20)); 
		g.setColor(Color.WHITE);
		g.drawString("Use your Keyboard right", 100, 150);
		g.drawString("and left KEY to move", 100, 175);
		g.drawString("the BIRD", 100, 200);
		g.drawImage(game.getLoadFiles().getEnemybox(), 100, 215, 50, 50, game);
		g.drawString("Don't touch them", 155, 250);
		g.drawImage(game.getLoadFiles().getFriendbox(), 100, 265, 50, 50, game);
		g.drawString("Climb/Run over them", 155, 300);
		g.drawImage(game.getLoadFiles().getPoint1(), 110, 330, 30, 30, game);
		g.drawString("Add 1 point", 150, 350);
		g.drawImage(game.getLoadFiles().getPoint3(), 110, 360, 30, 30, game);
		g.drawString("Add 3 points", 150, 380);
		g.drawImage(game.getLoadFiles().getPoint5(), 110, 390, 30, 30, game);
		g.drawString("Add 5 points", 150, 410);
		g.drawString("Clearing line add 1 point", 100, 450);
				
		
	}
	
	

}
