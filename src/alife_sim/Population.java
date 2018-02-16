package alife_sim;
import java.util.HashMap;
import java.util.Map;

public class Population {
	
	Population(Map<String, Integer> counts) throws IllegalArgumentException {
		counts.put("name", 0);
	}
	
	void Update() {
		
	}
	
	double calculateCooperationMean() {
		return 0.0;
	}
	
	Map<String, Integer> getPopulationCounts() {
		Map<String, Integer> counts = new  HashMap<String, Integer>();
		return counts; 
	}
	
}
