package com.kurshit.Constructor.ConstructorDemos;

/* Title: Constructor example withh parent class and child class overloaded constructors with no parent default constructor
 * Sources : NA
 * Refer Notes : 
 * Eclipse :  Survival/com.kurshit.Constructor.ConstructorDemo1/2
 *  
 */

/*
 * By default, the child class places a call to default constcutors only in each overloaded constructor.
 * Take a look at .class file of this class in jd gui - But i dont see any super() places by deafult. ??
 * 1. So whenever child class constructor is called, could be default or parameterized, 
 * and if parent class DOE NOT HAVE default const defined, 
 * it will throw CE: "Implicite super constructor is not defined. Must call explicite constructor". 
 * Solution to this would be - to place explicite super() to call super class parameterizec construcotrs.
 * 
 * 	 2. If super class does not have any constructor at all and SubClass has Default and other parameterized constructors, 
 * then it will not show any CE and compiler will place the default constructor in super class.
 * 
 */



public class ConstructorDemo2 {

	public static void main(String[] args) {
		
		new SubClass2(); 
		
		
		System.out.println();
		
		new SubClass2(10);
		
		System.out.println();
		
		new SubClass2("abc");
		
		

	}

}

class SuperClass2
{
	SuperClass2()
	{
		System.out.println("Superclass no-arg");
	}
	/*
	 * Comment out above default constructor - the SubCLass constructor will throw CE
	 */
	
	SuperClass2(int a)
	{
		System.out.println("SuperClass int-arg");
	}
	
	SuperClass2(String s)
	{
		System.out.println("SuperClass string-arg");
	}
}

class SubClass2 extends SuperClass2
{
	SubClass2()
	{
		System.out.println("Subclass no-arg");
	}
	
	SubClass2(int a)
	{
		System.out.println("SubClass int-arg");
	}
	
	SubClass2(String s)
	{
		System.out.println("SubClass string-arg");
	}
}



