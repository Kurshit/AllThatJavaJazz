package com.kurshit.recurssion.series;

/*
 *  Following program shows how to get Traingular number using Recurssion. 
 *  
 *  Traingular Numer - 
 *  
 *  The infinite series whose terms are the natural numbers 1 + 2 + 3 + 4 + ⋯  n. 
 *  
 *   This is given by 
 *   
 *    = n(n+1) / 2.
 * 
 *  Source: https://en.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF
 */

public class TraingularNumber {

	public static void main(String[] args) {
		
		System.out.println(traingularNumber(5));

	}
	
	public static int traingularNumber(int n ) {
				
		if(n  == 0)
			return 0;
		else 
			return n + traingularNumber(n-1);
		
		
	}

}
