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
 * and tasks are executed asynchrnously. This is simple example with no delays or exceptions.
 * 
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample1 {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		service.submit(new MyRunnableFTPE11());
		service.submit(new MyRunnableFTPE12());
		service.submit(new MyRunnableFTPE13());
		
		/* Since we have only two threads in pool and 3 tasks, whichever thread gets free after finishing off its task,
		 * that thread will take up task 3 and would execute it asynchrounouly. 
		 */

	}

}

class MyRunnableFTPE11 implements Runnable
{
	public void run()
	{
		
		for(int i = 0; i<20; i++)
		{
			System.out.println(i + " -->  " + Thread.currentThread().getName());
				
		}	
	}
}

class MyRunnableFTPE12 implements Runnable
{
	public void run()
	{
		
		for(int i = 21; i<40; i++)
		{
			System.out.println(i + " -->  " + Thread.currentThread().getName());
		}		
	}
} 

class MyRunnableFTPE13 implements Runnable
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