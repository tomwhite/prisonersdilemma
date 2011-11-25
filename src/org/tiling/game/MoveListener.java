package org.tiling.game;

import java.util.EventListener;

public interface MoveListener extends EventListener {
	public void moveCompleted(MoveEvent event);
}
