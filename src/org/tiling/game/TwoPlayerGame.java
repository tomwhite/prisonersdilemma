package org.tiling.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class TwoPlayerGame {

	private Player player1, player2;
	private int N;

	private List player1MoveHistory, player2MoveHistory;

	public TwoPlayerGame(Player player1, Player player2, int length) {
		this.player1 = player1;
		this.player2 = player2;
		this.N = length;
	}

	public abstract boolean isZeroSum();
	public abstract int getPayoff(Move player1, Move player2);

	public void play() {

		player1MoveHistory = new ArrayList();
		player2MoveHistory = new ArrayList();

		for (int n = 0; n < N; n++) {

			Move player1Move = player1.generateMove(player1MoveHistory, player2MoveHistory);
			if (moveListener != null) {
				moveListener.moveCompleted(new MoveEvent(this, player1, player1Move));
			}
			Move player2Move = player2.generateMove(player2MoveHistory, player1MoveHistory);
			if (moveListener != null) {
				moveListener.moveCompleted(new MoveEvent(this, player2, player2Move));
			}

			player1MoveHistory.add(player1Move);
			player2MoveHistory.add(player2Move);

			player1.addScore(getPayoff(player1Move, player2Move));
			player2.addScore(getPayoff(player2Move, player1Move));

		}

		player1.incrementGamesPlayed();
		player2.incrementGamesPlayed();

	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(". ");
		for (Iterator i = player1MoveHistory.iterator(); i.hasNext(); ) {
			buf.append(i.next());
		}
		buf.append(", Score ");
		buf.append(player1.getScore());
		buf.append(", ");
		buf.append(player1.toString());
		buf.append('\n');
		buf.append("  ");
		for (Iterator i = player2MoveHistory.iterator(); i.hasNext(); ) {
			buf.append(i.next());
		}
		buf.append(", Score ");
		buf.append(player2.getScore());
		buf.append(", ");
		buf.append(player2.toString());
		return buf.toString();
	}

	private MoveListener moveListener;	public void setMoveListener(MoveListener moveListener) {
		this.moveListener = moveListener;
	}}