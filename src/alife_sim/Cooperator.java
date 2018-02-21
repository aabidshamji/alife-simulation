package alife_sim;

class Cooperator extends Organism {

	Cooperator(){
		this.energy = 0;
	}

	String getType() {
		return "Cooperator";
	}


	Organism reproduce() {
		this.energy -= 10;
		return new Cooperator();
	}


	double getCooperationProbability() {
		return 1;
	}


	boolean cooperates() {
		return true;
	}

}