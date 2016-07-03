package LOGIC;

import java.awt.Graphics;
import java.awt.Rectangle;

import GUI.Game;

public class ScorePoint {

	int x;
	int y;
	int velY;
	int coluna;
	int value;
	Game game;

	/**
	 * Constructor
	 * 
	 * @param x
	 * @param y
	 * @param coluna
	 * @param value
	 * @param game
	 */
	public ScorePoint(int x, int y, int coluna, int value, Game game){
		super();
		this.x = x;
		this.y = y;
		this.velY = 5;
		this.coluna = coluna;
		this.value = value;
		this.game = game;
	}

	/**
	 * Updates score preview every frame
	 */
	public void frame(){
		this.y += velY;		
	}

	/**
	 * Updates score preview
	 * 
	 * @param g
	 */
	public void draw(Graphics g){
		if (velY == 0){
			if (value == 1)
				g.drawImage(game.getLoadFiles().getPoint1(), x, (y + (game.getListbox().getCont() * 2)), 30, 30, game);
			else if (value == 3)
				g.drawImage(game.getLoadFiles().getPoint3(), x, (y + (game.getListbox().getCont() * 2)), 30, 30, game);
			else g.drawImage(game.getLoadFiles().getPoint5(), x, (y + (game.getListbox().getCont() * 2)), 30, 30, game);
		}
		else {
			if (value == 1)
				g.drawImage(game.getLoadFiles().getPoint1(), x, y, 30, 30, game);
			else if (value == 3)
				g.drawImage(game.getLoadFiles().getPoint3(), x, y, 30, 30, game);
			else g.drawImage(game.getLoadFiles().getPoint5(), x, y, 30, 30, game);
		}
	}

	/**
	 * 
	 * @return rectangle
	 */
	public Rectangle getBounds(){
		return new Rectangle(x, y, 30, 30);
	}

	/**
	 * 
	 * @return x position
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * @return y position
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return point dropping velocity
	 */
	public int getVelY() {
		return velY;
	}

	/**
	 * setter method for point dropping velocity
	 * @param velY 
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}

	/**
	 * 
	 * @return which column the point is in
	 */
	public int getColuna() {
		return coluna;
	}
	
	/**
	 * tells whether the point is worth 1, 3 or 5 points
	 * @return
	 */
	public int getValue() {
		return value;
	}


}
