package org.tiling.game.prisonersdilemma.ga;

import org.tiling.ga.FixedLengthChromosome;

/**
 * A Chromosome whose fitness is computed by playing the iterated prisoners dilemma.
 */
public class PrisonersDilemmaChromosome extends FixedLengthChromosome {

	static char[] alleles = new char[] {'C', 'D'};
	


	public PrisonersDilemmaChromosome(double crossoverProbability, double mutationProbability) {
		super(alleles, 64 + 6, crossoverProbability, mutationProbability);
	}
	
}