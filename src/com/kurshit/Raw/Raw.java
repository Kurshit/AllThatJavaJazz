package com.kurshit.Raw;


public class Raw {


	public static void main(String[] args) {
		
		System.out.println(1234/10);
		System.out.println(1234%10);
	}
	
	public static void insertionSort(int[] arr) {
		
		for(int i = 1; i< arr.length; i++) {
			int key = arr[i];
			
			int j = i-1;
			
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j -1;
			}
			
			arr[j+1] = key;
			
		}
		
	}


}

