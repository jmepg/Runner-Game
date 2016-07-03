package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu {

	String[] options = {"Play", "HighScore", "Instructions", "Exit"};
	int option = 0;
	Game game;
	
	/**
	 * Constructor
	 * @param game Gameplay responsible functions
	 */
	public Menu(Game game){
		this.game = game;
	}
	
	/**
	 * Draws keyboard controlled menu (play, highscore, instructions, exit)
	 * @param g
	 */
	public void draw(Graphics g){
		g.setFont(new Font("Snap ITC", Font.BOLD, 30)); 
		g.setColor(Color.WHITE);
		g.drawString(options[0], 175, 250);
		g.drawString(options[1], 175, 300);
		g.drawString(options[2], 175, 350);
		g.drawString(options[3], 175, 400);
		g.setColor(new Color(255, 108, 0));
		switch (option){
		case 0:			
			g.drawString(options[0], 175, 250);
			break;
		case 1:
			g.drawString(options[1], 175, 300);
			break;
		case 2:
			g.drawString(options[2], 175, 350);
			break;
		case 3:
			g.drawString(options[3], 175, 400);
			break;
		}
		for (int i = 0; i < game.getListPlayers().size(); i++){
			if (game.getListPlayers().get(i) != null)
				g.drawImage(game.getLoadFiles().getCheck(), 400, (170+i*30), 15, 15, game);
			else g.drawImage(game.getLoadFiles().getNotCheck(), 400, (170+i*30), 15, 15, game);
		}
	}
	
	/**
	 * 
	 * @return menu option selected
	 */
	public int getOption() {
		return option;
	}
	
	/**
	 * loops menu, i.e. when key down is pressed on the last option, it goes to the first
	 * @param nextOption
	 */
	public void setOption(int nextOption) {
		this.option += nextOption;
		if (option == 4)
			this.option = 0;
		else if (option == -1)
			this.option = 3;
	}

	/**
	 * Redirects the game.STATE according to the chosen option
	 */
	public void nextState() {
		switch (option){
		case 0:
			game.resetvariaveis();
			Game.State = Game.STATE.GAME;
			break;
		case 1:
			Game.State = Game.STATE.HIGHSCORE;
			break;
		case 2:
			Game.State = Game.STATE.INSTRUCTIONS;
			break;
		case 3:
			game.getHighscores().saveScore();
			System.exit(1);
		}
		
	}	
	
}
