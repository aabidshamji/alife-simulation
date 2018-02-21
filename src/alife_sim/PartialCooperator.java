package alife_sim;

import java.util.Random;

class PartialCooperator extends Organism {

	PartialCooperator(Random randomGenerator) {
		this.energy = 0;
		this.randomGenerator = randomGenerator;
	}
	
	String getType() {
		return "PartialCooperator";
	}


	Organism reproduce() {
		this.energy -= 10;
		return new PartialCooperator(this.randomGenerator);
	}


	double getCooperationProbability() {
		return 0.5;
	}


	boolean cooperates() {
		int luck = randomGenerator.nextInt(2);
		if (luck == 1) 
			return false;
		else
			return true;
	}

}