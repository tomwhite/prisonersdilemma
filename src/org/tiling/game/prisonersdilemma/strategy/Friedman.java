package org.tiling.game.prisonersdilemma.strategy;

import org.tiling.game.*;
import org.tiling.game.prisonersdilemma.*;

import java.util.List;

public class Friedman extends PrisonersDilemmaPlayer {

	boolean opponentHasDefected;

	public Move generateFirstMove() {
		opponentHasDefected = false;
		return C;
	}

	public Move generateMove(Move ownLastMove, Move opponentsLastMove) {
		if (opponentsLastMove == D) {
			opponentHasDefected = true;
		}
		if (opponentHasDefected) {
			return D;
		} else {
			return C;
		}
	}

	public String getDescription() {
		return ("Cooperates unless other player defects in which case defects from then on.");
	}

}