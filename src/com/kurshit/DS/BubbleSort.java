// This is a program for bubble sort in ascending and descending order

package com.kurshit.DS;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of an array:");
		int size = input.nextInt();
		System.out.println("Enter elements of an array:");
		int[] array = new int[size];
		for(int i = 0; i<size; i++)
		{
			array[i] = input.nextInt();
		}
		
		bubbleSort(array);
	}
	
	public static void bubbleSort(int[] array)
	{
		int temp;
		int size = array.length;
				
		//ascending order
		for(int i = 0; i< size; i++)
		{
			for(int j = 1; j < (size- i); j++)
			{
				if(array[j-1]>array[j])
				{
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("Sorted array in ascending order");
		for(int i = 0; i <array.length; i++)
		{
			System.out.println(array[i]);
		}
		
		//descending order  -- uncomment and run it
		
		/*for(int i = 0; i<size; i++)
		{
			for(int j = 1; j<(size-i); j++)
			{
				if(array[j-1]<array[j])
				{
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
		
		System.out.println("Sorted array in descending order is :");
		
		for(int i = 0; i<size;i++)
		{
			System.out.println(array[i]);
		}
*/	}

}
