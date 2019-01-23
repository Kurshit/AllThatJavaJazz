/*
 * 
 *	Sources : https://www.youtube.com/watch?v=262lTMIpYQE
 *	Title :  33rd Degree 2014 - Demystifying invokedynamic - Venkat Subramaniam
 *	Eclipse : com.kurshit.Java8.InvokeDynamic, CallSiteExample
 *	Author : Venkat Subhramaniyam
 *	Thory Loc: Loc on disk : D:\Kurshit\All owned notes\JAVA 8\Invoke Dynamic - Demytifying invoke Dynamic (Venkat)
 * 
 */

/*
 * This program shows examples of CallSite concept
 */


package com.kurshit.Java8.InvokeDynamic;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;

public class CallSiteExample {
	
	private static MethodHandle tickHandle;
	private static MethodHandle tockHandle;

	public static void callSiteTick() {
		System.out.println("tick");
	}
	
	public static void callSiteTock() {
		System.out.println("tock");
	}

	public static void main(String[] args) throws Throwable {
		CallSite callSite = createHandle();
		MethodHandle handle = callSite.dynamicInvoker();
		/*dynamicInvoker - This gives ability to really say -
		 * "Dont bind to handle ahead of tim"
		 * 
		 */
		
		for(int i=0; i <10; i++) {
			handle.invoke();
			Thread.sleep(1000);
			changeHandle(callSite, i);  // we can comment this one to see upto this, how it works
		}
		

	}

	private static void changeHandle(CallSite callSite, int index) throws NoSuchMethodException, IllegalAccessException {
		
		if(callSite.getTarget().equals(tickHandle)) 
			callSite.setTarget(tockHandle);
		else
			callSite.setTarget(tickHandle);
		
		if(index == 8 ) {
			Runnable runnable = () -> System.out.println("tada!!!");
			MethodHandles.Lookup lookup = MethodHandles.lookup();
			MethodHandle handle = lookup.findVirtual(runnable.getClass(), 
					"run", MethodType.methodType(void.class));
			MethodHandle localHandle = handle.bindTo(runnable);
			callSite.setTarget(localHandle);
		}
		
	}

	private static CallSite createHandle() throws NoSuchMethodException, IllegalAccessException {
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		tickHandle = lookup.findStatic(CallSiteExample.class,"callSiteTick", MethodType.methodType(void.class));
		
		tockHandle = lookup.findStatic(CallSiteExample.class,"callSiteTock", MethodType.methodType(void.class));
		
		return new MutableCallSite(tickHandle);
	}

}
