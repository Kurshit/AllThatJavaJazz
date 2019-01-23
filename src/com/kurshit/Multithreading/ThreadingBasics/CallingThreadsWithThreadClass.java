package com.kurshit.Multithreading.ThreadingBasics;

public class CallingThreadsWithThreadClass {
	
	public static void main(String[] args) 
	{
		ThreadExample th1 = new ThreadExample();
		th1.start();

	}

}

class ThreadExample extends Thread 
{
	public void run()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println(Thread.currentThread() + " : " +i);
		}
	}
}
