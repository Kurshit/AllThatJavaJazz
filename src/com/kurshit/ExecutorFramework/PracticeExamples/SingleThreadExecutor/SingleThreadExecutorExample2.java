package com.kurshit.ExecutorFramework.PracticeExamples.SingleThreadExecutor;

/*Title: Executor framework in Java
 * Sources : -- 
 * Author : --
 * Refer Notes : Executor Framework in Java
 * Loc : D:\Kurshit\All owned notes\Executor framework\
 * Eclipse :  Survival\src\com\kurshit\ExecutorFramework\PracticeExamples
 *  
 */


/*
 * This examples shows how once thread can be used to handle two different tasks with some delays applied but NO exceptions thrown).
 * The thread would one task at a time when it is idle
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		//ExecutorService service = Executors.newFixedThreadPool(1); // replacing above line with this is same.. no change
		
		service.submit(new MyRunnableSTEE21());
		
		service.submit(new MyRunnableSTEE22());
		
		
	}

}

class MyRunnableSTEE21 implements Runnable 
{
	public void run()
	{
		try
		{
			for(int i = 0; i<20; i++)
			{
				Thread.sleep(1000);
				System.out.println(i + " -->  " + Thread.currentThread().getName());
					
			}
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
			
	}
}

class MyRunnableSTEE22 implements Runnable
{
	public void run()
	{
		
		for(int i = 21; i<40; i++)
		{
			System.out.println(i + " -->  " + Thread.currentThread().getName());
		}		
	}
} 

/*
 * ( Notice output in next comment section )
 * 
 *  Even if we have given  a delay using sleep(), 
 *  it would not pass over the control to another task, because thread is same only. How can it itself go to sleep and do another task ?
 *  It would first finish off first task and then will go to second task.
 * 
 */

/*
 * Output : with delay of 2 sec for first 20 no's
 *  0 -->  pool-1-thread-1
1 -->  pool-1-thread-1
2 -->  pool-1-thread-1
3 -->  pool-1-thread-1
4 -->  pool-1-thread-1
5 -->  pool-1-thread-1
6 -->  pool-1-thread-1
7 -->  pool-1-thread-1
8 -->  pool-1-thread-1
9 -->  pool-1-thread-1
10 -->  pool-1-thread-1
11 -->  pool-1-thread-1
12 -->  pool-1-thread-1
13 -->  pool-1-thread-1
14 -->  pool-1-thread-1
15 -->  pool-1-thread-1
16 -->  pool-1-thread-1
17 -->  pool-1-thread-1
18 -->  pool-1-thread-1
19 -->  pool-1-thread-1
21 -->  pool-1-thread-1
22 -->  pool-1-thread-1
23 -->  pool-1-thread-1
24 -->  pool-1-thread-1
25 -->  pool-1-thread-1
26 -->  pool-1-thread-1
27 -->  pool-1-thread-1
28 -->  pool-1-thread-1
29 -->  pool-1-thread-1
30 -->  pool-1-thread-1
31 -->  pool-1-thread-1
32 -->  pool-1-thread-1
33 -->  pool-1-thread-1
34 -->  pool-1-thread-1
35 -->  pool-1-thread-1
36 -->  pool-1-thread-1
37 -->  pool-1-thread-1
38 -->  pool-1-thread-1
39 -->  pool-1-thread-1

 *  
 */


