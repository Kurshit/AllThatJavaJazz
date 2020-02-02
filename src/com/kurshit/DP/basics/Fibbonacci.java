package com.kurshit.DP.basics;

public class Fibbonacci {
	
	public int fibbonacci(int n) {
		
		if( n == 0)
			return 0;
		
		if(n == 1)
			return 1;
		
		return fibbonacci(n-2) + fibbonacci(n-1);
	}
	
	public int fibbonacciUsingTabulation(int n) {
		
		int[] fib = new int[n+1];
		
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i=2; i<=n; i++) {
			fib[i] = fib[i-2] + fib[i-1];
		}
		
		return fib[n];		
	}
	
	public int fibbonacciUsingMemoization(int n) {
		return 0;
	}

	public static void main(String[] args) {
		
		Fibbonacci fib = new Fibbonacci();
		int result = fib.fibbonacci(5);
		
		System.out.println("Using normal recurssion : " +result);
		
		result = fib.fibbonacciUsingTabulation(5);
		System.out.println("Using tabulation : " +result);

	}

}
