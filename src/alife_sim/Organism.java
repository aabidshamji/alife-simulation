package alife_sim;

import java.util.Random;

public abstract class Organism {

	protected int energy;
	public Random randomGenerator;

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
	}

	abstract String getType();
	abstract Organism reproduce();
	abstract double getCooperationProbability(); 
	abstract boolean cooperates();

}




