package com.kurshit.Codes.BasicArray;

public class Fibonnaci
{

	static void approachFirst()
	{
		int limit = 10;
		int index = 2;
		System.out.println("Fibonnacy series is given below :");
		
		
		int first = 0;
		int second = 1;
		int result = 0;
		System.out.print(first + " " + second);  
		while(index < limit)
		{
			result = first + second;
			System.out.print(" " + result);
			first = second;
			second = result;
			index++;
		}

	}

	static void approachSecond()
	{
		int limit = 10;
				
		System.out.println("Fibonnacy series is given below :");
		int[] arr = new int[limit];
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2 ; i < arr.length; i++ )
		{
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		for(int i = 0; i<arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		

	}
	
	static void usingRecusrion()
	{
		int limit = 10;
		int first = 0;
		int second = 0;
		
		if(limit < 0)
		{
			
		}
		
		
		
		
	}
	public static void main(String[] args)
	{
		approachFirst();
		System.out.println();
		approachSecond();
	}			
		
}
