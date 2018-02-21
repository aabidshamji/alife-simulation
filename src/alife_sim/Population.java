package alife_sim;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Population {
	
	public Random randomGenerator;
	
	CopyOnWriteArrayList<Organism> organismArr = new CopyOnWriteArrayList<Organism>();
	
	Population(Map<String, Integer> counts, Random randomGenerator) throws IllegalArgumentException {
		for (String key : counts.keySet()) {
			if ( !key.equals("Defector") && !key.equals("Cooperator") && !key.equals("PartialCooperator")) {
				throw new IllegalArgumentException("Invalid key in map: " + key); 
			}
		}
		this.randomGenerator = randomGenerator;
		int numCooperator = counts.get("Cooperator");
		int numDefector = counts.get("Defector");
		int numPartialCooperator = counts.get("PartialCooperator");
		
		addToList(new Cooperator(), numCooperator, organismArr);
		addToList(new Defector(), numDefector, organismArr);
		addToList(new PartialCooperator(randomGenerator), numPartialCooperator, organismArr);
	}
	
	
	public static void addToList(Organism o, int num, CopyOnWriteArrayList<Organism> arr) {
		while (num > 0) {
			arr.add(o.reproduce());
			num--;
		}
	}

	void Update() {

		Iterator<Organism> itr = organismArr.iterator();
		int index = 0;
		
		while (itr.hasNext()) {
			Organism curr = itr.next();
			if (curr.getEnergy() >= 10) {
				Organism newOrg = curr.reproduce();
				int repLoc = randomGenerator.nextInt(organismArr.size());
				organismArr.set(repLoc, newOrg);
			} else {
				curr.incrementEnergy();
				if (curr.cooperates()) {
					for (int i = 0; i < 8; i++) {
						int repLoc;
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

	double calculateCooperationMean() {
		Iterator<Organism> itr = organismArr.iterator();
		int count = 0;
		double total = 0;

		while (itr.hasNext()) {
			count++;
			total += itr.next().getCooperationProbability();
		}
		return total / count;
	}
	
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
