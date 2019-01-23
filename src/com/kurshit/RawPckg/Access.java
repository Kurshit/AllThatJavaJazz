package com.kurshit.RawPckg;

class Access
{
	public Access()
	{
		printAM1();
	}
	
	protected static void printAM2()
	{
		System.out.println("A m2");
		
	}
	
	private void printAM3()
	{
		System.out.println("in private A m3");
	}
	
	void printAM1()
	{
		System.out.println("A m1");
		printAM2();
		printAM3();
	}
	
	

}
