package alife_sim;

abstract class Organism {

	String type;
	int energy;
	boolean cooperates;
	int cooperationProbability;
	
	Organism() {
		
	}
	
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

		@Override
		String getType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		Organism reproduce() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		double getCooperationProbability() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		boolean cooperates() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	class Defector extends Organism {

		@Override
		String getType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		Organism reproduce() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		double getCooperationProbability() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		boolean cooperates() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	class PartialCooperator extends Organism {

		@Override
		String getType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		Organism reproduce() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		double getCooperationProbability() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		boolean cooperates() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
}
