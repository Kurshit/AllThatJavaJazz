package com.kurshit.Constructor.ConstructorDemos;

/* Title: Constructor example withh parent class and child class overloaded constructors 
 * Sources : NA
 * Refer Notes : 
 * Eclipse :  Survival/com.kurshit.Constructor.ConstructorChaining
 *  
 */

/*
 * By default, the child class places a call to default constcutors only in each overloaded constructor.
 * Take a look at .class file of this class in jd gui - But i dont see any super() places by deafult. ??
 * 1. So wheneever child class constructor is called, could be default or parameterized, and if parent class has default const
 * defined, it will call super class default constructr from any child class constructors 
 * 
 */



public class ConstructorDemo1 {

	public static void main(String[] args) {
		
		new SubClass(); 
		
		
		System.out.println();
		
		new SubClass(10);
		
		System.out.println();
		
		new SubClass("abc");
		
		

	}

}

class SuperClass
{
	SuperClass()
	{
		System.out.println("Superclass no-arg");
	}
	
	SuperClass(int a)
	{
		System.out.println("SuperClass int-arg");
	}
	
	SuperClass(String s)
	{
		System.out.println("SuperClass string-arg");
	}
}

class SubClass extends SuperClass
{
	SubClass()
	{
		System.out.println("Subclass no-arg");
	}
	
	SubClass(int a)
	{
		System.out.println("SubClass int-arg");
	}
	
	SubClass(String s)
	{
		System.out.println("SubClass string-arg");
	}
}



