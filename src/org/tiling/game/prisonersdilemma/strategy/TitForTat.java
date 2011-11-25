package org.tiling.game.prisonersdilemma.strategy;

import org.tiling.game.*;
import org.tiling.game.prisonersdilemma.*;

import java.util.List;

public class TitForTat extends PrisonersDilemmaPlayer {

	public Move generateFirstMove() {
		return C;
	}

	public Move generateMove(Move ownLastMove, Move opponentsLastMove) {
		return opponentsLastMove;
	}

	public String getDescription() {
		return ("Cooperates on first move, does what other player did on previous move thereafter");
	}

}