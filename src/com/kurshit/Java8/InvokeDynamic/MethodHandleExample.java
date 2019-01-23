/*
 * 
 *	Sources : https://www.youtube.com/watch?v=262lTMIpYQE
 *	Title : 33rd Degree 2014 - Demystifying invokedynamic - Venkat Subramaniam
 *	Eclipse : com.kurshit.Java8.InvokeDynamic, MethodHandleExample
 *	Author : Venkat Subhramaniyam
 *  Loc on disk : D:\Kurshit\All owned notes\JAVA 8\Invoke Dynamic - Demytifying invoke Dynamic (Venkat)
 *	
 * 
 */

/*
 * This program shows examples of Method Handle, calling the methods at runtime, like this is 
 * advanced reflection api's. 
 */


package com.kurshit.Java8.InvokeDynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class MethodHandleExample {
	
	public double instMethod( double value)
	{
		System.out.println("instMethod called " +value);
		return value * 2;
	}

	public static void staticMethod( double value)
	{
		System.out.println("staticMethod called "+ value);
	}
	
	public static void main(String[] args) throws Throwable {
		
		MethodHandleExample sample = new MethodHandleExample();
		
		//Calling those two methods conventionally -
		sample.instMethod(2);
		MethodHandleExample.staticMethod(4);
		
		System.out.println();
		//Calling methods indirectly using method handles
		
		/*below statement asks for ref to Object - backdoor to get to this method.
		 * In reflection - YOu go to a class and say - Hey class, do you have this method 
		 * with these parameters ? and it gives you a Method object. Then you can go to 
		 * a method object using which you call invoke() and pass the object and required 
		 * parameters and call the method. This is reflection. But this works well if
		 * you have methods you are really talking to. But what if you are really interested 
		 * in binding to methods that dont even exist ? For e.g, we called the method at
		 * grrovy "shout()" that did not even exist.
		 *  
		 
		*/
		
		MethodHandles.Lookup lookup = MethodHandles.lookup();  //ask for Lookup object
		MethodHandle staticMethodHandle = lookup.findStatic(MethodHandleExample.class, "staticMethod", 
				MethodType.methodType(void.class, double.class)); 
		
		//lookup for static method in given class. Be careful of overloading in above line
		
		staticMethodHandle.invoke(2.2);
		staticMethodHandle.invokeExact(2.2); // give it exactly what it wants, no typecasting it does
		
		//staticMethodHandle.invokeExact(2); //will throw exception, but invoke() will accept it
		
		System.out.println();
		
		MethodHandle instMethodHandle = lookup.findVirtual(MethodHandleExample.class, "instMethod", 
				MethodType.methodType(double.class, double.class));
		
		//instMethodHandle.invokeExact(sample, 2.2); // this will throw an error 
		
		instMethodHandle.invoke(sample,2); // this works or another approach is using bind
		
		instMethodHandle.bindTo(sample).invoke(2);
		
		System.out.println();
		
		/*
		 *  Question : How is above things different from reflection ? Well, in reflection, we normally ask for
		 * methods that do exist. In this particular example, methods do exist, thus we could have used
		 * Reflection instead of MethodHandle ??
		 * Ans : If you really want to bind this to arbitary methods that dont exist or to 
		 * something that's absolutely created on the fly, while the program is running. Such programs are 
		 * ahead. Above shows how reflection could have been look like, advaned api's.
		 *  
		 */
		
		/* using reflection and calling methods using MethodLookups (mixed of two api's) : - */
		
		System.out.println("Reflection : ");
		Method instMethodReflection = MethodHandleExample.class.getMethod("instMethod", 
				double.class); // THis is reflection
		
		MethodHandle unreflect = lookup.unreflect(instMethodReflection);
		// How to call it ? figure out
		
		
		
		
		
		
		
		

		
	}

}
