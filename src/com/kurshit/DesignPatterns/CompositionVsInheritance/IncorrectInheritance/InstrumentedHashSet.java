package com.kurshit.DesignPatterns.CompositionVsInheritance.IncorrectInheritance;

/* Title: Facour composition over inheritance. This prog shows misuse of inheritance
 * Sources : Efefctive Java - Item 16
 * Refer Notes : Effective Java - Item 16
 * Eclipse :  Survival/com.kurshit.DesignPatterns.CompositionVsInheritance.IncorrectInheritance
 *  
 */

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int addCounter;
	
	public InstrumentedHashSet() {
		
	}
	
	InstrumentedHashSet(int initCap, float loadFactor)
	{
		super(initCap, loadFactor);
	}
	
	@Override
	public boolean add(E e) {
		addCounter++;
		return super.add(e);
	}
	
	public int getAddCounter()
	{
		return addCounter;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCounter = addCounter + c.size(); 
		return super.addAll(c);
	}

}
