package com.kurshit.Raw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Question : Take an input from the user from getMeNumber() method and check and then print if that number is positive
 * or negative. 
 */

public class Solution {
	
	/*
	 * This method uses Input Output API's to read message from user using BufferedReader class
	 */
	
	public int getNumber()  {

		try {
			
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

			int value = Integer.parseInt(br.readLine());
			
			return value;
			
		} catch(Exception e) {
			System.out.println("Enter valid number");
			e.printStackTrace();
		}
		
		//if exception occured in reading the number, we will return 0
		
		return 0;

	}
	
	/*
	 * Following method checks if given input "number" is positive or negative. 
	 * If number is positive, it will return "true" if negative (less than 0), it would return false.
	 * For value = 0, it would return true (0 is positive number).
	 */
	
	public boolean isPositiveNegative(int number) {
		
		if(number < 0)
			return false;
		else
			return true;
		
	}

	public static void main(String[] args) {

		Solution s1 = new Solution();
		
		int number = s1.getNumber();
		
		boolean result = s1.isPositiveNegative(number);
		
		if(result) {
			System.out.println("Number is positive");
		} else {
			System.out.println("Number is negative");
		}
	}
}