package org.tiling.game;

public abstract class TwoPlayerGameFactory {
	
	public abstract TwoPlayerGame createGame(Player player1, Player player2, int length);

}