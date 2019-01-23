package com.kurshit.Java8.Streams.StreamsPracticeExamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsUsageExamples {

	public static void main(String[] args) {
		
		System.out.println(isPrime(97)); // true
		System.out.println(findFactorial(5));  // 120
		System.out.println(findSumOfFirstNNumbers(10)); // 55
		System.out.println(findSumOfFirstNEvenNumbers(10)); // 30
		
		System.out.println("Example of sorting a list : ");
		
		List<Integer> list = Arrays.asList(15,80,5,-2,20,90,4,8,100);
		
	}
	
	private static boolean isPrime(final int number)
	{
		return number>1 && IntStream.range(2, number)
					.noneMatch(index->number%index==0);				
	}
	
	private static int findFactorial(final int number)
	{
		/*
		 * 
		 * 	int result = 1;
		 *	for(int i = 1; i <= number; i++)
		 *	{ 
		 *		result = result * i;
		 *	}	
		 *	return result;
		 *
		 *
		 *	Above code can exactly be converted to streams using following code
		 *
		 */
		
		
		return IntStream.rangeClosed(1, number)
							.reduce(1, (result,index)-> result*index);
							
		
		
		/*
		 * rangeClosed(1, number) is equal to for(int i=1; i <= number; i++)
		 * instead of this, we could also have used - 
		 * 
		 * reduce(1, (result,index) -- In this, 1 wil set identity result = 1, as done before going inside for loop.
		 * (result,index)-> result * index --> fist argurment is result variable initialized & passed inside for loop,
		 * as traditional approach, second arguement would be the index of range - like index of for loop
		 * 
		 * range(1, number+1) is equal to for(int i=1; i< number+1; i++)
		 *  With range() - Programe as follows
		 */
		
		/* 
			return IntStream.range(1, number+1)
							.reduce(1, (x,y)-> x*y);
		*/
		
		/*
		 * We can also used following variations using method ref.
		 */
		
		
	
	}
	
	
	private static int findSumOfFirstNNumbers(final int number)
	{
		/*return IntStream.rangeClosed(1, number)
					.reduce(0,(result,index)->result+index);
		*/
		
		/*
		 * Instead of above, we can also use Method Reference as below two methods
		 */
		
		/*
		  return IntStream.rangeClosed(1, number)
		 							.reduce(0,  Integer :: sum);
		*/
		
		/* OR */
		
		return IntStream.rangeClosed(1, number)
							.sum();
		
		/* Refer internal api doc of sum() */
		
	}
	
	
	private static int findSumOfFirstNEvenNumbers(final int number)
	{
		/* return IntStream.rangeClosed(1, number)
				.filter(n->n%2==0)
				.reduce(0, (result,index)->result+index);
		*/
		
		/* OR */
		
		/*
		return IntStream.rangeClosed(1,  number)
				.filter(n->n%2==0)
				.reduce(0,Integer :: sum);
		
		*/
		
		return IntStream.rangeClosed(1, number)
				.filter(n->n%2==0)
				.sum();
		
		
	}
	
	

}
