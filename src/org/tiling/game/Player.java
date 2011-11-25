package org.tiling.game;

import java.io.Serializable;

public abstract class Player implements Strategy, Cloneable, Serializable, Comparable {

	int score = 0;

	int gamesPlayed = 0;

	public Player() {
	}

	public void addScore(int score) {
		this.score += score;
	}

	public int getScore() {
		return score;
	}

	public void incrementGamesPlayed() {
		gamesPlayed++;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public float getMeanScore() {
		return ((float) score) / gamesPlayed;
	}

	public String toString() {
		String name = this.getClass().getName();
		return name.substring(name.lastIndexOf('.') + 1);
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	public int compareTo(Object obj) {
		Player player = (Player) obj;
		return new Float(getMeanScore()).compareTo(new Float(player.getMeanScore()));
	}

}