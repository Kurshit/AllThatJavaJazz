package com.kurshit.DS.companyproblems.goldmansachs;

import java.util.HashMap;
import java.util.Map;

public class AverageMarks {
	
	public static void printAverageMarks(String[][] students) {
		
		Map<String,Integer> marks = new HashMap<>();
		Map<String,Integer> occurences = new HashMap<>();
		
		
		
		for(String[] s: students) {
			
			if(marks.containsKey(s[0]) && occurences.containsKey(s[0])) {
				
				marks.computeIfPresent(s[0], (key,value) -> value + Integer.parseInt(s[1]));
				occurences.computeIfPresent(s[0], (key,value) -> value + 1);								
			} else {
				marks.put(s[0], Integer.parseInt(s[1]));
				occurences.put(s[0], 1);
			}
			
		}
		
		int maxAvg = Integer.MIN_VALUE;
		String name = "";
		
		for(String s : marks.keySet()) {
			
			int avg = marks.get(s) / occurences.get(s);
			
			if(avg > maxAvg) {
				name = s;
				maxAvg = avg;
			}
			
		}
		
		System.out.println(name + " " + maxAvg);
		
	}
	

	public static void main(String[] args) {
		
		/*String s[][] = {{"jerry","65"},
                {"bob","82"}, {"jerry","23"}, {"Eric","83"},{"bob","83"}};
		*/
		
		String s[][] = {{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}};
		
		printAverageMarks(s);

	}

}
