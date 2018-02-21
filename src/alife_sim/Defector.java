package alife_sim;

class Defector extends Organism {

	Defector(){
		this.energy = 0;
	}

	/*
	 * @see alife_sim.Organism#getType()
	 */
	String getType() {
		return "Defector";
	}

	/*
	 * @see alife_sim.Organism#reproduce()
	 */
	Organism reproduce() {
		this.energy -= 10;
		return new Defector();
	}

	/*
	 * @see alife_sim.Organism#getCooperationProbability()
	 */
	double getCooperationProbability() {
		return 0;
	}

	/*
	 * @see alife_sim.Organism#cooperates()
	 */
	boolean cooperates() {
		return false;
	}

}
