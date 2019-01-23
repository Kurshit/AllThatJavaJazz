package com.kurshit.Java8.LamdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo
{

	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("using regular iterative for loop");
		
		for(int i = 0; i<list.size(); i++)
		{
			System.out.print(list.get(i) + " ");
		}
		
		System.out.println();
		System.out.println( " using advanced for loop = imperative style");
		for(int i : list)
		{
			System.out.print(i + " ");
		}
		
		list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t)
			{
				System.out.print( t + " ");
				
			}
		});
		
		System.out.println();
		System.out.println("using forEach loop - function style");
		
		list.forEach(values->System.out.println(values + " "));
		
		System.out.println( " using method reference");
		list.forEach(System.out::println);
		
		Thread th = new Thread(()-> System.out.println("in run"));
		th.start();
	
	
	}
	
	

}
