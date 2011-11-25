package org.tiling.game.prisonersdilemma.strategy;

import org.tiling.game.*;
import org.tiling.game.prisonersdilemma.*;

import java.util.List;

public class GAEncoded extends Player implements PrisonersDilemmaMoves {

	String chromosomeString;

	public GAEncoded(String chromosomeString) {
		if (chromosomeString.length() != 70) {
			throw new IllegalArgumentException("Invalid chromosome string length");
		}
		this.chromosomeString = chromosomeString;
	}

	public Move generateMove(List ownMoveHistory, List opponentsMoveHistory) {

		if (ownMoveHistory.isEmpty()) {  // pre-populate with three hypothetical previous games
			int firstGamePosition = 64;
			ownMoveHistory.add(      (chromosomeString.charAt(firstGamePosition++) == 'C') ? C : D);
			opponentsMoveHistory.add((chromosomeString.charAt(firstGamePosition++) == 'C') ? C : D);
			ownMoveHistory.add(      (chromosomeString.charAt(firstGamePosition++) == 'C') ? C : D);
			opponentsMoveHistory.add((chromosomeString.charAt(firstGamePosition++) == 'C') ? C : D);
			ownMoveHistory.add(      (chromosomeString.charAt(firstGamePosition++) == 'C') ? C : D);
			opponentsMoveHistory.add((chromosomeString.charAt(firstGamePosition++) == 'C') ? C : D);
		}

		// Look at previous three moves to decide on move...
		int encoding = 0;
		encoding |= ((Move) opponentsMoveHistory.get(opponentsMoveHistory.size() - 1) == D) ? 1 << 0 : 0;
		encoding |= ((Move) ownMoveHistory.get(ownMoveHistory.size() - 1) == D)             ? 1 << 1 : 0;
		encoding |= ((Move) opponentsMoveHistory.get(opponentsMoveHistory.size() - 2) == D) ? 1 << 2 : 0;
		encoding |= ((Move) ownMoveHistory.get(ownMoveHistory.size() - 2) == D)             ? 1 << 3 : 0;
		encoding |= ((Move) opponentsMoveHistory.get(opponentsMoveHistory.size() - 3) == D) ? 1 << 4 : 0;
		encoding |= ((Move) ownMoveHistory.get(ownMoveHistory.size() - 3) == D)             ? 1 << 5 : 0;

		return (chromosomeString.charAt(encoding) == 'C') ? C : D;
	}

	public String getDescription() {
		return ("Encoded by a chromosome " + chromosomeString);
	}

	public boolean isNice() {
		// I am nice (I am not the first to defect) iff

		// 1. I am nice for the three hypothetical previous games
		// i.e. I am not the first to defect

		for (int i = 64; i <= 70; i++) {
			if (chromosomeString.charAt(i) == 'D') {
				if (i % 2 == 0) {
					return false;
				} else {
					break;
				}
			}
		}

		// and
		// 2. all alleles at even indices of the string are C
		// i.e. given that the opponents last move was C, I play C

		for (int i = 0; i < 64; i += 2) {
			if (chromosomeString.charAt(i) == 'D') {
				return false;
			}
		}
		return true;
	}

}