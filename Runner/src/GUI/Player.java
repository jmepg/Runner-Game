package GUI;

public class Player implements Comparable<Player> {

	String nickname;
	int score;
	
	/**
	 * Constructor
	 * 
	 * @param nickname
	 * @param score
	 */
	public Player(String nickname, int score){
		this.nickname = nickname;
		this.score = score;
	}

	/**
	 * 
	 * @return user chosen nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 
	 * @return set user's score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Compares two players' scores
	 * 
	 * @param playerx
	 * 
	 * @return 1 if user's last score is higher than playerx's score, 0 otherwise
	 */
	public int compareTo(Player playerx) {
		int compareScore = playerx.score;
		if (this.score > compareScore)
			return 1;
		else if (this.score == compareScore)
			return 0;
		else return -1;
	}
}
