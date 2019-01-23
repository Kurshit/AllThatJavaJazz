package com.kurshit.DesignPatterns.CompositionVsInheritance.IncorrectInheritance;

/* Title: Facour composition over inheritance. This prog shows misuse of inheritance
 * Sources : Efefctive Java - Item 16
 * Refer Notes : Effective Java - Item 16
 * Eclipse :  Survival/com.kurshit.DesignPatterns.CompositionVsInheritance.IncorrectInheritance
 *  
 */

import java.util.Arrays;
import java.util.List;

public class TestInstrumentedHashSet {

	public static void main(String[] args) {
		
		InstrumentedHashSet<Integer> ish = new InstrumentedHashSet<Integer>();
		ish.add(10);
		ish.add(20);
		ish.add(30);
		ish.add(40);
		ish.remove(30);
		ish.add(20); 
		
		/* Though duplicate element is not added, it is counted for perfmorming add operation.
		 * To avoid this, in IHS class, in add(), first return value of add() should be checked and then counter shuld be increamented.
		 */
		System.out.println(ish);
		System.out.println("For add(), ans should be 5");		
		System.out.println(ish.getAddCounter());
		
		List list = Arrays.asList(50,60,70,80);
		ish.addAll(list);
		System.out.println("After adding 4 new itmes using addAll() -- ans");
		System.out.println(ish.getAddCounter());
		
		/*
		 * The count was expected to be 9 instead of 13. Because addAll() internally calls add().
		 * This is what inheritance caused
		 */
		
		
		

	}

}
