package com.kurshit.interview.overriding;

class Parent {
	
	public void method1() {
		System.out.println("Parent Class");
	}
}


public class Overriding extends Parent {
	
	public void method1() {
		System.out.println("Child class");
	}
	
	public static void main(String[] args) {
		Overriding obj1 = new Overriding();
		obj1.method1();
		
		Parent obj2 = new Overriding();
		obj2.method1();
	}

}

class Child extends Parent {
	
}


