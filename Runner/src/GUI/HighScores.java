package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import GUI.Game.STATE;


public class HighScores {

	LinkedList<Player> listPlayer = new LinkedList<Player>();
	String newNickname = "";
	int nickSize = 0;
	Game game;
	Player TempPlayer;
	
	/**
	 * Constructor
	 * 
	 * @param game
	 */
	public HighScores(Game game) {
		this.game = game; 
		init();
	}
	/**
	 * Read from HighScore.txt and save top 7 HighScores for HighScore list
	 */
	private void init() {
		String nickname = null;
		int score = 0;
		Scanner read = null;
		try {
			read = new Scanner(new File("./resources/HighScore.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (read.hasNextLine()){
			nickname = read.nextLine();
			score = Integer.parseInt(read.nextLine());
			listPlayer.add(new Player(nickname, score));
		}
		read.close();

		Collections.sort(listPlayer, Collections.reverseOrder());
	}

	/**
	 * When exit game, save the top 7 Highscores to HighScore.txt
	 */
	public void saveScore() {
		PrintWriter file = null;
		try {
			file = new PrintWriter(new File(new File("").getAbsolutePath().concat("\\resources\\HighScore.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 7; i++){
			file.println(listPlayer.get(i).getNickname());
			file.print(listPlayer.get(i).getScore());
			if (i != 6)
				file.println();
		}
		file.close();		
	}

	/**
	 * 
	 * @return list of highscores of all players(nick/score)
	 */
	public LinkedList<Player> getListPlayer() {
		return listPlayer;
	}

	/**
	 * 	Add a new highscored player to the list of Highscores 
	 * @param player(nickname/score)
	 */
	public void addPlayer(Player player){
		listPlayer.add(player);
		Collections.sort(listPlayer, Collections.reverseOrder());
	}

	/**
	 * Print nickname and his score
	 * @param g
	 */
	public void draw(Graphics g) {
		if (Game.State == STATE.HIGHSCORE){
			g.setFont(new Font("Snap ITC", Font.BOLD, 30)); 
			g.setColor(Color.WHITE);
			for (int i = 0; i < 7; i++){
				g.drawString(listPlayer.get(i).getNickname(), 100, 150 + i * 50);
				g.drawString(Integer.toString(listPlayer.get(i).getScore()), 350, 150 + i * 50);			

			}
		}
		else if (Game.State == STATE.NEWHIGHSCORE){
			g.setFont(new Font("Snap ITC", Font.BOLD, 30)); 
			g.setColor(Color.WHITE);
			g.drawString("NewTeamScore", 100, 150);
			g.drawString(Integer.toString(game.getScore().getScore()), 100, 200);
			g.drawString("TeamNickname", 100, 250);
			g.drawString(newNickname, 100, 300);
		}
		else if (Game.State == STATE.PLAYERSCORE){
			g.setFont(new Font("Snap ITC", Font.BOLD, 30)); 
			g.setColor(Color.WHITE);
			g.drawString("TeamScore", 100, 150);
			g.drawString(Integer.toString(game.getScore().getScore()), 100, 200);
			for (int i = 0; i < game.listPlayers.size(); i++){
				if (game.getListPlayers().get(i) != null && !game.listPlayers.get(i).getalive()){
					switch (i){
					case 0:
						g.drawImage(game.getLoadFiles().getAvatar1R()[0], 100, 250, 30, 30, game);
						break;
					case 1:
						g.drawImage(game.getLoadFiles().getAvatar2R()[0], 100, 300, 30, 30, game);
						break;
					case 2:
						g.drawImage(game.getLoadFiles().getAvatar3R()[0], 100, 350, 30, 30, game);
						break;
					case 3:
						g.drawImage(game.getLoadFiles().getAvatar4R()[0], 100, 400, 30, 30, game);
						break;
					default: 
						break;						
					}
					g.drawString(Integer.toString(game.listPlayers.get(i).getScore()), 150, (275 + i*50));
				}
			}
		}
	}

	/**
	 * Maps each key pressed to its corresponding uppercase letter in order to add a player nickname
	 * @param e
	 */
	public void wirteNickname(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			if (nickSize < 8){
				newNickname += "A";
				nickSize++;
			}
			break;
		case KeyEvent.VK_B:
			if (nickSize < 8){
				newNickname += "B";
				nickSize++;
			}
			break;
		case KeyEvent.VK_C:
			if (nickSize < 8){
				newNickname += "C";
				nickSize++;
			}
			break;
		case KeyEvent.VK_D:
			if (nickSize < 8){
				newNickname += "D";
				nickSize++;
			}
			break;
		case KeyEvent.VK_E:
			if (nickSize < 8){
				newNickname += "E";
				nickSize++;
			}
			break;
		case KeyEvent.VK_F:
			if (nickSize < 8){
				newNickname += "F";
				nickSize++;
			}
			break;
		case KeyEvent.VK_G:
			if (nickSize < 8){
				newNickname += "G";
				nickSize++;
			}
			break;
		case KeyEvent.VK_H:
			if (nickSize < 8){
				newNickname += "H";
				nickSize++;
			}
			break;
		case KeyEvent.VK_I:
			if (nickSize < 8){
				newNickname += "I";
				nickSize++;
			}
			break;
		case KeyEvent.VK_J:
			if (nickSize < 8){
				newNickname += "J";
				nickSize++;
			}
			break;
		case KeyEvent.VK_K:
			if (nickSize < 8){
				newNickname += "K";
				nickSize++;
			}
			break;
		case KeyEvent.VK_L:
			if (nickSize < 8){
				newNickname += "L";
				nickSize++;
			}
			break;
		case KeyEvent.VK_M:
			if (nickSize < 8){
				newNickname += "M";
				nickSize++;
			}
			break;
		case KeyEvent.VK_N:
			if (nickSize < 8){
				newNickname += "N";
				nickSize++;
			}
			break;
		case KeyEvent.VK_O:
			if (nickSize < 8){
				newNickname += "O";
				nickSize++;
			}
			break;
		case KeyEvent.VK_P:
			if (nickSize < 8){
				newNickname += "P";
				nickSize++;
			}
			break;
		case KeyEvent.VK_Q:
			if (nickSize < 8){
				newNickname += "Q";
				nickSize++;
			}
			break;
		case KeyEvent.VK_R:
			if (nickSize < 8){
				newNickname += "R";
				nickSize++;
			}
			break;
		case KeyEvent.VK_S:
			if (nickSize < 8){
				newNickname += "S";
				nickSize++;
			}
			break;
		case KeyEvent.VK_T:
			if (nickSize < 8){
				newNickname += "T";
				nickSize++;
			}
			break;
		case KeyEvent.VK_U:
			if (nickSize < 8){
				newNickname += "U";
				nickSize++;
			}
			break;
		case KeyEvent.VK_V:
			if (nickSize < 8){
				newNickname += "V";
				nickSize++;
			}
			break;
		case KeyEvent.VK_W:
			if (nickSize < 8){
				newNickname += "W";
				nickSize++;
			}
			break;
		case KeyEvent.VK_X:
			if (nickSize < 8){
				newNickname += "X";
				nickSize++;
			}
			break;
		case KeyEvent.VK_Y:
			if (nickSize < 8){
				newNickname += "Y";
				nickSize++;
			}
			break;
		case KeyEvent.VK_Z:
			if (nickSize < 8){
				newNickname += "Z";
				nickSize++;
			}
			break;
		case KeyEvent.VK_0:
			if (nickSize < 8){
				newNickname += "0";
				nickSize++;
			}
			break;
		case KeyEvent.VK_1:
			if (nickSize < 8){
				newNickname += "1";
				nickSize++;
			}
			break;
		case KeyEvent.VK_2:
			if (nickSize < 8){
				newNickname += "2";
				nickSize++;
			}
			break;
		case KeyEvent.VK_3:
			if (nickSize < 8){
				newNickname += "3";
				nickSize++;
			}
			break;
		case KeyEvent.VK_4:
			if (nickSize < 8){
				newNickname += "4";
				nickSize++;
			}
			break;
		case KeyEvent.VK_5:
			if (nickSize < 8){
				newNickname += "5";
				nickSize++;
			}
			break;
		case KeyEvent.VK_6:
			if (nickSize < 8){
				newNickname += "6";
				nickSize++;
			}
			break;
		case KeyEvent.VK_7:
			if (nickSize < 8){
				newNickname += "7";
				nickSize++;
			}
			break;
		case KeyEvent.VK_8:
			if (nickSize < 8){
				newNickname += "8";
				nickSize++;
			}
			break;
		case KeyEvent.VK_9:
			if (nickSize < 8){
				newNickname += "9";
				nickSize++;
			}
			break;
		case KeyEvent.VK_SPACE:
			if (nickSize < 8){
				newNickname += " ";
				nickSize++;
			}
			break;
		case KeyEvent.VK_BACK_SPACE:
			if (nickSize > 0){
				newNickname = newNickname.substring(0, newNickname.length()-1);
				nickSize--;
			}
			break;
		case KeyEvent.VK_ENTER:
			addPlayer(new Player(newNickname, game.getScore().getScore()));
			game.resetvariaveis();
			Game.State = Game.STATE.HIGHSCORE;
		case KeyEvent.VK_ESCAPE:
			game.resetvariaveis();
			Game.State = Game.STATE.HIGHSCORE;
		}
	}
}
