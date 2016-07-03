package LOGIC;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import GUI.Game;

public class Box {
	
	private int x;
	private int y;
	private int velY;
	Random vel = new Random();
	Game game;
	
	/**
	 * Constructor
	 * 
	 * @param x x axis position
	 * @param y y axis position
	 * @param game
	 */
	public Box(int x, int y, Game game) {
		super();
		this.x = x;
		this.y = y;
		this.velY = vel.nextInt(3)+1;
		this.game = game;
	}
	
	/**
	 * 
	 * @return rectangle
	 */
	public Rectangle getBounds(){
		return new Rectangle(getX(), getY(), 50, 35);
	}
	
	/**
	 * descends the box each frame
	 */
	public void frame(){
		this.y += velY; 
	}
	
	/**
	 * draws the boxes
	 * @param g
	 */
	public void draw(Graphics g){		
		g.drawImage(game.getLoadFiles().getEnemybox(), getX(), getY(), 50, 50, game);
	}
	
	/**
	 * Draws the boxes
	 * 
	 * @param g
	 * @param x
	 * @param y
	 * @param game
	 */
	public void draw(Graphics g, int x, int y, Game game){		
		g.drawImage(game.getLoadFiles().getFriendbox(), x, y, 50, 50, game);
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
}
