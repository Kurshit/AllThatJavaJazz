package com.kurshit.interview.overriding;

class Parent2 {
	public int x = 10;
	public static int y = 20;
}

public class VariableOverriding extends Parent2 {

	public int x = 100;
	public static int y = 200;
	
	public static void main(String[] args) {
		
		VariableOverriding obj1 = new VariableOverriding();
		
		System.out.println(obj1.x +" --- " + obj1.y);
		
		Parent2 obj2 = new VariableOverriding();
		
		System.out.println(obj2.x +" --- " + obj2.y);
		
		
	
	}

}
