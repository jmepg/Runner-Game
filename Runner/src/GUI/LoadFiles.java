package GUI;

import sun.audio.AudioStream;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;

public class LoadFiles {

	private BufferedImage menu, highscore, enemybox, friendbox, instructions, floor, point1, point3, point5, onlyfloor, check, notCheck, cross;
	
	private BufferedImage[] avatar1R = new BufferedImage[4];
	private BufferedImage[] avatar1L = new BufferedImage[4];
	private BufferedImage[] avatar1RU = new BufferedImage[4];
	private BufferedImage[] avatar1LU = new BufferedImage[4];
	
	private BufferedImage[] avatar2R = new BufferedImage[4];
	private BufferedImage[] avatar2L = new BufferedImage[4];
	private BufferedImage[] avatar2RU = new BufferedImage[4];
	private BufferedImage[] avatar2LU = new BufferedImage[4];
	
	private BufferedImage[] avatar3R = new BufferedImage[4];
	private BufferedImage[] avatar3L = new BufferedImage[4];
	private BufferedImage[] avatar3RU = new BufferedImage[4];
	private BufferedImage[] avatar3LU = new BufferedImage[4];
	
	private BufferedImage[] avatar4R = new BufferedImage[4];
	private BufferedImage[] avatar4L = new BufferedImage[4];
	private BufferedImage[] avatar4RU = new BufferedImage[4];
	private BufferedImage[] avatar4LU = new BufferedImage[4];
	private AudioStream backsound, pointsound, boxsound;


	/**
	 * Constructor
	 */
	public LoadFiles() {
		try {

			this.menu = ImageIO.read(new File("./resources/menu.png"));
			this.check = ImageIO.read(new File("./resources/check.png"));
			this.notCheck = ImageIO.read(new File("./resources/notCheck.png"));
			
			this.highscore = ImageIO.read(new File("./resources/highscore.png"));
			
			this.instructions = ImageIO.read(new File("./resources/instructions.png"));
			
			//avatar1
			this.avatar1R[0] = ImageIO.read(new File("./resources/avatar1R2.png"));
			this.avatar1R[1] = ImageIO.read(new File("./resources/avatar1R1.png"));
			this.avatar1R[2] = ImageIO.read(new File("./resources/avatar1R2.png"));
			this.avatar1R[3] = ImageIO.read(new File("./resources/avatar1R3.png"));

			this.avatar1RU[0] = ImageIO.read(new File("./resources/avatar1RU2.png"));
			this.avatar1RU[1] = ImageIO.read(new File("./resources/avatar1RU1.png"));
			this.avatar1RU[2] = ImageIO.read(new File("./resources/avatar1RU2.png"));
			this.avatar1RU[3] = ImageIO.read(new File("./resources/avatar1RU3.png"));

			this.avatar1L[0] = ImageIO.read(new File("./resources/avatar1L2.png"));
			this.avatar1L[1] = ImageIO.read(new File("./resources/avatar1L1.png"));
			this.avatar1L[2] = ImageIO.read(new File("./resources/avatar1L2.png"));
			this.avatar1L[3] = ImageIO.read(new File("./resources/avatar1L3.png"));

			this.avatar1LU[0] = ImageIO.read(new File("./resources/avatar1LU2.png"));
			this.avatar1LU[1] = ImageIO.read(new File("./resources/avatar1LU1.png"));
			this.avatar1LU[2] = ImageIO.read(new File("./resources/avatar1LU2.png"));
			this.avatar1LU[3] = ImageIO.read(new File("./resources/avatar1LU3.png"));
			//avatar2
			this.avatar2R[0] = ImageIO.read(new File("./resources/avatar2R2.png"));
			this.avatar2R[1] = ImageIO.read(new File("./resources/avatar2R1.png"));
			this.avatar2R[2] = ImageIO.read(new File("./resources/avatar2R2.png"));
			this.avatar2R[3] = ImageIO.read(new File("./resources/avatar2R3.png"));

			this.avatar2RU[0] = ImageIO.read(new File("./resources/avatar2RU2.png"));
			this.avatar2RU[1] = ImageIO.read(new File("./resources/avatar2RU1.png"));
			this.avatar2RU[2] = ImageIO.read(new File("./resources/avatar2RU2.png"));
			this.avatar2RU[3] = ImageIO.read(new File("./resources/avatar2RU3.png"));

			this.avatar2L[0] = ImageIO.read(new File("./resources/avatar2L2.png"));
			this.avatar2L[1] = ImageIO.read(new File("./resources/avatar2L1.png"));
			this.avatar2L[2] = ImageIO.read(new File("./resources/avatar2L2.png"));
			this.avatar2L[3] = ImageIO.read(new File("./resources/avatar2L3.png"));

			this.avatar2LU[0] = ImageIO.read(new File("./resources/avatar2LU2.png"));
			this.avatar2LU[1] = ImageIO.read(new File("./resources/avatar2LU1.png"));
			this.avatar2LU[2] = ImageIO.read(new File("./resources/avatar2LU2.png"));
			this.avatar2LU[3] = ImageIO.read(new File("./resources/avatar2LU3.png"));
			//avatar3
			this.avatar3R[0] = ImageIO.read(new File("./resources/avatar3R2.png"));
			this.avatar3R[1] = ImageIO.read(new File("./resources/avatar3R1.png"));
			this.avatar3R[2] = ImageIO.read(new File("./resources/avatar3R2.png"));
			this.avatar3R[3] = ImageIO.read(new File("./resources/avatar3R3.png"));

			this.avatar3RU[0] = ImageIO.read(new File("./resources/avatar3RU2.png"));
			this.avatar3RU[1] = ImageIO.read(new File("./resources/avatar3RU1.png"));
			this.avatar3RU[2] = ImageIO.read(new File("./resources/avatar3RU2.png"));
			this.avatar3RU[3] = ImageIO.read(new File("./resources/avatar3RU3.png"));

			this.avatar3L[0] = ImageIO.read(new File("./resources/avatar3L2.png"));
			this.avatar3L[1] = ImageIO.read(new File("./resources/avatar3L1.png"));
			this.avatar3L[2] = ImageIO.read(new File("./resources/avatar3L2.png"));
			this.avatar3L[3] = ImageIO.read(new File("./resources/avatar3L3.png"));

			this.avatar3LU[0] = ImageIO.read(new File("./resources/avatar3LU2.png"));
			this.avatar3LU[1] = ImageIO.read(new File("./resources/avatar3LU1.png"));
			this.avatar3LU[2] = ImageIO.read(new File("./resources/avatar3LU2.png"));
			this.avatar3LU[3] = ImageIO.read(new File("./resources/avatar3LU3.png"));
			//avatar4
			this.avatar4R[0] = ImageIO.read(new File("./resources/avatar4R2.png"));
			this.avatar4R[1] = ImageIO.read(new File("./resources/avatar4R1.png"));
			this.avatar4R[2] = ImageIO.read(new File("./resources/avatar4R2.png"));
			this.avatar4R[3] = ImageIO.read(new File("./resources/avatar4R3.png"));

			this.avatar4RU[0] = ImageIO.read(new File("./resources/avatar4RU2.png"));
			this.avatar4RU[1] = ImageIO.read(new File("./resources/avatar4RU1.png"));
			this.avatar4RU[2] = ImageIO.read(new File("./resources/avatar4RU2.png"));
			this.avatar4RU[3] = ImageIO.read(new File("./resources/avatar4RU3.png"));

			this.avatar4L[0] = ImageIO.read(new File("./resources/avatar4L2.png"));
			this.avatar4L[1] = ImageIO.read(new File("./resources/avatar4L1.png"));
			this.avatar4L[2] = ImageIO.read(new File("./resources/avatar4L2.png"));
			this.avatar4L[3] = ImageIO.read(new File("./resources/avatar4L3.png"));

			this.avatar4LU[0] = ImageIO.read(new File("./resources/avatar4LU2.png"));
			this.avatar4LU[1] = ImageIO.read(new File("./resources/avatar4LU1.png"));
			this.avatar4LU[2] = ImageIO.read(new File("./resources/avatar4LU2.png"));
			this.avatar4LU[3] = ImageIO.read(new File("./resources/avatar4LU3.png"));
			
			this.cross = ImageIO.read(new File("./resources/cross.png"));
			this.enemybox = ImageIO.read(new File("./resources/enemybox.png"));
			this.friendbox = ImageIO.read(new File("./resources/friendbox.png"));
			this.floor = ImageIO.read(new File("./resources/floor.png"));
			this.point1 = ImageIO.read(new File("./resources/point1.png"));
			this.point3 = ImageIO.read(new File("./resources/point3.png"));
			this.point5 = ImageIO.read(new File("./resources/point5.png"));
			this.onlyfloor = ImageIO.read(new File("./resources/onlyfloor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			InputStream in = new FileInputStream("./resources/backsound.wav");
			this.backsound = new AudioStream(in);
			InputStream in2 = new FileInputStream("./resources/pointsound.wav");
			this.backsound = new AudioStream(in2);
			InputStream in3 = new FileInputStream("./resources/boxsound.wav");
			this.backsound = new AudioStream(in3);
		} catch (IOException e) {
			e.printStackTrace();

		}


		/*this.backsound = Applet.newAudioClip(this.getClass().getResource("./resources/backsound.wav"));
		this.pointsound = Applet.newAudioClip(this.getClass().getResource("./resources/pointsound.wav"));
		this.boxsound = Applet.newAudioClip(this.getClass().getResource("./resources/boxsound.wav"));*/
		
	}


	/**
	 * 
	 * @return menu screen
	 */
	public BufferedImage getMenu() {
		return menu;
	}
	
	/**
	 * 
	 * @return check
	 */
	public BufferedImage getCheck() {
		return check;
	}
	
	/**
	 * 
	 * @return notCheck
	 */
	public BufferedImage getNotCheck() {
		return notCheck;
	}

	/**
	 * 
	 * @return highscore background
	 */
	public BufferedImage getHighscore() {
		return highscore;
	}
	/**
	 * 
	 * @return instructions background
	 */
	public BufferedImage getInstructions() {
		return instructions;
	}
	
	
	/**
	 * 
	 * 
	 * @return the avatar's moves
	 */
	public BufferedImage[] getAvatar1R() {
		return avatar1R;
	}


	public void setAvatar1R(BufferedImage[] avatar1r) {
		avatar1R = avatar1r;
	}


	public BufferedImage[] getAvatar1L() {
		return avatar1L;
	}


	public void setAvatar1L(BufferedImage[] avatar1l) {
		avatar1L = avatar1l;
	}


	public BufferedImage[] getAvatar1RU() {
		return avatar1RU;
	}


	public void setAvatar1RU(BufferedImage[] avatar1ru) {
		avatar1RU = avatar1ru;
	}


	public BufferedImage[] getAvatar1LU() {
		return avatar1LU;
	}


	public void setAvatar1LU(BufferedImage[] avatar1lu) {
		avatar1LU = avatar1lu;
	}


	public BufferedImage[] getAvatar2R() {
		return avatar2R;
	}


	public void setAvatar2R(BufferedImage[] avatar2r) {
		avatar2R = avatar2r;
	}


	public BufferedImage[] getAvatar2L() {
		return avatar2L;
	}


	public void setAvatar2L(BufferedImage[] avatar2l) {
		avatar2L = avatar2l;
	}


	public BufferedImage[] getAvatar2RU() {
		return avatar2RU;
	}


	public void setAvatar2RU(BufferedImage[] avatar2ru) {
		avatar2RU = avatar2ru;
	}


	public BufferedImage[] getAvatar2LU() {
		return avatar2LU;
	}


	public void setAvatar2LU(BufferedImage[] avatar2lu) {
		avatar2LU = avatar2lu;
	}


	public BufferedImage[] getAvatar3R() {
		return avatar3R;
	}


	public void setAvatar3R(BufferedImage[] avatar3r) {
		avatar3R = avatar3r;
	}


	public BufferedImage[] getAvatar3L() {
		return avatar3L;
	}


	public void setAvatar3L(BufferedImage[] avatar3l) {
		avatar3L = avatar3l;
	}


	public BufferedImage[] getAvatar3RU() {
		return avatar3RU;
	}


	public void setAvatar3RU(BufferedImage[] avatar3ru) {
		avatar3RU = avatar3ru;
	}


	public BufferedImage[] getAvatar3LU() {
		return avatar3LU;
	}


	public void setAvatar3LU(BufferedImage[] avatar3lu) {
		avatar3LU = avatar3lu;
	}


	public BufferedImage[] getAvatar4R() {
		return avatar4R;
	}


	public void setAvatar4R(BufferedImage[] avatar4r) {
		avatar4R = avatar4r;
	}


	public BufferedImage[] getAvatar4L() {
		return avatar4L;
	}


	public void setAvatar4L(BufferedImage[] avatar4l) {
		avatar4L = avatar4l;
	}


	public BufferedImage[] getAvatar4RU() {
		return avatar4RU;
	}


	public void setAvatar4RU(BufferedImage[] avatar4ru) {
		avatar4RU = avatar4ru;
	}


	public BufferedImage[] getAvatar4LU() {
		return avatar4LU;
	}


	public void setAvatar4LU(BufferedImage[] avatar4lu) {
		avatar4LU = avatar4lu;
	}


	/**
	 * 
	 * @return cross
	 */
	public BufferedImage getCross() {
		return cross;
	}
	
	/**
	 * 
	 * @return harmful obstacle
	 */
	public BufferedImage getEnemybox() {
		return enemybox;
	}
	
	/**
	 * 
	 * @return harmless obstacle
	 */
	public BufferedImage getFriendbox() {
		return friendbox;
	}
	
	/**
	 * 
	 * @return	background image
	 */
	public BufferedImage getFloor() {
		return floor;
	}
	
	/**
	 * 
	 * @return point1 image
	 */
	public BufferedImage getPoint1() {
		return point1;
	}
	
	/**
	 * 
	 * @return point3 image
	 */
	public BufferedImage getPoint3() {
		return point3;
	}
	
	/**
	 * 
	 * @return point5 image
	 */
	public BufferedImage getPoint5() {
		return point5;
	}
	
	/**
	 * 
	 * @return floor image
	 */
	public BufferedImage getOnlyfloor() {
		return onlyfloor;
	}

	/**
	 * 
	 * @return ambient sound
	 */
	public AudioStream getBacksound() {
		return backsound;
	}
	
	/**
	 * 
	 * @return point collected sound
	 */
	public AudioStream getPointsound() {
		return pointsound;
	}
	
	/**
	 * 
	 * @return obstacle reaches the ground sound
	 */
	public AudioStream getBoxsound() {
		return boxsound;
	}



}
