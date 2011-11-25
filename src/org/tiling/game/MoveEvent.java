package org.tiling.game;

import java.util.EventObject;

public class MoveEvent extends EventObject {
	private Player player;
	private Move move;
	public MoveEvent(TwoPlayerGame game, Player player, Move move) {
		super(game);
		this.player = player;
		this.move = move;
	}
	public Move getMove() {
		return move;
	}
	public Player getPlayer() {
		return player;
	}
}
