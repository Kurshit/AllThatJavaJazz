package com.kurshit.ExecutorFramework.PracticeExamples.FixedThreadPool;

/*Title: Executor framework in Java
 * Sources : -- 
 * Author : --
 * Refer Notes : Executor Framework in Java
 * Loc : D:\Kurshit\All owned notes\Executor framework\
 * Eclipse :  Survival\src\com\kurshit\ExecutorFramework\PracticeExamples
 *  
 */

/*
 * This simple examples shows how different independant tasks can be handed over to worker threads in thread pool of fixed size, 
 * and tasks are executed asynchrnously. This is simple example with exception in run() and not caught/handled.
 * This is same as scenarios seen in single thread executor. i.e for submit(), exception would be suppressed even if not handled.
 * If used execute() instead of submit() - exception would be thrown
 * 
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample2 {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		service.submit(new MyRunnableFTPE21());
		service.submit(new MyRunnableFTPE22());
		service.submit(new MyRunnableFTPE23());
		
		/* Since we have only two threads in pool and 3 tasks, whichever thread gets free after finishing off its task,
		 * that thread will take up task 3 and would execute it asynchrounouly. 
		 */

	}

}

class MyRunnableFTPE21 implements Runnable
{
	public void run()
	{
		
		for(int i = 0; i<20; i++)
		{
			System.out.println(i + " -->  " + Thread.currentThread().getName());
			
			if(i == 10)
				throw new IllegalArgumentException();
		}	
	}
}

class MyRunnableFTPE22 implements Runnable
{
	public void run()
	{
		
		for(int i = 21; i<40; i++)
		{
			System.out.println(i + " -->  " + Thread.currentThread().getName());
		}		
	}
} 

class MyRunnableFTPE23 implements Runnable
{
	public void run()
	{
		
		for(int i = 21; i<40; i++)
		{
			System.out.println(i + " -->  " + Thread.currentThread().getName());
		}		
	}
} 

/* Output :
 * Mixed output : 
*/	