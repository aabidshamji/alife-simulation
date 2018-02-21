package alife_sim;

class Cooperator extends Organism {

	/*
	 * creates a new cooperator with an energy of 0
	 */
	Cooperator(){
		this.energy = 0;
	}

	/*
	 * @see alife_sim.Organism#getType()
	 */
	String getType() {
		return "Cooperator";
	}

	/*
	 * @see alife_sim.Organism#reproduce()
	 */
	Organism reproduce() {
		this.energy -= 10;
		return new Cooperator();
	}

	/*
	 * @see alife_sim.Organism#getCooperationProbability()
	 */
	double getCooperationProbability() {
		return 1;
	}

	/*
	 * @see alife_sim.Organism#cooperates()
	 */
	boolean cooperates() {
		return true;
	}

}