package org.tiling.game.prisonersdilemma.strategy;

import org.tiling.game.*;
import org.tiling.game.prisonersdilemma.*;

import java.util.List;

public class Random extends Player {

	java.util.Random random = new java.util.Random();

	public Move generateMove(List ownMoveHistory, List opponentsMoveHistory) {
		return random.nextBoolean() ? PrisonersDilemmaMove.C : PrisonersDilemmaMove.D;
	}

	public String getDescription() {
		return ("Cooperates or defects with equal probability.");
	}

}