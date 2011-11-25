package org.tiling.game.prisonersdilemma;

import org.tiling.game.*;

import org.tiling.game.prisonersdilemma.strategy.You;public class PrisonersDilemmaGame extends TwoPlayerGame {

	public final static int T = 5; // Temptation for defection
	public final static int R = 3; // Reward for mutual cooperation
	public final static int P = 1; // Punishment for mutual defection
	public final static int S = 0; // Sucker's payoff for cooperation with a defector

	public PrisonersDilemmaGame(Player player1, Player player2, int length) {
		super(player1, player2, length);
	}

	public boolean isZeroSum() {
		return false;
	}

	// N.B this returns the payoff for player 1 (reverse arguments for player 2)
	public int getPayoff(Move player1, Move player2) {

		if (player1 == PrisonersDilemmaMove.D && player2 == PrisonersDilemmaMove.C)
			return T;
		if (player1 == PrisonersDilemmaMove.C && player2 == PrisonersDilemmaMove.C)
			return R;
		if (player1 == PrisonersDilemmaMove.D && player2 == PrisonersDilemmaMove.D)
			return P;
		if (player1 == PrisonersDilemmaMove.C && player2 == PrisonersDilemmaMove.D)
			return S;

		return 0;

	}


	public static void main(String[] args) {

		if (args.length != 3) {
			System.err.println("Usage:");
			System.err.println("\tjava PrisonersDilemmaGame <player1> <player2> <gameLength>");
			System.exit(1);
		}

		try {
			Player player1 = PrisonersDilemmaPlayer.instantiate(args[0]);
			Player player2 = PrisonersDilemmaPlayer.instantiate(args[1]);
			int gameLength = Integer.parseInt(args[2]);

			PrisonersDilemmaGame pd;
			if (player2 instanceof You) {
				pd = new PrisonersDilemmaGame(player2, player1, gameLength);
				pd.setMoveListener(new EchoMoveListener(player2, player1));
			} else {
				pd = new PrisonersDilemmaGame(player1, player2, gameLength);
				pd.setMoveListener(new EchoMoveListener(player1, player2));
			}
			pd.play();

			System.out.println(pd.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected static class EchoMoveListener implements MoveListener {
		private Player player1, player2;
		public EchoMoveListener(Player player1, Player player2) {
			this.player1 = player1;
			this.player2 = player2;
		}
		public void moveCompleted(MoveEvent event) {
			if (event.getPlayer() == player1) {
				System.out.print("\t" + event.getMove());
			} else {
				System.out.println(" " + event.getMove());
			}
		}
	}}