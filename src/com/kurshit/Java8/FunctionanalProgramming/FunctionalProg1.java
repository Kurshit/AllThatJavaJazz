/*Title: Functional Programming with Java8
 * Sources : https://www.youtube.com/watch?v=Ee5t_EGjv0A&spfreload=5
 * Author : venkat
 * Refer Notes : Functional Programming with Java
 * Loc : D:\Kurshit\All owned notes\JAVA 8\Functional Programming with Java8
 * Eclipse :  Survival/com.kurshit.Java8.FunctionanalProgramming
 */

package com.kurshit.Java8.FunctionanalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


//Finding double of first even number greater than 3

public class FunctionalProg1 {
	
	public static boolean isGreaterThan3(int number)
	{
		/* uncomment for lazy evaluation proof */
		
		System.out.println("isGreaterThan called for : " +number);
		 return number > 3;
	}
	
	public static boolean isEven(int number)
	{
		/* uncomment for lazy evaluation proof */
		
		System.out.println("isEven called for : "+number);
		return number % 2 ==0;
	}
	
	public static int doubleIt(int number)
	{
		/* uncomment for lazy evaluation proof */
		
		System.out.println("doubleIt called for : "+number); 
		return number * 2;
	}
	

	public static void main(String[] args) 
	{
		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println(findFirstEvenImperative(values));
		System.out.println(findFirstEvenFunctional(values));
		System.out.println(findFirstEvenMethodRef(values));
		System.out.println(findFirstEvenLazyEvaluation(values));
		findFirstEvenLazyEvaluationProof1(values);
	
	}
	
	public static int findFirstEvenImperative(final List<Integer> values)
	{
		int result = 0;

		for(int e : values)
		{
			if(e > 3 && e % 2 == 0)
			{
				result = e * 2;
				break;
			}
		}

		return result;

	}
	
	/*
	 * Above can be converted into declarative/functional approach
	 * 
	 */
	
	public static int findFirstEvenFunctional(final List<Integer> values)
	{
		return values.stream()
				.filter(number -> number > 3)
				.filter(number -> number % 2 == 0)
				.map(number -> number * 2)
				.findFirst()
				.get();

	}

	/* This is also called Higher-Order function - Passing a function to a function - Method
	 * Reference. This fun can either decide to evaluate this function now, or may evaluate it 
	 *	later or might never evaluate. This is Lazy evaluation. For loops are 
	 *	eager evaluation. To make traditional for loops as lazy eveluation, it takes more 
	 *	efforts and checks. 
	*/
	
	
	public static int findFirstEvenMethodRef(final List<Integer> values)
	{
		return values.stream()
				.filter(FunctionalProg1 :: isGreaterThan3)
				.filter(FunctionalProg1 :: isEven)
				.map(FunctionalProg1 :: doubleIt)
				.findFirst()
				.get();

	}

	/*
	 * Example of Lazy evaluation : Find the double of first even no greater than 3 
	 * Consider following example as per traditional for loop. Steps :
	 * 1. Find every no greater than three in given list of 10 no {1,2,3..10}
	 *    This will take 10 operations. This will leave 
	 *    7 elements for next step. (removing 1,2 & 3). 
	 * 2. Now to find even of them will take 7 operations. Total so far = 10+7 = 17
	 * 3. Doubling the even numbers (4,6,8,10) -- 4 operations. Total = 17+4 = 21      
	 *  Proof: Uncomment the sysout statements in static methods of this class and run prog
	 *  Output : 
	 * 		isGreaterThan called for : 1
	 *  	isGreaterThan called for : 2
	 *		isGreaterThan called for : 3
	 *		isGreaterThan called for : 4
	 *		isEven called for : 4
	 *		doubleIt called for : 4
	 *		8
	 * Does not evaluate rest operations after finding first result. THis is lazy 
	 * evaluation.
	 * 	
	 */
	
	
	public static int findFirstEvenLazyEvaluation(final List<Integer> values)
	{
		return values.stream()
				.filter(FunctionalProg1 :: isGreaterThan3)
				.filter(FunctionalProg1 :: isEven)
				.map(FunctionalProg1 :: doubleIt)
				.findFirst()
				.get();

	}
	
	
	/* Methods like filter and map are called - Intermidiate Operations 
	 * and methods like reduce() and findFirst() are called Terminal operations.
	 * These operations don't even execute while you are passing through.
	 * Proof: 
	 *
	 */
	
	public static void findFirstEvenLazyEvaluationProof1(final List<Integer> values)
	{
		final Stream<Integer> temp = 
			values.stream()
				.filter(FunctionalProg1 :: isGreaterThan3)
				.filter(FunctionalProg1 :: isEven)
				.map(FunctionalProg1 :: doubleIt);
		
		 System.out.println(temp.findFirst()); //comment this line and read following comment
		
		/*
		 * Look at the quiteness when above line is commented. 
		 * It does not evaluate the values at all.THis gives effective 
		 * lazyness and calls whenever it is necessary
		 */
				

	}
	
}
