package org.tiling.game.prisonersdilemma.ga;

import org.tiling.ga.Chromosome;
import org.tiling.ga.Environment;

import org.tiling.game.Player;
import org.tiling.game.RoundRobinTournament;

import org.tiling.game.prisonersdilemma.PrisonersDilemmaTournament;

import org.tiling.game.prisonersdilemma.strategy.GAEncoded;

import java.util.*;

/**
 * An Environment in which players compete by playing a tournament of the iterated prisoners dilemma.
 */
public class PrisonersDilemmaTournamentEnvironment implements Environment {

	public void calculateFitnessValues(Chromosome[] individuals) {
		Player[] players = new Player[individuals.length];
		for (int i = 0; i < individuals.length; i++) {
			players[i] = new GAEncoded(individuals[i].toString());
		}
		RoundRobinTournament roundRobinTournament = new PrisonersDilemmaTournament(new HashSet(Arrays.asList(players)), 100);
		roundRobinTournament.play();
		for (int i = 0; i < individuals.length; i++) {
			individuals[i].setFitness(players[i].getScore());
		}
	}

}