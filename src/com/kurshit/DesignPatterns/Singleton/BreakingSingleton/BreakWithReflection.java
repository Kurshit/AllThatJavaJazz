package com.kurshit.DesignPatterns.Singleton.BreakingSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.kurshit.DesignPatterns.Singleton.DoubleCheckLazyInitialization;

/*
 * This class shows how we can break in the singleton design pattern using reflection.
 */

public class BreakWithReflection {

	
			
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		DoubleCheckLazyInitialization instanceOne = DoubleCheckLazyInitialization.getInstance();
		DoubleCheckLazyInitialization instanceTwo;
		
		try {
		
			Constructor<DoubleCheckLazyInitialization> constructor = DoubleCheckLazyInitialization.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			instanceTwo = constructor.newInstance();
			
			System.out.println(instanceOne);
			System.out.println(instanceTwo);
		
		
		
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
