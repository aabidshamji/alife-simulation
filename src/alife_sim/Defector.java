package alife_sim;

class Defector extends Organism {

	Defector(){
		this.energy = 0;
	}

	String getType() {
		return "Defector";
	}


	Organism reproduce() {
		this.energy -= 10;
		return new Defector();
	}


	double getCooperationProbability() {
		return 0;
	}


	boolean cooperates() {
		return false;
	}

}
