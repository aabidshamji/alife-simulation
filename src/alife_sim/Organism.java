package alife_sim;

import java.util.Random;

/*
 * abstract class for arganism. 
 * 
 * Implements methods to get energy, increment, decrement and update. 
 * 
 * @author Martin Toney
 * @author Aabid Shamji
 * 
 */
public abstract class Organism {

	protected int energy;
	public Random randomGenerator;
	
	/*
	 * @return the energy of the organism 
	 */
	public int getEnergy() {
		return this.energy;
	}
	
	/*
	 * @param void 
	 * @return void
	 * 
	 * increases the energy level of the organism by 1
	 * 
	 */
	public void incrementEnergy() {
		this.energy++;
	}
	/*
	 * @param void 
	 * @return void
	 * 
	 * decreases the energy level of the organism by 1
	 * 
	 */
	public void decrementEnergy() {
		this.energy--;
	}

	/*
	 * @param void 
	 * @return void
	 * 
	 * updates the organism's energy level
	 * 
	 */
	public void update() {
		incrementEnergy();
	}

	/*
	 * @return String : the type of the organism. Options are cooperator, defector, partial cooperator 
	 */
	abstract String getType();
	
	/*
	 * returns Organism : returns a new organism of the same type that they method is called on
	 */
	abstract Organism reproduce();
	
	/*
	 * returns double : Cooperation Probability of the organism. (0.0 for defectors, 1.0 for cooperators, 0.5 for partial cooperators)
	 */
	abstract double getCooperationProbability();
	
	/*
	 * returns boolean : true of the organism cooperates, false otherwise. For partial cooperators returns a random boolean each time the method is called. 
	 */
	abstract boolean cooperates();

}




