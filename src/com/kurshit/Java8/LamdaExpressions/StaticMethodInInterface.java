package com.kurshit.Java8.LamdaExpressions;

interface StaticInterface {
	public static void m1() {
		System.out.println("Static method In static interface");
	}
	
	public default void m2() {
		System.out.println("Default method In static interface");
	}
}

public class StaticMethodInInterface implements StaticInterface {
	
	
	public static void main(String[] args) {
			
		StaticInterface s = new StaticMethodInInterface();
		
		s.m2();
	}
}
 