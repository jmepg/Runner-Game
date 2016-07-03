package LOGIC;

import java.awt.Rectangle;
import java.util.LinkedList;

public class Physics {

	/**
	 * Checks for collisions between the avatar and the onscreen boxes
	 * 
	 * @param avatar
	 * @param listbox
	 * @return true if there is a collision, false otherwise
	 */
	public static boolean Collision (Avatar avatar, LinkedList<Box> listbox){
		for (int i = 0; i < listbox.size(); i++){
			if (avatar.getBounds().intersects(listbox.get(i).getBounds()))
				return true;
		}
		return false;
	}

	/**
	 * Checks for collisions between the avatar and the floor,
	 * so that when climbing down a stack of boxes the avatar
	 * doesn't go through the ground
	 * 
	 * @param avatar
	 * @param floor
	 * @return true if there is a collision, false otherwise
	 */
	public static boolean Collision (Avatar avatar, int[] floor){
		for (int i = 0; i < floor.length; i++){
			Rectangle rec = new Rectangle(i * 50, (10 - floor[i]) * 50, 50, floor[i]*50);
			if (avatar.getBounds().intersects(rec))
				return true;
		}
		return false;
	}
	
	/**
	 * Checks for collisions between scorepoints and boxes,
	 * so that the point disappear of his list, if that is the case
	 * 
	 * @param listbox
	 * @param point
	 * @return true if there is a collision, false otherwise
	 */
	public static boolean Collision (LinkedList<Box> listbox, ScorePoint point){
		for (int i = 0; i < listbox.size(); i++){
				if (point.getBounds().intersects(listbox.get(i).getBounds()))
					if (point.getVelY() == 0)
						return true;
			}
		return false;		
	}
	
	/**
	 * Checks for collisions between the avatar and points, 
	 * so that points can be collected
	 * 
	 * @param point
	 * @param avatar
	 * @return true if there is a collision, false otherwise
	 */
	public static boolean Collision (ScorePoint point, Avatar avatar){
			if (avatar.getBounds().intersects(point.getBounds()))
				return true;
		return false;
	}
	
}
