package com.kurshit.DesignPatterns.CompositionVsInheritance.FavourComposition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TestFavourComposition {
	
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();	
		InstrumentedSet<Integer> is = new InstrumentedSet<>(hs);
		is.add(10);
		is.add(20);
		is.add(30);
		is.remove(30);
		
		List<Integer> list = Arrays.asList(40,50,60);
		
		is.addAll(list);
		
		System.out.println(is.getAddCount());
		
		
	}

}
