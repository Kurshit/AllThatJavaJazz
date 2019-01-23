package com.kurshit.MyQuestions;

class A
{
	public void m1()
	{
		System.out.println("In A m1");
	}
}

class B extends A
{
	public void m1()
	{
		System.out.println("In B m1");
	}
}

public class OverridingQ1 {

	public static void main(String[] args) 
	{
		A a = (A)new B();
		a.m1();
		((A)a).m1();
		System.out.println(((A)a).getClass());
	   A a1 = new A();
	   B b1 = (B) a1;
	   
	   
	
	}

}
