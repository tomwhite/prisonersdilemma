package org.tiling.game.prisonersdilemma.strategy;

import org.tiling.game.*;
import org.tiling.game.prisonersdilemma.*;

import java.util.List;

public class Tester extends PrisonersDilemmaPlayer {

	boolean patsy;
	int dc;
	int mdc;
	Move g;

	public Move generateFirstMove() {
		patsy = true;
		dc = 0;
		mdc = 0;
		g = D;
		return D;
	}

	public Move generateMove(Move ownLastMove, Move opponentsLastMove) {
		if (!patsy) {
			// 1
			return opponentsLastMove;
		} else if (opponentsLastMove == D) {
			// 2
			patsy = false;
			return C;
		} else {
			// 3
			dc++;
			if (g == C) {
				mdc++;
			}
			g = (((float) mdc) / (dc + 1) >= 0.5) ? D : C;
			return g;
		}
	}

	public String getDescription() {
		return ("Defects on first move, if other player ever defects it cooperates then plays TitForTat for rest of game, otherwise cooperate on second and third moves and defect on subsequent alternate moves.");
	}

}