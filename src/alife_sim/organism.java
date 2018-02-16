package alife_sim;

abstract class Organism {
	
	
	int energy;
	
	public int getEnergy() {
		return this.energy;
	}
	
	public void incrementEnergy() {
		this.energy++;
	}
	
	public void decrementEnergy() {
		this.energy--;
	}

	public void update() {
		incrementEnergy();
		if (this.getEnergy() >= 10) {
			this.reproduce();
		}
	}

	abstract String getType();
	abstract Organism reproduce();
	abstract double getCooperationProbability(); 
	abstract boolean cooperates();
	
	class Cooperator extends Organism {
		
		Cooperator(){
			this.energy = 0;
		}
			
		String getType() {
			return "Cooperator";
		}

		
		Organism reproduce() {
			return new Cooperator();
		}

		
		double getCooperationProbability() {
			return 1;
		}

		
		boolean cooperates() {
			return true;
		}
		
	}
	
	class Defector extends Organism {
		
		Defector(){
			this.energy = 0;
		}
			
		String getType() {
			return "Defector";
		}

		
		Organism reproduce() {
			return new Defector();
		}

		
		double getCooperationProbability() {
			return 0;
		}

		
		boolean cooperates() {
			return false;
		}
		
	}
	
	class PartialCooperator extends Organism {
		
		String getType() {
			return "PartialCooperator";
		}

		
		Organism reproduce() {
			return new PartialCooperator();
		}

		
		double getCooperationProbability() {
			return 0.5;
		}

		
		boolean cooperates() {
			return true;
		}
		
	}
	
}
