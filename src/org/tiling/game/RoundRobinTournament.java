package org.tiling.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public class RoundRobinTournament {

	Player[] players;
	int gameLength;
	TwoPlayerGameFactory twoPlayerGameFactory;

	public RoundRobinTournament(Set players, int gameLength, TwoPlayerGameFactory twoPlayerGameFactory) {
		this.players = (Player[]) players.toArray(new Player[0]);
		this.gameLength = gameLength;
		this.twoPlayerGameFactory = twoPlayerGameFactory;
	}

	public void play() {

		for (int i = 0; i < players.length; i++) {

			// First each player plays a clone of themselves
			TwoPlayerGame game = twoPlayerGameFactory.createGame(players[i], (Player) players[i].clone(), gameLength);
			game.play();

			// Then play all the other opponents who have not been played
			for (int j = 0; j < i; j++) {
				game = twoPlayerGameFactory.createGame(players[i], players[j], gameLength);
				game.play();
			}
		}

	}

/*
	public Player[] getRankedPlayers() {
		Arrays.sort(players, Collections.reverseOrder());
	}
*/

	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < players.length; i++) {
			Player player = players[i];
			buf.append(player);
			buf.append(' ');
			buf.append(player.getMeanScore());
			buf.append('\n');
		}
		return buf.toString();
	}

}