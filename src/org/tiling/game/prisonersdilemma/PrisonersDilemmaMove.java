package org.tiling.game.prisonersdilemma;

import org.tiling.game.*;

public class PrisonersDilemmaMove extends Move {

	public final static PrisonersDilemmaMove C = new PrisonersDilemmaMove("C");
	public final static PrisonersDilemmaMove D = new PrisonersDilemmaMove("D");
	private String marker;

	private PrisonersDilemmaMove(String marker) {
		this.marker = marker;
	}

	public String toString() {
		return marker;
	}

}