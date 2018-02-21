package alife_sim;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * holds a random generator to be passed into the the partial cooperator class as needed
 */
public class Population {
	
	public Random randomGenerator;
	
	/*
	 * CopyOnWriteArrayList to store the organisms so that allows concurrent modification of the list array 
	 */
	CopyOnWriteArrayList<Organism> organismArr = new CopyOnWriteArrayList<Organism>();

	Population(Map<String, Integer> counts, Random randomGenerator) {
		/*
		 * for loop over all the elements in the count map to check that all the keys are valid
		 * @thorws IllegalArgumentException if there is an invalid key
		 */
		for (String key : counts.keySet()) {
			if ( !key.equals("Defector") && !key.equals("Cooperator") && !key.equals("PartialCooperator")) {
				throw new IllegalArgumentException("Invalid key in map: " + key); 
			}
		}
		this.randomGenerator = randomGenerator;
		/*
		 * gets the number of organism of each type to be created from the map
		 */
		int numCooperator = counts.get("Cooperator");
		int numDefector = counts.get("Defector");
		int numPartialCooperator = counts.get("PartialCooperator");
		
		/*
		 * add the specified number of organism to the organismArr
		 */
		addToList(new Cooperator(), numCooperator, organismArr);
		addToList(new Defector(), numDefector, organismArr);
		addToList(new PartialCooperator(randomGenerator), numPartialCooperator, organismArr);
	}
	
	/*
	 * adds num amount of organisms to the given arr by invoking reproduce() method
	 */
	public static void addToList(Organism o, int num, CopyOnWriteArrayList<Organism> arr) {
		while (num > 0) {
			arr.add(o.reproduce());
			num--;
		}
	}
	
	/*
	 * loops through the organismArr and updates each organism.
	 */
	void Update() {
		
		/*
		 * creates iterator to iterate over every element in the array
		 */
		Iterator<Organism> itr = organismArr.iterator();
		
		/*
		 * needed to check that the random index is not the same as the current one
		 */
		int index = 0;
		
		while (itr.hasNext()) {
			Organism curr = itr.next();
			/*
			 * If the energy of the organism is greater or equal to 10, the organism reproduces and replaces a random organism in the array
			 */
			if (curr.getEnergy() >= 10) {
				Organism newOrg = curr.reproduce();
				int repLoc = randomGenerator.nextInt(organismArr.size());
				organismArr.set(repLoc, newOrg);
				/*
				 * else, increments its own energy value
				 */
			} else {
				curr.incrementEnergy();
				/*
				 * if the organism cooperates, it will give 8 other organisms one energy value and decrement its own by one 
				 */
				if (curr.cooperates()) {
					for (int i = 0; i < 8; i++) {
						int repLoc;
						/*
						 * gets a random index in the array that is not the same as their own and replaces that organism
						 */
						do {
							repLoc = randomGenerator.nextInt(organismArr.size());
						} while (repLoc == index);
						organismArr.get(repLoc).incrementEnergy();
					}
					curr.decrementEnergy();
				}
			}
			index++;
		}

	}
	
	/*
	 * loops through organismArr and sums all the cooperation probabilities
	 * 
	 * @return double : the average cooperation probability (sum / by total number of organism in the array)
	 * 
	 */
	double calculateCooperationMean() {
		Iterator<Organism> itr = organismArr.iterator();
		double total = 0;

		while (itr.hasNext()) {
			total += itr.next().getCooperationProbability();
		}
		return total / (double) organismArr.size();
	}
	
	/*
	 * @return Map : a map the key value pairs of organism types and counts from the array
	 */
	Map<String, Integer> getPopulationCounts() {
		Map<String, Integer> counts = new  HashMap<String, Integer>();
		
		Iterator<Organism> itr = organismArr.iterator();
		int countCooperator = 0;
		int countDefector = 0;
		int countPartialCooperator = 0;
		
		while (itr.hasNext()) {
			Organism curr = itr.next();
			if (curr.getType().equals("Cooperator")) {
				countCooperator++;
			}
			else if (curr.getType().equals("Defector")) {
				countDefector++;
			}
			else if (curr.getType().equals("PartialCooperator")) {
				countPartialCooperator++;
			}
		}
		
		counts.put("Cooperator", countCooperator);
		counts.put("Defector", countDefector);
		counts.put("PartialCooperator", countPartialCooperator);
		
		return counts;
		
	}
	
}
