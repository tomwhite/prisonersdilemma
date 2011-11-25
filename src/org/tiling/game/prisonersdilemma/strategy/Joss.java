package org.tiling.game.prisonersdilemma.strategy;

import org.tiling.game.*;
import org.tiling.game.prisonersdilemma.*;

import java.util.List;
import java.util.Random;

public class Joss extends PrisonersDilemmaPlayer {

	Random random = new Random();

	public Move generateFirstMove() {
		return C;
	}

	public Move generateMove(Move ownLastMove, Move opponentsLastMove) {
		if (opponentsLastMove == C) {
			// defect 10% of the time
			return random.nextInt(10) == 0 ? D : C;
		} else {
			return D;
		}
	}

	public String getDescription() {
		return ("Cooperates on first move, normally does what other player did on previous move thereafter - except defects 10% of the time when it would have cooperated.");
	}


}