package com.kurshit.Raw;

//Java program to find the 
//longest substring of vowels. 
import java.util.*;

public class Raw2 {

	 public static String maxVowels(String s, int k) {
		 
		 int i = 0;
		 int j = k-1;
		 
		 String result = "";
		 int max  = 0;
		 while( i < j && j < s.length()) {
			 
			 String sub = s.substring(i,j+1);
			 
			 int countVowels = getVowels(sub);
			 
			 
			 if(countVowels != 0 && max < countVowels)
			 {
				 result = sub;
				 max = countVowels;
			 } else if(max == countVowels) {			 
				 
			 }

			 i++;
			 j++;
		 }
		 return result.isEmpty() ? "Not found!":result;
	 }
	 
	 

	private static int getVowels(String sub) {
		
		int c = 0;
		
		for(int i=0; i < sub.length(); i++) {
			char ch = sub.charAt(i);
			
			if(ch == 'a' || ch == 'e' || ch =='i' || ch =='o' || ch =='u') {
				c = c+1;
			}
		}
		
		return c;
	}
	
	public static List<String> mostActive(List<String> customers) {
	    
		Map<String, Integer> map = new HashMap<>();
		
		for(String s : customers) {
			int newValue = map.getOrDefault(s, 0);
			map.put(s, newValue + 1);
		}
		
		double N = customers.size();
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		List<String> resultList = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : entrySet) {
			
			double d = entry.getValue();
			double result = (d / N) * 100;
			
			if(result >= 5) {
				resultList.add(entry.getKey());
			}
			
		}
		
		Collections.sort(resultList);
		
		return resultList;
		

	}



	// Driver code
	public static void main(String[] args) {
		String s = "aeiouia";
		System.out.println("---> " + maxVowels(s, 3));
		
		/*List<String> list = Arrays.asList("Bigcorp","Bigcorp", "Acme","Bigcorp", "Zork", "Zork","Abc","Bigcorp", "Acme", "Bigcorp","Bigcorp","Zork","Bigcorp","Zork","Zork",
				"Bigcorp","Acme","Bigcorp","Acme","Bigcorp","Acme","Littlecorp","Nadicorp");
		
		System.out.println(mostActive(list));*/
	}
}

