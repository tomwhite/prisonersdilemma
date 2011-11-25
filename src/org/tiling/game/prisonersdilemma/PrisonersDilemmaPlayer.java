package org.tiling.game.prisonersdilemma;

import org.tiling.game.*;

import java.beans.Beans;
import java.io.IOException;
import java.util.List;

public abstract class PrisonersDilemmaPlayer extends Player implements PrisonersDilemmaMoves {

	public static Player instantiate(String shortName) throws InstantiationException, ClassNotFoundException, IOException {
		return (Player) Beans.instantiate(null, "org.tiling.game.prisonersdilemma.strategy." + shortName);
	}

	public Move generateMove(List ownMoveHistory, List opponentsMoveHistory) {
		if (ownMoveHistory.isEmpty()) {
			return generateFirstMove();
		} else {
			return generateMove((Move) ownMoveHistory.get(opponentsMoveHistory.size() - 1),
							(Move) opponentsMoveHistory.get(opponentsMoveHistory.size() - 1));
		}
	}

	public abstract Move generateFirstMove();

	public abstract Move generateMove(Move ownLastMove, Move opponentsLastMove);

}