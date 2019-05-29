package com.kurshit.hackerearth.loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ExtraLongFactorial {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//BigInteger result = findLongFactorial(N);
		
		BigInteger result = findLongFactorialRecursion(N);
		
		System.out.println(result);
	}
	
	public static BigInteger findLongFactorial(int N) {
		
		BigInteger input = BigInteger.valueOf(N);
		BigInteger result = BigInteger.ONE;
		
		while(input.compareTo(BigInteger.valueOf(0))  == 1) {
			
			result = result.multiply(input);		
			input = input.subtract(BigInteger.ONE);			
		}	
		return result;		
	}
	
	public static BigInteger findLongFactorialRecursion(int N) {
						
		if(N == 1)
			return BigInteger.ONE;
		
		return BigInteger.valueOf(N).multiply( findLongFactorial(N-1));
		
		
	}
}
