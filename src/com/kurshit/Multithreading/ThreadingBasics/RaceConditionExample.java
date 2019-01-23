package com.kurshit.Multithreading.ThreadingBasics;

public class RaceConditionExample implements Runnable 
{
	public void run()
	{
		for(int i=0; i<9; i++)
		{
			System.out.println(Thread.currentThread() + " : " +i);
		}
	}
	
	public static void main(String[] args) 
	{
		RaceConditionExample r1 = new RaceConditionExample();
		Thread th1 = new Thread(r1);
		th1.start();
		Thread th2 = new Thread(r1);
		th2.start();
		
		/* Above code will produce the mixed output executing the same logic
		 * This is an example of race condition : the output will have significant diff based on which threads gets in when
		 * */
		
	}
	

}



