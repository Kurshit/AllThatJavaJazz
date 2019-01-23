package com.kurshit.Multithreading;

public class ThreadCreationWithRunnable implements Runnable
{
	public void run()
	{
		System.out.println("Inside seecond run method");
	}
	public static void main(String[] args) 
	{
		ThreadCreationWithRunnable tcwr = new ThreadCreationWithRunnable();
		Thread th = new Thread(tcwr);
		th.start();
		

	}

}
