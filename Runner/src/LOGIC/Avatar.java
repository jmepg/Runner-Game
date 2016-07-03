package LOGIC;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import GUI.Game;

public class Avatar {

	private int x;
	private int y;
	private int velX;
	private int velY;
	boolean up = false;
	boolean alive;
	int score;
	int nextimg = 0;
	BufferedImage lastimg;
	private BufferedImage[] avatarR;
	private BufferedImage[] avatarL;
	private BufferedImage[] avatarRU;
	private BufferedImage[] avatarLU;
	Game game;

	/**
	 * Constructor
	 * 
	 * @param x position in x axis
	 * @param y	position in y axis
	 * @param firstimg	image
	 * @param game
	 */
	public Avatar(int x, int y, BufferedImage firstimg, BufferedImage[] avatarR, BufferedImage[] avatarL, BufferedImage[] avatarRU, BufferedImage[] avatarLU, Game game) {
		super();
		this.x = x;
		this.y = y;
		this.velX = 0;
		this.velY = -2;
		this.alive = false;
		this.score = 0;
		this.lastimg = firstimg;
		this.avatarR = avatarR;
		this.avatarL = avatarL;
		this.avatarRU = avatarRU;
		this.avatarLU = avatarLU;
		this.game = game;
	}

	/**
	 * Calculates in which column the BIRD first pixel is
	 * 
	 * @return a number from 0 to 9
	 */
	public int nextYinicial(){
		if (x < 50)
			return (475 - game.getListbox().getFloor()[0] * 50);
		else if (x >= 50 && x < 100)
			return (475 - game.getListbox().getFloor()[1] * 50);
		else if (x >= 100 && x < 150)
			return (475 - game.getListbox().getFloor()[2] * 50);
		else if (x >= 150 && x < 200)
			return (475 - game.getListbox().getFloor()[3] * 50);
		else if (x >= 200 && x < 250)
			return (475 - game.getListbox().getFloor()[4] * 50);
		else if (x >= 250 && x < 300)
			return (475 - game.getListbox().getFloor()[5] * 50);
		else if (x >= 300 && x < 350)
			return (475 - game.getListbox().getFloor()[6] * 50);
		else if (x >= 350 && x < 400)
			return (475 - game.getListbox().getFloor()[7] * 50);
		else if (x >= 400 && x < 450)
			return (475 - game.getListbox().getFloor()[8] * 50);
		else if (x >= 450)
			return (475 - game.getListbox().getFloor()[9] * 50);
		return y;
	}

	/**
	 * Calculates in which line the BIRD last pixel is
	 * 
	 * @return a number from 0 to 9
	 */
	public int nextYfinal(){
		if ((x + 25) <= 50)
			return (475 - game.getListbox().getFloor()[0] * 50);
		else if ((x + 25) > 50 && (x + 25) <= 100)
			return (475 - game.getListbox().getFloor()[1] * 50);
		else if ((x + 25) > 100 && (x + 25) <= 150)
			return (475 - game.getListbox().getFloor()[2] * 50);
		else if ((x + 25) > 150 && (x + 25) <= 200)
			return (475 - game.getListbox().getFloor()[3] * 50);
		else if ((x + 25) > 200 && (x + 25) <= 250)
			return (475 - game.getListbox().getFloor()[4] * 50);
		else if ((x + 25) > 250 && (x + 25) <= 300)
			return (475 - game.getListbox().getFloor()[5] * 50);
		else if ((x + 25) > 300 && (x + 25) <= 350)
			return (475 - game.getListbox().getFloor()[6] * 50);
		else if ((x + 25) > 350 && (x + 25) <= 400)
			return (475 - game.getListbox().getFloor()[7] * 50);
		else if ((x + 25) > 400 && (x + 25) <= 450)
			return (475 - game.getListbox().getFloor()[8] * 50);
		else if ((x + 25) > 450)
			return (475 - game.getListbox().getFloor()[9] * 50);
		return y;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public int nextXvelPositiva(int s){
		switch(s){
		case 0:
			return 25;
		case 1:
			return 75;
		case 2:
			return 125;
		case 3:
			return 175;
		case 4:
			return 225;
		case 5:
			return 275;
		case 6:
			return 325;
		case 7:
			return 375;
		case 8:
			return 425;
		}
		return s;		
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public int nextXvelNegativa(int s){
		switch(s){
		case 1:
			return 50;
		case 2:
			return 100;
		case 3:
			return 150;
		case 4:
			return 200;
		case 5:
			return 250;
		case 6:
			return 300;
		case 7:
			return 350;
		case 8:
			return 400;
		case 9:
			return 450;
		}
		return s;		
	}
	
	/**
	 * Makes a rectangle out of the avatar sprite
	 * 
	 * @return rectangle 25x25
	 */
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 25, 25);
	}

	/**
	 * Avatar behavior for each frame
	 */
	public void frame(){
		this.x += this.velX;
		if (this.x < 0)
			this.x = 0;
		if (this.x > 475)
			this.x = 475;
		if(Physics.Collision(this, game.getListbox().getFloor())){
			up = true;
			this.x -= this.velX;
			this.y += this.velY;
			if (velX > 0)
				this.x = nextXvelPositiva(getX()/50);
			else if (velX < 0)
				this.x = nextXvelNegativa(getX()/50);
			else this.y = this.velY;
		}
		else {
			up = false;
			int imgYfinal = nextYfinal();
			int imgYinicial = nextYinicial();
			if (imgYfinal <= imgYinicial)
				this.y = imgYfinal;
			else this.y = imgYinicial;
		}	

		if (Physics.Collision(this, game.getListbox().getlbox()))
			setAlive(false);

	}

	/**
	 * Draws avatar
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		if (nextimg % 4 == 0)
			nextimg = 0;
		if (velX > 0){
			if (up)
				g.drawImage(avatarRU[nextimg], (int) this.getX(), (int) (this.getY() + 2 * game.getListbox().getCont()), 25, 25, game);
			else {
				g.drawImage(avatarR[nextimg], (int) this.getX(), (int) (this.getY() + 2 * game.getListbox().getCont()), 25, 25, game);
				lastimg = avatarR[0];
			}
		}
		else if (velX < 0){
			if (up)
				g.drawImage(avatarLU[nextimg], (int) this.getX(), (int) (this.getY() + 2 * game.getListbox().getCont()), 25, 25, game);
			else {
				g.drawImage(avatarL[nextimg], (int) this.getX(), (int) (this.getY() + 2 * game.getListbox().getCont()), 25, 25, game);
				lastimg = avatarL[0];
			}
		}	
		else g.drawImage(lastimg, (int) this.getX(), (int) (this.getY() + 2 * game.getListbox().getCont()), 25, 25, game);
		if (game.getFrame() % 6 == 0)
			nextimg++;
	}

	/**
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}	
	
	/**
	 * 
	 * @return alive
	 */
	public boolean getalive() {
		return alive;
	}
	
	/**
	 * 
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * 
	 * @param y y axis position
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @param x x axis position
	 */
	public void setX(int x) {
		this.x = x;	
	}
	
	/**
	 * 
	 * @param velX 
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	/**
	 * 
	 * @param velY
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	/**
	 * 
	 * @param alive
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/**
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
