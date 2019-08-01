package com.kurshit.interview.overriding;

public class OverLoading {
	
	public void add(int a) {
		System.out.println("int arg");
	}
	
	public void add(String a) {
		System.out.println("String arg");
	}
	
	
	public static void main(String[] args) {
		OverLoading obj1 = new OverLoading();
	}

}
