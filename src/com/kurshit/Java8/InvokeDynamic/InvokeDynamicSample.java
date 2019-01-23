package com.kurshit.Java8.InvokeDynamic;

public class InvokeDynamicSample {

	// make non-final and run javap command to see instruction type 
	public final void foo() {
		System.out.println("foo called..");
	}

	public static void main(String[] args) {
		InvokeDynamicSample sample = new InvokeDynamicSample();
		sample.foo();
		int a = 20;
		boolean b = false;
				
	}

}
