package com.kurshit.Multithreading;

public class ThreadCreationDemo extends Thread 
{
	public void run ()
	{
		System.out.println("Inside first run method");
	}
	
	public static void main(String[] args) {
		
		ThreadCreationDemo tcd = new ThreadCreationDemo();
		tcd.start();
		
		

	}

}
