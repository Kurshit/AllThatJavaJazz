package com.kurshit.DesignPatterns.CompositionVsInheritance.FavourComposition;


/* Title: Favour composition over inheritance. This prog shows how to use composition and solution for problem of IncorrectInheritance package
 * Sources : Effective Java - Item 16
 * Refer Notes : Effective Java - Item 16
 * Eclipse :  Survival/com.kurshit.DesignPatterns.CompositionVsInheritance.FavourComposition
 *  
 */


import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ForwardingSet<E> implements Set<E>{
	
	private final Set<E> s;
	
	ForwardingSet(Set<E> s)
	{
		this.s = s;
	}

	@Override
	public int size() {
		return s.size();
	}

	@Override
	public boolean isEmpty() {
		return s.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return s.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return s.iterator();
	}

	@Override
	public Object[] toArray() {
		
		return s.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		
		return s.toArray(a);
	}

	@Override
	public boolean add(E e) {
		
		return s.add(e);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return s.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return s.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return s.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return s.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return s.removeAll(c);
	}

	@Override
	public void clear() {
		s.clear();
		
	}
	
	
	
	
	
	

}
