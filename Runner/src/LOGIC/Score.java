package LOGIC;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import GUI.Game;
import sun.audio.AudioPlayer;

public class Score {
	LinkedList<ScorePoint> listpoint = new LinkedList<ScorePoint>();
	int score;
	int newscorepoint; //number of gift points that are falling down 
	Random r = new Random();
	ScorePoint TempPoint;
	Game game;

	/**
	 * Constructor
	 * 
	 * @param game
	 */
	public Score (Game game){
		this.game = game;
		this.score = 0;
		this.newscorepoint = 0;
	}

	/**
	 * Updates the score preview
	 * and remove point from their list
	 */
	public void frame(){
		if (newscorepoint < 2)
			createPoint();
		for (int i = 0; i < listpoint.size(); i++){
			TempPoint = listpoint.get(i);
			TempPoint.frame();
			if (TempPoint.getY() >= (470 - (game.getListbox().getFloor()[TempPoint.getColuna()] * 50))) //colide
				TempPoint.setVelY(0);
			if (TempPoint.getVelY() == 0) //continuar a colidir com a listas de de caixas que estao no chao
				TempPoint.setY(470 - (game.getListbox().getFloor()[TempPoint.getColuna()] * 50));
			if (Physics.Collision(game.getListbox().getlbox(), TempPoint)) //se uma caixa lhe cair em cima remove
				removePoint(TempPoint);
			for(int j=0;j<game.getListPlayers().size();j++){
				if (game.getListPlayers().get(j) == null)
					continue;
					if (Physics.Collision(TempPoint, game.getListPlayers().get(j))){
						AudioPlayer player = AudioPlayer.player;
						player.start(game.getLoadFiles().getBoxsound());
						game.getListPlayers().get(j).setScore((game.getListPlayers().get(j).getScore()+TempPoint.getValue()));
						score += TempPoint.getValue();
						removePoint(TempPoint);
					}
			}
		}
	}

	/**
	 * Draws corresponding position on the screen
	 * @param g
	 */
	public void draw(Graphics g){
		for (int i = 0; i < listpoint.size(); i++){
			TempPoint = listpoint.get(i);
			TempPoint.draw(g);
		}
	}

	/**
	 * verifies if that is a point in that column
	 * 
	 * @return if true changes column, false does nothing
	 */
	public int nextcolumn(){
		boolean can = true;
		int column;
		do {
			column = r.nextInt(10);
			for (int i = 0; i < listpoint.size(); i++){
				if (listpoint.get(i).getColuna() == column){
					can = false;
					break;
				}
				else can = true;
			}			
		} while (!can);
		return column;
	}

	/**
	 * Creates a new point to descend on to the game
	 */
	public void createPoint(){
		int coluna = nextcolumn();
		int value = newvalue();
		ScorePoint point = new ScorePoint(coluna * 50 +10, -30, coluna, value, game);
		listpoint.add(point);
		newscorepoint++;
	}

	/**
	 * Removes point from screen
	 * 
	 * @param point
	 */
	public void removePoint(ScorePoint point){
		listpoint.remove(point);
		newscorepoint--;
	}

	/**
	 * Randomly selects from 1 of 3 possible point amounts
	 * 
	 * @return 1, 3 or 5
	 */
	public int newvalue(){
		int value = r.nextInt(10);
		if (value <6)
			return 1;
		else if (value >= 6 && value <= 8)
			return 3;
		else return 5;
	}

	/**
	 * Getter method for score
	 * @return
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Setter method for score
	 * 
	 * @param n
	 */
	public void setScore(int n) {
		this.score = n;
	}

	/**
	 * Setter method for newscorepoint
	 * @param newscorepoint
	 */
	public void setNewscorepoint(int newscorepoint) {
		this.newscorepoint = newscorepoint;
	}

	/**
	 * Getter method for listpoint
	 * @return listpoint
	 */
	public LinkedList<ScorePoint> getListpoint() {
		return listpoint;
	}


}
