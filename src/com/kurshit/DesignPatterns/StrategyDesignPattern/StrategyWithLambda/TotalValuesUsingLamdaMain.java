package com.kurshit.DesignPatterns.StrategyDesignPattern.StrategyWithLambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TotalValuesUsingLamdaMain
{
	static int totalValues(List<Integer> numbers, Predicate<Integer> predicate)
	{
		int result = 0;
		
		for(int i : numbers)
		{
			if(predicate.test(i))
				result +=i;
		}
				
		return result;
		
		
		//alternatively below streams can be used 
		
		/*return numbers.stream()
					  .filter(predicate)
					  .reduce(0, Integer :: sum);*/
		
		//Or can be done in below way 
		
	/*	return numbers.stream()
					  .filter(predicate)
					  .mapToInt(e -> e)
					  .sum();*/
	
	}
	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		//traditional approach
		/*Predicate<Integer> p = new Predicate<Integer>()
		{
			@Override
			public boolean test(Integer i)
			{
				if(i%2 == 0)
					return true;
				else
					return false;
			}
			
			
		};
		System.out.println(totalValues(list, p));
		*/
		
		//using lambdas and streams
		
		System.out.println("Using lambda :");
		System.out.println("All:" +totalValues(list, e-> true));
		
		System.out.println("Even:" +totalValues(list, e-> e%2==0));
		
		System.out.println("Odd:" +totalValues(list, e-> e%2!=0));
		
		
		//alternatively, we can define util classes as "TotalUtil" below and can call using
		//method reference
		
		System.out.println("Using Util methods and method reference");
		
		
		System.out.println("All:" +totalValues(list, TotalUtil:: totalAll));
		
		System.out.println("Even:" +totalValues(list, TotalUtil:: totalOnlyEven));
		
		System.out.println("Odd:" +totalValues(list, TotalUtil:: totalOnlyOdd));
		
		
		

	}

}

class TotalUtil
{
	public static boolean totalOnlyEven(int number)
	{
		return number%2 ==0;
	}
	
	public static boolean totalOnlyOdd(int number)
	{
		return number%2 !=0;
	}
	
	public static boolean totalAll(int number)
	{
		return true;
	}
}
