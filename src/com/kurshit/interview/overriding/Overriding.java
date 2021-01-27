package com.kurshit.interview.overriding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

class Parent {
	
	public void method1()  {
		System.out.println("Parent Class");
	}
}


public class Overriding extends Parent {
	
	public void method1() {
		System.out.println("Child class");
	}
	
	public static void main(String[] args) {
		
		try {
		Overriding obj1 = new Overriding();
		obj1.method1();
		
		Parent obj2 = new Overriding();
		obj2.method1(); 
		} catch(Exception e) {
			
		}
	}

}

class Child extends Parent {
	
}


