package org.tiling.game.prisonersdilemma;

import org.tiling.game.*;

public class PrisonersDilemmaGameFactory extends TwoPlayerGameFactory {

	private static PrisonersDilemmaGameFactory instance = new PrisonersDilemmaGameFactory();

	private PrisonersDilemmaGameFactory() {
	}

	public static TwoPlayerGameFactory getInstance() {
		return instance;
	}

	public TwoPlayerGame createGame(Player player1, Player player2, int length) {
		return new PrisonersDilemmaGame(player1, player2, length);
	}

}