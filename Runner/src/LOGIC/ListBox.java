package LOGIC;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import GUI.Game;
import sun.audio.AudioPlayer;

public class ListBox {

	LinkedList<Box> lbox = new LinkedList<Box>();
	int[] floor = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // numero de caixas de cada coluna
	int box = 0;
	int nBox = 1;
	int cont = 0;
	boolean line = false;
	Box TempBox;
	int narea = 0;
	Game game;
	Random random = new Random();
	
	/**
	 * Constructor
	 * @param game
	 */
	public ListBox(Game game) {
		this.game = game;
	}

	/**
	 * Update operations for each frame
	 */
	public void frame() {
		if (game.getFrame() % 50 == 0){
			box++;
			if (box % 30 ==
					0 && nBox < 4) //can't create more than 4 boxes at same frame
				nBox++;
			for (int b = 0; b < nBox; b++)		
				addnewBox();
		}
		//check box on floor
		for (int i = 0; i < lbox.size(); i++) {
			TempBox = lbox.get(i);
			TempBox.frame();
			if (TempBox.getY() >= (450 - ((floor[(int) (TempBox.getX() / 50)] * 50) + 2 * cont))) {
				floor[(int) (TempBox.getX() / 50)] += 1;
				AudioPlayer player = AudioPlayer.player;
				player.start(game.getLoadFiles().getBoxsound());
				remove(TempBox);
			}
		}
		//verify if floor column is superior to 10 it doesn't increment
		for (int j = 0; j < floor.length; j++) 
			if (floor[j] >= 10)
				floor[j] = 10;
		//verify it is a line on the floor
		for (int j = 0; j < floor.length; j++) {
			if (floor[j] < 1)
				break;
			else if (j == 9)
				this.line = true;
		}
	}

	/**
	 * Optimized distribution random box and return the next column
	 * 
	 * @return column in which the next box will fall
	 */
	public int nextColumn(){ 
		int area = 0;
		for (int f = 0; f < floor.length; f++){
			if (floor[f] >= 8)
				area += 0;
			else area += (7-floor[f]);
		}
		int numero = random.nextInt(area);
		area = 0;
		int f;
		for (f = 0; f < floor.length; f++){
			if (floor[f] >= 8)
				area += 0;
			else area += (7-floor[f]);
			if (numero < area){
				break;
			}
		}
		return f;
	}

	/**
	 * add a new Box for the List
	 */
	public void addnewBox() {
		int coluna = 0;
		boolean check = true; //can create
		coluna = nextColumn();
		Box b = new Box(50 * coluna, -50, game);
		for (int i = 0; i < lbox.size(); i++) {
			TempBox = lbox.get(i);
			if ((TempBox.getX()/50) == coluna)
				if (0 >= TempBox.getY())
					check = false;
		}
		if (check)
			lbox.add(b);

	}

	/**
	 * Draws the boxes in their correct positions
	 * 
	 * @param g
	 */
	public void draw(Graphics g){
		for (int i = 0; i < lbox.size(); i++){
			TempBox = lbox.get(i);
			TempBox.draw(g); 			
		}
		if (line){
			cont++;
			if (cont >=25){
				for (int l = 0; l < floor.length; l++)
					floor[l] -= 1;
				for (int k = 0; k < game.getScore().getListpoint().size(); k++)
					if (game.getScore().getListpoint().get(k).getVelY() == 0)
						game.getScore().getListpoint().get(k).setY(game.getScore().getListpoint().get(k).getY()+50);
				line = false;
				cont = 0;	
				for (int i = 0; i < game.getListPlayers().size(); i++){
					if(game.getListPlayers().get(i) == null || !game.getListPlayers().get(i).getalive())continue;
					game.getListPlayers().get(i).setScore(game.getListPlayers().get(i).getScore()+1);
					game.getScore().setScore(game.getScore().getScore() + 1);
				}
				
				for(int i=0;i<game.getListPlayers().size();i++){
					if(game.getListPlayers().get(i) == null)continue;
					game.getListPlayers().get(i).setY(game.getListPlayers().get(i).getY() + 50);
				}
				
			}
		}
		for (int j = 0; j < floor.length; j++){
			for (int k = 0; k < floor[j]; k++){
				TempBox.draw(g, j*50, ((450-k*50)+ 2 * cont), game);		
			}

		}
	}

	/**
	 * Getter method for cont
	 * 
	 * @return counter
	 */
	public int getCont() {
		return cont;
	}

	/**
	 * Adds a new box
	 * @param box
	 */
	public void add(Box box) {
		lbox.add(box);
	}

	/**
	 * Removes a box
	 * @param box
	 */
	public void remove(Box box) {
		lbox.remove(box);
	}

	/**
	 * 
	 * @return List of linked boxes
	 */
	public LinkedList<Box> getlbox() {
		return lbox;
	}
	
	/**
	 * 
	 * @return bottom line of columns
	 */
	public int[] getFloor() {
		return floor;
	}

	/**
	 * Setter method for box
	 * @param box
	 */
	public void setBox(int box) {
		this.box = box;
	}

	/**
	 * Setter method for nbox
	 * @param nBox
	 */
	public void setnBox(int nBox) {
		this.nBox = nBox;
	}

	/**
	 * Setter method for cont
	 * @param cont
	 */
	public void setCont(int cont) {
		this.cont = cont;
	}
	



}
