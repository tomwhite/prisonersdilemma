package org.tiling.game.prisonersdilemma.ga;

import org.tiling.ga.Chromosome;
import org.tiling.ga.ChromosomeFactory;

public class PrisonersDilemmaChromosomeFactory extends ChromosomeFactory {
	public Chromosome create() {
		return new PrisonersDilemmaChromosome(getCrossoverProbability(), getMutationProbability());
	}
}
