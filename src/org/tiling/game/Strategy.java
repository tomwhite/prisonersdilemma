package org.tiling.game;

import java.util.List;

public interface Strategy {

	public Move generateMove(List ownMoveHistory, List opponentsMoveHistory);

	public String getDescription();

}