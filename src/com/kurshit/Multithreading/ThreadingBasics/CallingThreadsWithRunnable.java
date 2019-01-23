package com.kurshit.Multithreading.ThreadingBasics;

public class CallingThreadsWithRunnable implements Runnable {

	
	public void run()
	{
		for(int i =0; i<10; i++)
		{
			System.out.println(Thread.currentThread() + " : " +i);
		}
	}
	
	
	public static void main(String[] args) 
	{
		CallingThreadsWithRunnable r1 = new CallingThreadsWithRunnable();
		
		//calling thread by passing runnable instance to theread class
		
		Thread th1 = new Thread(r1);
		th1.start();
		
		//calling thread by anonymous class passed to thread
		
		Thread th2 = new Thread(new Runnable()
					{
						public void run() {
							System.out.println("Anonymous class thread");
						}
					}); 
		th2.start();
		
		//calling thread using lambda expressions
		
		Thread th3 = new Thread(()->System.out.println("Thread created using lambda"));
		th3.start();
		
		

	}

}
