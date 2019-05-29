package com.kurshit.recurssion.basics;

/* This program prints the output as 
 * 3 2 1 1 2 3 
 * 
 *  n n-1 n-2 .. 1 ...     
 * 
 */

public class KnowHowItWorks {
	
	public static void fun(int n) {
		
		if( n < 1)
			return;
		else
		{
			System.out.print(n);
			fun(n-1);
			System.out.print(n);
		}
					
		
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		
		fun(3);
		
	}
	
	
}
