package com.kurshit.DS.companyproblems.goldmansachs;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, find the first non-repeating character in it. 
 * For example, if the input string is “GeeksforGeeks”, then output should be ‘f’ and if input string is “GeeksQuiz”, 
 * then output should be ‘G’. 
 */

public class FirstUniqueCharacterInString {
	
	public static int[] COUNT = new int[256];
	
	/*
	 * Approach 1 : 1) Scan the string from left to right and construct the count array.
	 * 2) Again, scan the string from left to right and check for count of each
	 *  character, if you find an element who's count is 1, return it.
	 */
	
	public static int firstNonRepeatingChar(String s) {
		
		for(int i=0; i<s.length(); i++) {
			
			COUNT[s.charAt(i)] = COUNT[s.charAt(i)] + 1; 
		}
		
		for(int i=0; i<s.length(); i++) {
			
			if(COUNT[s.charAt(i)] == 1)
				return i;
		}
		
		
		return -1;
	}
	
	/*
	 * Approach 2 : Using hashmap - Map<Character, Integer>
	 * 
	 */
	
	public static int firstNonRepeatingCharUsingMap(String s) {
		
		Map<Character, Integer> countMap = new HashMap<>();
		
		for(int i=0; i< s.length(); i++) {
			
			char c = s.charAt(i);
			
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}
		
		for(int i=0; i< s.length(); i++) {
			
			if(countMap.get(s.charAt(i)) == 1)
				return i;
		}
		
		return -1;
		
		
		
	}
	
	public static void main(String[] args) {
		
		String s1 = "GeeksforGeeks";
		
		System.out.println(firstNonRepeatingChar(s1));
		System.out.println(firstNonRepeatingCharUsingMap(s1));

	}

}
