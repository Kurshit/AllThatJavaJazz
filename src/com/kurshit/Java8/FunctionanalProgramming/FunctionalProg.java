/*Title: Functional Programming with Java8
 * Sources : https://www.youtube.com/watch?v=Ee5t_EGjv0A&spfreload=5
 * Author : venkat
 * Refer Notes : Functional Programming with Java
 * Loc : D:\Kurshit\All owned notes\JAVA 8\Functional Programming with Java8
 * Eclipse :  Survival/com.kurshit.Java8.FunctionanalProgramming
 *  
 */

//Finding prime numbers with imperative and declarative approach

package com.kurshit.Java8.FunctionanalProgramming;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FunctionalProg {

	public static void main(String[] args) 
	{
		System.out.println(isPrimeImperative(5));  //calling imperative approach
		System.out.println(isPrimeFunctional(5));
		System.out.println(isPrimeFunctionalEnhanced(5));
		
	}
	
	/*
	 * Following is the imperative style of program to find whether the number 
	 * is prime or not
	 */
	
	// Imperative - saying how
	// mutability
	
	public static boolean isPrimeImperative(final int number)
	{
		for(int i = 2; i<number; i++)
		{
			if(number%i ==0 )
				return false;
		}
		
		return number >1;
	}
	
	/* We can convert above program in Function approach as follows
	 * 
	 */
	//Declarative code
	//Immutability
	
	public static boolean isPrimeFunctional(final int number)
	{
		return number > 1 && 
				IntStream.range(2, number)
						.noneMatch(index -> number % index ==0);
					
	}
	
	/*
	 * isPrimeFunctional() code can be converted into more enhanced version as follows
	 * 
	 */
	
	public static boolean isPrimeFunctionalEnhanced(final int number)
	{
		Predicate<Integer> predicate = divisor -> number % divisor == 0;
		//divisor is a parameter coming in to annonymous lambda function
		
		
		return number > 1 && 
				IntStream.range(2, number)
						.noneMatch(index -> predicate.test(index));
					
	}
	
	

}
