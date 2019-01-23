package com.kurshit.MyQuestions;

public class SeggregateZeroAndOnes1
{
	//1. Using two passses
		
	/* Driver Program to test above functions */
    public static void main(String[] args) 
    {
        int arr[] = new int[]{0, 1, 0, 1, 0, 0};
        int arr_size = arr.length;
        int zeroCount = 0;
        //count no of 0's in array
        
        for(int i = 0; i < arr_size; i++)
        {
        	if(arr[i] == 0)
        		zeroCount++;
        }
        
        for(int i =0; i < zeroCount; i++)
        {
        	arr[i] = 0;
        }
        
        for(int i = zeroCount; i<arr_size ;i++)
        {
        	arr[i] = 1;
        }
 
        System.out.print("Array after segregation is ");
        for (int i = 0; i < 6; i++)
            System.out.print(arr[i] + " ");
    }
}
