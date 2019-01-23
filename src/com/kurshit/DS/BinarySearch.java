
// Binary search works on Divide and Conquer principle. 
// Provided array needs to be sorted in this algorithm


package com.kurshit.DS;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		String ch = "y";
		while(ch.equals("y"))
		{
			System.out.println("Enter array size");
			int size = input.nextInt();
			int[] array = new int[size];
			System.out.println("Enter " +size +" elements of an array:");
			for(int i = 0; i<size;i++)
			{
				array[i] = input.nextInt();

			}
			System.out.println("Enter element to be searched :");
			int key = input.nextInt();
			int result = binarySearch(key, array);

			if(result == -1)
			{
				System.out.println("key element is not found");
			}
			else
			{
				System.out.println("Element found at postion :" +(result +1));
			}
		
			System.out.println("Contibue ? :");
			ch = input.next();
		}
		
	}
	
	public static int binarySearch(int key, int[] array)
	{
		
		int start = 0;
		int end = array.length-1; // or array.length.. does not matter
		int mid;
		while(start<=end)
		{
			mid = (start + end)/2;
			if(key == array[mid])
			{
				return mid;
			}
			
			if(key > array[mid])
			{
				start = mid + 1;
			}
			else
			{
				end = mid -1;
			}
						
		}
		return -1;
		
	}

}
