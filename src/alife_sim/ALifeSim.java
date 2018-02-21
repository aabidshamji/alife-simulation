package alife_sim;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ALifeSim {
	
	public static void main(String[] args) {
		if (args.length != 4) {
			System.out.println("Incorrect Ussage. Correct Usage: java ALifeSim <#/iterations> <#/cooperators> <#/defectors> <#/partial cooperators>");
			System.exit(1);
		}
		int iterations = Integer.parseInt(args[0]);
		int countCooperator = Integer.parseInt(args[1]);
		int countDefector = Integer.parseInt(args[2]);
		int countPartialCooperator = Integer.parseInt(args[3]);
		
		Map<String, Integer> counts = new HashMap<String, Integer>();
		
		counts.put("Cooperator", countCooperator);
		counts.put("Defector", countDefector);
		counts.put("PartialCooperator", countPartialCooperator);
		
		Random randomGenerator = new Random(1);
		
		Population pop = new Population(counts, randomGenerator);
		
		for (int i = 0; i < iterations; i++) {
			pop.Update();
		}
		
		Map<String, Integer> newCounts = pop.getPopulationCounts();
		double MCP = pop.calculateCooperationMean();
		
		newCounts.forEach((key, value)-> System.out.println(key + " = " + value));
		System.out.println("Mean Cooperation Probability = " + MCP);
		
	}
	
}
