package com.kurshit.Java8.LamdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest
{
	
	public static int totalValues(List<Integer> list, Predicate<Integer> predicate)
	{
		// any of this way can be used. Uncomment any method and use it
		
		/*int result = 0;
		for(int e : list)
		{ 
			if(predicate.test(e))
				 result +=e;
		}
		
		return result;*/
		
		/*return list.stream()
				.filter(predicate)
				.reduce(0, Integer :: sum);
		*/
		
		return list.stream()
				.filter(predicate)
				.mapToInt(e -> e)
				.sum();
		
				
	}
	
	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//list.stream().filter(pre);
		
		
		
		//highrer order function
		// computes all no
		System.out.println("Even " + totalValues(list, e -> true));
		
		//compute all even values
		System.out.println("Even " + totalValues(list, e -> e%2==0));
		
		//compute all odd values
		System.out.println("Even " + totalValues(list, e -> e%2!=0));
		
		
	}

}
