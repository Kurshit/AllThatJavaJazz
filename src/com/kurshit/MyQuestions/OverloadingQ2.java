package com.kurshit.MyQuestions;


public class OverloadingQ2 {

	public void add(int a, int b)
	{
		System.out.println("In int method :" +a+b );
	}
	
	public void add(short a, short b)
	{
		System.out.println("In short method :" +a+b );
	}
	
	public void add(double a, double b)
	{
		System.out.println("In double method :" +a+b );
	}
	
	
	
	public static void main(String[] args) 
	{
		OverloadingQ2 obj = new OverloadingQ2();
		obj.add(1.0, 1.0);
		obj.add(1, 1);
		obj.add((short)1,(short) 1);

	}

}
