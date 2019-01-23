package com.kurshit.Raw;

import javax.print.attribute.standard.MediaSize.Other;

class Outer{
	int i  = 10;
	final int j  = 100;
	static int k  = 1000;
	static final int l  = 10000;
	private void m1()
	{
		System.out.println("M1 method");

	}
	static void m2(){
		System.out.println("M2 method");
	}
	
	static class Inner{
		
		int m  = 10;
		final int n  = 100;
		static int o  = 1000;
		static final int p  = 10000;
		private void m3()
		{
			System.out.println("M1 method");

		}
		static final void m4(){
			System.out.println("M2 method");
		}
		static public void m5()
		{	Outer o = new Outer();
			System.out.println(o.i);
			System.out.println(o.j);
			System.out.println(k);
			System.out.println(l);
			o.m1();
			m2();

		}
	}
}

public class TestDemo123
{
	public static void main(String[] args)
	{
		Outer.Inner i = new Outer.Inner();
		i.m5();
	}
}
