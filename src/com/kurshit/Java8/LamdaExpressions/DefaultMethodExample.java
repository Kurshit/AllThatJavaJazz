package com.kurshit.Java8.LamdaExpressions;

public class DefaultMethodExample implements Kurshit,Sakshi
{
	
	public void m1()
	{
		Kurshit.super.m1();
	}
	
	public static void main(String[] args)
	{
		DefaultMethodExample r = new DefaultMethodExample();
		r.m1();
		
	}
	
	

}

interface Kurshit
{
	default void m1()
	{
		System.out.println("Inside kurshit");
	}
	
	
}

interface Sakshi
{
	default void m1()
	{
		System.out.println("Inside Sakshi");
	}
}

