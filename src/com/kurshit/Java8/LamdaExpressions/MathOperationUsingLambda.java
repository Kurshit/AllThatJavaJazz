package com.kurshit.Java8.LamdaExpressions;

public class MathOperationUsingLambda
{

	public static void main(String[] args)
	{
		MyInterface mi = new MyInterface()
		{
			public int operation(int a, int b)
			{
				return a+b;
			}
		};
		
		int result = mi.operation(4, 5);
		
		System.out.println(result);
		
		
		int anotherResult = new MyInterface()
		{
			public int operation(int a, int b)
			{
				return a+b;
			}
		}.operation(4, 5);
		
		
		System.out.println(anotherResult);
		
		// 1. performs addition
		MyInterface f = (int a, int b) -> (a+b);
		System.out.println(f.operation(3, 3));
		//using type inference -- avoid types of arg
		MyInterface f1 = (a,b) -> a*b;
		
		System.out.println(f1.operation(4, 6));
		
		MyInterface f2 = (int a, int b) -> (a-b);
		System.out.println(f2.operation(10, 3));
		
		
		
		
		//System.out.println(yetAnotherResult);
		
		
		
		
	}

}

interface MyInterface
{
	int operation(int a, int b);
}
