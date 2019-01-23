//Pring PING then PONG alternatively for 20 secs using two threads
//Solution : 1. Using ScheduleExecutor normally
// 2. Using Scheduled Executoer with Lambda

package com.kurshit.MyQuestions;


public class PingPongExampleUsingThreads
{
	static Object lock = new Object();
	public static void main(String[] args) throws InterruptedException
	{
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run()
			{
				synchronized(lock)
				{
					while(true)
					{
						try
						{
							lock.notify();
							System.out.println("PING");
							lock.wait();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable()
		{
			public void run()
			{
				synchronized(lock)
				{
					while(true)
					{
						try
						{
							lock.notify();
							System.out.println("PONG");
							lock.wait();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		//t1.join();
		//t2.join();
		
		
	}
}


/*
public class PingPongExampleUsingThreads
{
	
	public static void main(String[] args) throws InterruptedException
	{
		NewThread t1 = new NewThread("PING");
		NewThread t2 = new NewThread("PONG");
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		
		
	}
}

class NewThread extends Thread
{
	String input;
	NewThread(String input)
	{
		this.input = input;
	}
	
	public void run()
	{
		synchronized(this)
		{
			while(true)
			{
				
				System.out.println(input);
				try
				{
					Thread.sleep(2000);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
*/