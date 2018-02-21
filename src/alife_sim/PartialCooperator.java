package alife_sim;

import java.util.Random;

class PartialCooperator extends Organism {
	
	/*
	 * passes in a random generator so that cooperates(); can return random boolean
	 */
	PartialCooperator(Random randomGenerator) {
		this.energy = 0;
		this.randomGenerator = randomGenerator;
	}
	
	/*
	 * @see alife_sim.Organism#getType()
	 */
	String getType() {
		return "PartialCooperator";
	}

	/*
	 * @see alife_sim.Organism#reproduce()
	 */
	Organism reproduce() {
		this.energy -= 10;
		return new PartialCooperator(this.randomGenerator);
	}

	/*
	 * @see alife_sim.Organism#getCooperationProbability()
	 */
	double getCooperationProbability() {
		return 0.5;
	}

	/*
	 * @see alife_sim.Organism#cooperates()
	 */
	boolean cooperates() {
		int luck = randomGenerator.nextInt(2);
		if (luck == 1) 
			return false;
		else
			return true;
	}

}