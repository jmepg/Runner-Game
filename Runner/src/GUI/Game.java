package GUI;

import javax.swing.*;


import LOGIC.Avatar;
import LOGIC.ListBox;
import LOGIC.Score;
import Server.Server;
import sun.audio.AudioPlayer;
import sun.audio.ContinuousAudioDataStream;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class Game extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	boolean sv=true;
	Timer t = new Timer(17, this);
	int frame = 0;
	LoadFiles loadfiles;
	Menu menu;
	HighScores highscores;
	int pingT = 0;

	
	ListBox listbox;	
	Score score;
	Instructions instructions;
	ArrayList<Avatar> listPlayers;

	public static enum STATE{
		MENU,
		GAME,
		HIGHSCORE,
		NEWHIGHSCORE,
		PLAYERSCORE,
		INSTRUCTIONS,
	};

	public static STATE State = STATE.MENU;


	/**
	 * Game Constructor
	 * @throws IOException 
	 */
	public Game() throws IOException{
		listPlayers = new ArrayList<Avatar>();
		Avatar avatar = null;
		for (int i = 0 ; i < 4; i++){
			listPlayers.add(avatar);
		}
		

		// write the image to a file
		
		requestFocus();
		t.start();
		loadfiles = new LoadFiles();
		listbox = new ListBox(this);
		score = new Score(this);
		menu = new Menu(this);
		highscores = new HighScores(this);
		instructions = new Instructions(this);
		AudioPlayer musicPlayer = AudioPlayer.player;
		try {
			ContinuousAudioDataStream loop = new ContinuousAudioDataStream(getLoadFiles().getBacksound().getData());
			//musicPlayer.start(loop);
		} catch (IOException e) {
			e.printStackTrace();
		}
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}


	/**
	 * Paints components on the screen
	 * 
	 * @param g Graphics Object
	 */
	public void paintComponent(Graphics g){
		
				
		try {
			if(pingT==60){
				pingT=0;
			if(!pingLocal()){
				try {
					Server sv = new Server(this);
					sv.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		} else pingT++;
			}catch (IOException e) {
			e.printStackTrace();
		}
		
		super.paintComponent(g);
		if (State == STATE.MENU){ 
			g.drawImage(getLoadFiles().getMenu(), 0, 0, 500, 510, this);
			menu.draw(g);
			
		}


		else if (State == STATE.GAME){
			//1º check if all death
			int death = 0;
			for (int i=0; i < listPlayers.size(); i++){
				if (listPlayers.get(i) == null || !listPlayers.get(i).getalive())
					death++;				
			}
			if (death == listPlayers.size())
				Game.State = Game.STATE.PLAYERSCORE;

			frame();
			g.drawImage(getLoadFiles().getFloor(), 0, 0, 500, 510, this);
			listbox.draw(g);
			score.draw(g);
			for(int i=0;i<listPlayers.size();i++){
				if (listPlayers.get(i) == null)
					continue;
				switch (i){
				case 0:
					g.drawImage(getLoadFiles().getAvatar1R()[0], 10, 10, 15, 15, this);
					break;
				case 1:
					g.drawImage(getLoadFiles().getAvatar2R()[0], 135, 10, 15, 15, this);
					break;
				case 2:
					g.drawImage(getLoadFiles().getAvatar3R()[0], 260, 10, 15, 15, this);
					break;
				case 3:
					g.drawImage(getLoadFiles().getAvatar4R()[0], 385, 10, 15, 15, this);
					break;
				}
				g.setFont(new Font("Snap ITC", Font.BOLD, 13));
				g.setColor(Color.WHITE);
				g.drawString(Integer.toString(listPlayers.get(i).getScore()), (35 + 125*i), 23);
				if (listPlayers.get(i).getalive() && listPlayers.get(i) != null){
					listPlayers.get(i).draw(g);											
				}
				else g.drawImage(getLoadFiles().getCross(), (10 + i*125), 10, 15, 15, this);
			}
			g.drawImage(getLoadFiles().getOnlyfloor(), 0, 500, 500, 10, this);
			g.setFont(new Font("Snap ITC", Font.BOLD, 15)); 
			g.drawString(Integer.toString(score.getScore()), 480, 510);
		}
		else if (State == STATE.HIGHSCORE){
			g.drawImage(getLoadFiles().getHighscore(), 0, 0, 500, 510, this);
			highscores.draw(g);
		}
		else if (State == STATE.NEWHIGHSCORE){
			g.drawImage(getLoadFiles().getHighscore(), 0, 0, 500, 510, this);
			highscores.draw(g);
		}
		else if (State == STATE.PLAYERSCORE){
			g.drawImage(getLoadFiles().getHighscore(), 0, 0, 500, 510, this);
			highscores.draw(g);
		}
		else if (State == STATE.INSTRUCTIONS){
			g.drawImage(getLoadFiles().getInstructions(), 0, 0, 500, 510, this);
			instructions.draw(g);
		}

	}	


	/**
	 * Updates the screen
	 */
	public void frame(){
		for(int i=0;i<listPlayers.size();i++){
			if (listPlayers.get(i) != null && listPlayers.get(i).getalive())
				listPlayers.get(i).frame();
		}
		score.frame();
		listbox.frame();
	}

	/**
	 * Listens to keyboard events and acts accordingly
	 * 
	 * @param e key pressed
	 */
	public void keyPressed(KeyEvent e) {
		if (State == STATE.MENU){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				menu.setOption(-1);
				break;
			case KeyEvent.VK_DOWN:
				menu.setOption(1);
				break;
			case KeyEvent.VK_ENTER:
				menu.nextState();
			}
		}
		else if (State == STATE.GAME){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				//				avatar2.setVelX(2);
				//		avatar.setVelX(-2);
				break;
			case KeyEvent.VK_RIGHT:
				//avatar.setVelX(2);
				break;
			}
		}
		else if (State == STATE.HIGHSCORE){
			switch (e.getKeyCode()) {
			case (KeyEvent.VK_ESCAPE):
				State = STATE.MENU;
			break;
			case (KeyEvent.VK_ENTER):
				State = STATE.MENU;
			break;
			}
		}
		else if (State == STATE.PLAYERSCORE){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				if (getScore().getScore() > getHighscores().getListPlayer().get(6).getScore()){
					Game.State = Game.STATE.NEWHIGHSCORE;
				}	
				else {
					Game.State = Game.STATE.HIGHSCORE;
				}
				break;
			case KeyEvent.VK_ENTER:
				if (getScore().getScore() > getHighscores().getListPlayer().get(6).getScore()){
					Game.State = Game.STATE.NEWHIGHSCORE;
				}	
				else {
					Game.State = Game.STATE.HIGHSCORE;
				}
				break;
			}
		}
		else if (State == STATE.NEWHIGHSCORE){
			highscores.wirteNickname(e);
		}
		else if (State == STATE.INSTRUCTIONS){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				State = STATE.MENU;
				break;
			}
		}
	}

	/**
	 * Listens to keyboard events and acts accordingly
	 * 
	 * @param e key released
	 */
	public void keyReleased(KeyEvent e) {
		if (State == STATE.GAME){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				//avatar.setVelX(0);
				break;
			case KeyEvent.VK_RIGHT:
				//avatar.setVelX(0);
				break;
			}
		}

	}

	public void keyTyped(KeyEvent arg0) {}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e){
		frame++;
		repaint();
	}

	/**
	 * Resets variables to their original value once the user loses the game
	 */
	public void resetvariaveis() {
		//avatar reset
		for(int i=0;i<listPlayers.size();i++){
			if (listPlayers.get(i) != null){
				listPlayers.get(i).setX(0+i*150);
				listPlayers.get(i).setY(475);
				listPlayers.get(i).setAlive(true);
				listPlayers.get(i).setScore(0);
			}

		}

		//list of box all empty
		while (getListbox().getlbox().size() > 0){
			int i = 0;
			getListbox().getlbox().remove(getListbox().getlbox().get(i));
		}		
		for (int i = 0; i < getListbox().getFloor().length; i++)
			getListbox().getFloor()[i] = 0;
		getListbox().setBox(0);
		getListbox().setCont(0);
		getListbox().setnBox(1);
		//list of gifts/points all empty
		while (getScore().getListpoint().size() > 0){
			int i = 0;
			getScore().getListpoint().remove(getScore().getListpoint().get(i));
		}		
		getScore().setScore(0);
		getScore().setNewscorepoint(0);
	}	
	/**
	 * 
	 * @return other resources
	 */
	public LoadFiles getLoadFiles() {
		return loadfiles;
	}

	/**
	 * 
	 * @return list of obstacles
	 */
	public ListBox getListbox() {
		return listbox;
	}

	/**
	 * 
	 * @return list of high scores
	 */
	public HighScores getHighscores() {
		return highscores;
	}

	/**
	 * 
	 * @return user score as game progresses
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * 
	 * @return number of frames passed
	 */
	public int getFrame() {
		return frame;
	}

	/**
	 * 
	 * @return list of user's playing
	 */
	public ArrayList<Avatar> getListPlayers(){
		return listPlayers;
	}

	public void startPlayer(int id){
		Avatar avatar = null;
		switch (id){
		case 0:
			avatar = new Avatar(0, 475, getLoadFiles().getAvatar1R()[0], getLoadFiles().getAvatar1R(), getLoadFiles().getAvatar1L(), getLoadFiles().getAvatar1RU(), getLoadFiles().getAvatar1LU(), this);
			break;
		case 1:
			avatar = new Avatar(150, 475, getLoadFiles().getAvatar2R()[0], getLoadFiles().getAvatar2R(), getLoadFiles().getAvatar2L(), getLoadFiles().getAvatar2RU(), getLoadFiles().getAvatar2LU(), this);
			break;
		case 2:
			avatar = new Avatar(300, 475, getLoadFiles().getAvatar3R()[0], getLoadFiles().getAvatar3R(), getLoadFiles().getAvatar3L(), getLoadFiles().getAvatar3RU(), getLoadFiles().getAvatar3LU(), this);
			break;
		case 3:
			avatar = new Avatar(450, 475, getLoadFiles().getAvatar4R()[0], getLoadFiles().getAvatar4R(), getLoadFiles().getAvatar4L(), getLoadFiles().getAvatar4RU(), getLoadFiles().getAvatar4LU(), this);
			break;
		default:
			break;
		}

		if (avatar != null)
			listPlayers.set(id, avatar);

	}
	
	public void setSv(boolean b){
		sv = b;
	}
	  public boolean pingLocal() throws UnknownHostException, IOException {
		    String ipAddress = "127.0.0.1";
		    InetAddress inet = InetAddress.getByName(ipAddress);
			return inet.isReachable(5000);
	    }
	
} 
