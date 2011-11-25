package org.tiling.game.prisonersdilemma.strategy;

import org.tiling.game.*;
import org.tiling.game.prisonersdilemma.*;

import java.util.List;

public class RevisedDowning extends Player {

	float good;
	float bad;

	Move past;
	int totalC;
	int totalD;

	int nice1;
	int nice2;

	public Move generateMove(List ownMoveHistory, List opponentsMoveHistory) {

		if (ownMoveHistory.isEmpty()) {
			good = 1.0f; // probability that other player cooperates after I cooperate
			bad = 0.0f; // probability that other player cooperates after I defect

			past = PrisonersDilemmaMove.C; // own last move
			totalC = 0;
			totalD = 0;

			nice1 = 0; // number of opponent C when I C
			nice2 = 0; // number of opponent C when I D			
		} else if (ownMoveHistory.size() > 1) {

			past = (Move) ownMoveHistory.get(ownMoveHistory.size() - 1);
			Move opponentsLastMove = (Move) opponentsMoveHistory.get(opponentsMoveHistory.size() - 1);

			if (past == PrisonersDilemmaMove.D) {
				// 3
				if (opponentsLastMove == PrisonersDilemmaMove.C) {
					nice2++;
				}
				totalD++;
				bad = ((float) nice2) / totalD;
			} else {
				// 2
				if (opponentsLastMove == PrisonersDilemmaMove.C) {
					nice1++;
				}
				totalC++;
				good = ((float) nice1) / totalC;
			}
		}

		// 4
		double c = 6.0 * good - 8.0 * bad - 2.0;
		double alt = 4.0 * good - 5.0 * bad - 1.0;
		if (c >= 0.0 && c >= alt) {
			return PrisonersDilemmaMove.C;
		} else if ((c >= 0.0 && c < alt) || alt >= 0.0) {
			return past == PrisonersDilemmaMove.C ? PrisonersDilemmaMove.D : PrisonersDilemmaMove.C;
		} else {
			return PrisonersDilemmaMove.D;
		}

	}

	public String getDescription() {
		return ("RevisedDowning");
	}

}