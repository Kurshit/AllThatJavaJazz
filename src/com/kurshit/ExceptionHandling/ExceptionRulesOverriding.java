package com.kurshit.ExceptionHandling;

class A
{
	void m1() throws Exception 
	{
		System.out.println("in m1 of A");
	}
}

public class ExceptionRulesOverriding extends A
{
	void m1() throws Exception
	{
		System.out.println("in m1 of main");
	}
	
	public static void main(String[] args)
	{
		A a = new ExceptionRulesOverriding();

	}

}
