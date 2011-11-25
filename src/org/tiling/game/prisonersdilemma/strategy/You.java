package org.tiling.game.prisonersdilemma.strategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import org.tiling.game.Move;
import org.tiling.game.prisonersdilemma.PrisonersDilemmaPlayer;

public class You extends PrisonersDilemmaPlayer {
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public Move generateFirstMove() {
		return readMove();
	}
	public Move generateMove(Move ownLastMove, Move opponentsLastMove) {
		return readMove();
	}
	public String getDescription() {
		return ("You choose the strategy. Hit the 'C' key to cooperate - or any other to defect.");
	}
	private Move readMove() {
		try {
			String line = in.readLine();
			if (line.startsWith("C") || line.startsWith("c")) {
				return C;
			} else {
				return D;
			}
		} catch (IOException e) {
			return D;
		}
	}
}
