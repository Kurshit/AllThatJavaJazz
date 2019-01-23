package com.kurshit.ScriptEngine;

public class TestJS
{
	public static void myJavaMethod()
	{
		System.out.println("hello from TestJS class's static method");
	}
	
	public void m1()
	{
		System.out.println("in non static m1");
	}
	
	public class InnerClass
	{
		public void m2()
		{
			System.out.println("yee");
		}
	}
	
	
}
