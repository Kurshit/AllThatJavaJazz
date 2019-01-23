package com.kurshit.HackerEarthPractice.BasicProgramming.BasicsOfImplementation;

/*
 * You are given a string S. Count the number of occurrences of all the digits in the string S.

		Input: 
		First line contains string S.
		
		Output: 
		For each digit starting from 0 to 9 print the count of their occurrences in the string S. So, print 10
		lines, each line containing 2 space separated integers. First integer i and second integer count of occurrence of i. 
		See sample output for clarification.

		Constraints:
		1 ≤ | S | ≤ 100

 * 
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;



class CoutDigits {

	public static void main(String[] args) {/* 

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			String input = br.readLine();
			int[] outputArray = new int[10];

			for(int i = 0; i<input.length(); i++)
			{
				char key = input.charAt(i);
				if(Character.isDigit(key))
				{
					switch(key) {

					case '0' : outputArray[0] = outputArray[0] + 1;
					break;

					case '1' : outputArray[1] = outputArray[1] + 1;
					break;

					case '2' : outputArray[2] = outputArray[2] + 1;
					break;

					case '3' : outputArray[3] = outputArray[3] + 1;
					break;

					case '4' : outputArray[4] = outputArray[4] + 1;
					break;

					case '5' : outputArray[5] = outputArray[5] + 1;
					break;

					case '6' : outputArray[6] = outputArray[6] + 1;
					break;

					case '7' : outputArray[7] = outputArray[7] + 1;
					break;

					case '8' : outputArray[8] = outputArray[8] + 1;
					break;

					case '9' : outputArray[9] = outputArray[9] + 1;
					break;

					}
				}


			}

			for(int i = 0; i < outputArray.length; i++)
			{
				System.out.println(i+" "+outputArray[i]);
			}

		}
		catch(Exception e) { }
	*/
		
		effectiveSolution();
	}    

	public static void effectiveSolution() 
	{	
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
			String input = br.readLine();
			int[] outputArray = new int[10];
			int p;
			for(int i = 0; i<input.length(); i++)
			{
				char key = input.charAt(i);
				if(Character.isDigit(key))
				{
					p = key - 48;
					outputArray[p] = outputArray[p] + 1;
				}


			}

			for(int i = 0; i < outputArray.length; i++)
			{
				System.out.println(i+" "+outputArray[i]);
			}

		}
		catch(Exception e) {}
		
		
	}


}



/*
 *	Sample Input :
 *
 *		77150
 
 	Sample Output :
 	
 		0 1
		1 1
		2 0
		3 0
		4 0
		5 1
		6 0
		7 2
		8 0
		9 0
 * 
 * 
 * 
*/