/*
 * 
 *	Sources : https://www.youtube.com/watch?v=262lTMIpYQE&t=979s
 *	Title : 33rd Degree 2014 - Demystifying invokedynamic - Venkat Subramaniam
 *	Eclipse : com.kurshit.Java8.InvokeDynamic, MultiMethodExample
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

class MultimethodBase {
	public void foo(double value)
	{
		System.out.println("MultimethodBase::foo");
	}
}

class MultimethodDerived extends MultimethodBase {
	
	/*Case 1 : passing double in foo() - Refer notes after the code
	 * Uncomment to run it and comment case 2
	 * 
	public void foo(double value)
	{
		System.out.println("MultimethodDerived::foo");
	}
	
	*/
	
	/*Case 2 : passing int in foo()
	
	 */
	public void foo(int value)
	{
		System.out.println("MultimethodDerived::foo");
	}
	
	
	
	
}

public class MultiMethodsExample {
	
	public static void use (MultimethodBase base) {
		base.foo(5);
	}
	
	public void run() throws Throwable
	{
		use(new MultimethodBase());
		use(new MultimethodDerived());
		
		System.out.println();
		/*Following is Solution after case 2 : callMethod() is updated later after case 1 and two
		 * Solution is attemoted to attain Multimethods approach - Checking target type 
		 * and target data type at runtime - advanced polymorphism
		 */
		
		MultimethodDerived instance = new MultimethodDerived();
		callTheMethod(instance, 5, double.class);
		callTheMethod(instance, 10, int.class);
	}
	
	/*Solution method */
	private void callTheMethod(Object instance, Object data, Class<?> dataType ) throws Throwable {
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		MethodHandle foo = lookup.findVirtual(instance.getClass(), "foo", MethodType.methodType(void.class, dataType));
		foo.invoke(instance, data);
	}
	
	public static void main(String[] args) throws Throwable {
		new MultiMethodsExample().run();

	}

}

/* Case 1: When doule value is passed on to method foo() :
 * It will call MultimethodBase :: foo and then  MultimethodDerived::foo.
 * This is polymorphism:
 * 
 * Case 2: when you change ,method and pass int value in foo()
 * Output you get is : MultimethodBase::foo ;MultimethodBase::foo
 * 
 * ##Solution : Observed the edited code with comments on it.
 * This is Multimethods example - the solution. This gives you the ability to really 
 * dynamically implement overloading and dispatch method calls. YOou can use reflection as well to achive this.
 * This also solves interface problem
   
*/