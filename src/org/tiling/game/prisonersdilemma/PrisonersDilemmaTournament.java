package org.tiling.game.prisonersdilemma;

import org.tiling.game.*;

import java.beans.Beans;
import java.util.HashSet;
import java.util.Set;

public class PrisonersDilemmaTournament extends RoundRobinTournament {

	public PrisonersDilemmaTournament(Set allPlayers, int length) {
		super(allPlayers, length, PrisonersDilemmaGameFactory.getInstance());
	}

	public static void main(String[] args) {

		try {
			if (args.length != 1) {
				System.err.println("Usage:");
				System.err.println("\tjava PrisonersDilemmaTournament <length>");
				System.exit(1);
			}
			int length = Integer.parseInt(args[0]);
			Set players = new HashSet();
			players.add(PrisonersDilemmaPlayer.instantiate("Random"));
			players.add(PrisonersDilemmaPlayer.instantiate("TitForTat"));
			players.add(PrisonersDilemmaPlayer.instantiate("TitForTwoTats"));
			players.add(PrisonersDilemmaPlayer.instantiate("Joss"));
			players.add(PrisonersDilemmaPlayer.instantiate("RevisedDowning"));
			players.add(PrisonersDilemmaPlayer.instantiate("White"));
			players.add(PrisonersDilemmaPlayer.instantiate("Tester"));
			players.add(PrisonersDilemmaPlayer.instantiate("Friedman"));

			RoundRobinTournament roundRobinTournament = new PrisonersDilemmaTournament(players, length);
			roundRobinTournament.play();
			System.out.println(roundRobinTournament.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}