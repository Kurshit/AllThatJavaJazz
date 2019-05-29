package com.kurshit.DesignPatterns.Singleton.BreakingSingleton;

import com.kurshit.DesignPatterns.Singleton.EnumSingleton;

public class UsingEnumSingleton {

	public static void main(String[] args) {
		
		EnumSingleton instanceOne = EnumSingleton.INSTANCE;
		EnumSingleton instanceTwo = EnumSingleton.INSTANCE;
		
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
		
		System.out.println(instanceOne.getValue());
		instanceOne.setValue(15);
		System.out.println(instanceOne.getValue());
		

	}

}
