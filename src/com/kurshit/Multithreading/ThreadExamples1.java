package com.kurshit.Multithreading;

import java.util.stream.IntStream;

public class ThreadExamples1 extends Thread {
		
	public void run()
	{
		/*for(int i =1; i<=10; i++)
		{
			System.out.println("run :"+i);
		}*/
		
		IntStream.rangeClosed(1, 10)
			.forEach(n->System.out.println(n));
		
	}
	public static void main(String[] args) 
	{
		ThreadExamples1 te1 = new ThreadExamples1();
		
		te1.start();
		te1.run();

	}

}
