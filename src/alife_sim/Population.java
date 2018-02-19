package alife_sim;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Population {
	
	CopyOnWriteArrayList<Organism> organismArr = new CopyOnWriteArrayList<Organism>();
	
	Population(Map<String, Integer> counts) throws IllegalArgumentException {
		
		for (String key : counts.keySet()) {
			if (key != "Cooperator" || key != "Defector" || key != "PartialCooperator") {
				throw new IllegalArgumentException("Invalid key in map: " + key);
			}
		}
		
		int numCooperator = counts.get("Cooperator");
		int numDefector = counts.get("Defector");
		int numPartialCooperator = counts.get("PartialCooperator");
		
		addToList(new Cooperator(), numCooperator, organismArr);
		addToList(new Defector(), numDefector, organismArr);
		addToList(new PartialCooperator(), numPartialCooperator, organismArr);
	}
	
	
	public static void addToList(Organism o, int num, CopyOnWriteArrayList<Organism> arr) {
		while (num > 0) {
			arr.add(o.reproduce());
			num--;
		}
	}
	
	void Update() {
		Random randomGenerator = new Random();
		Iterator<Organism> itr = organismArr.iterator();
		
		while (itr.hasNext()) {
			if (itr.next().getEnergy() >= 10) {
				Organism newOrg = itr.next().reproduce();
				int repLoc = randomGenerator.nextInt(organismArr.size());
				organismArr.set(repLoc, newOrg);
			} else {
				itr.next().incrementEnergy();
			}
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
			if (itr.next().getType().equals("Cooperator")) {
				countCooperator++;
			}
			else if (itr.next().getType().equals("Defector")) {
				countDefector++;
			}
			else if (itr.next().getType().equals("PartialCooperator")) {
				countPartialCooperator++;
			}
		}
		
		counts.put("Cooperator", countCooperator);
		counts.put("Defector", countDefector);
		counts.put("PartialCooperator", countPartialCooperator);
		
		return counts;
		
	}
	
}
