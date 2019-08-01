package com.kurshit.recurssion.series;

public class TraingularNumber {

	
	
	public static void main(String[] args) {
		System.out.println(traingularNumber(5));

	}
	
	public static int traingularNumber(int n) {
		if(n==0) 
			return 0;
		else {
			return n + traingularNumber(n - 1);
		}
	}

}
