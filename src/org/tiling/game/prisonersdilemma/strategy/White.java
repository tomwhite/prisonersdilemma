package org.tiling.game.prisonersdilemma.strategy;

import org.tiling.game.*;
import org.tiling.game.prisonersdilemma.*;

import java.util.List;

public class White extends PrisonersDilemmaPlayer {

	int opponentDefectRun;

	public Move generateFirstMove() {
		opponentDefectRun = 0;
		return C;
	}

	public Move generateMove(Move ownLastMove, Move opponentsLastMove) {
		if (opponentsLastMove == C) {
			if (opponentDefectRun <= 1) {
				opponentDefectRun = 0;
				return C;
			} else {
				opponentDefectRun = 0;
				return D;
			}
		} else { // D
			opponentDefectRun++;
			return D;
		}
	}

	public String getDescription() {
		return ("Like TitForTat but punishes with an extra defection for runs of two defections or more.");
	}

}