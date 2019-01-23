package com.kurshit.DesignPatterns.CompositionVsInheritance.FavourComposition;

import java.util.Collection;
import java.util.Set;

public class InstrumentedSet<E> extends ForwardingSet<E> {
	
	InstrumentedSet(Set<E> s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	private int addCount = 0;
	
	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount = addCount + c.size();
		return super.addAll(c);
	}
	
	public int getAddCount() {
		return addCount;
	}

}
