package com.kurshit.Multithreading.ThreadingBasics;

public class RaceConditionExample1 {

	public static void main(String[] args) {
		
		MyRaceConditionExample1 r1 = new MyRaceConditionExample1();
		Thread th1 = new Thread(r1);
		th1.start();
		
		/*Thread th2 = new Thread(r1);
		th2.start();*/   //uncomment n see output as per below
		
		/* Since the two threads th1 & th2 are called on Same runnable obect "r1", the output is mixed and race condition occurs.
		 * Uncomment th2 above to see its working
		 * If we call two threads on different runnable objects, the output would still be mixed, because tits assumed that the run() is independently run
		 * simultaneously. This will not affect data integrity. Its just in background, these two threads would continue to run. Even if you make methods static, 
		 * output would be same  
		 */
		
		MyRaceConditionExample1 r2 = new MyRaceConditionExample1();
		Thread th2 = new Thread(r2);
		th2.start();
		
		

	}

}

class MyRaceConditionExample1 implements Runnable
{
		
	public void run()
	{
		this.runTheLoop();
	}
	
	private void runTheLoop ()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println(Thread.currentThread() + " : "+i);
		}
	}
	
	
	
}
