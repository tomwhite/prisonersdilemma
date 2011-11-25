package org.tiling.game.prisonersdilemma.strategy;

import org.tiling.game.*;
import org.tiling.game.prisonersdilemma.*;

import java.util.List;

public class TitForTwoTats extends Player {

	public Move generateMove(List ownMoveHistory, List opponentsMoveHistory) {
		if (opponentsMoveHistory.size() > 1 &&
				opponentsMoveHistory.get(opponentsMoveHistory.size() - 1) == PrisonersDilemmaMove.D &&
				opponentsMoveHistory.get(opponentsMoveHistory.size() - 2) == PrisonersDilemmaMove.D) {
			return PrisonersDilemmaMove.D;
		} else {
			return PrisonersDilemmaMove.C;
		}
	}

	public String getDescription() {
		return ("Defects only if the opponent defected on the previous two moves.");
	}

}