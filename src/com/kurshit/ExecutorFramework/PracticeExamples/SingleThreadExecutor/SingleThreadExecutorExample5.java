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
 * This examples shows how once thread can be used to handle two different tasks using execute() with exception thrown and exception is handled in run().
 * Also shows the use of Future object
 * The thread would run one task at a time when it is idle
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample5 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		//ExecutorService service = Executors.newFixedThreadPool(1);  // replacing above line with this is same.. no change
		
		service.execute(new MyRunnableSTEE51()); // submit is replaced with execute
		
		service.execute(new MyRunnableSTEE52());			
		
		
				
	}

}

class MyRunnableSTEE51 implements Runnable 
{
	public void run()
	{
			for(int i = 0; i<20; i++)
			{
				System.out.println(i + " -->  " + Thread.currentThread().getName());
				
				if(i == 10)
					throw new IllegalArgumentException(); // exception is thrown but not handled
					
			}
	
			
	}
}

class MyRunnableSTEE52 implements Runnable
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
 * ( Notice output in next comment section - it throws an exception )
 * Exception is thrown in run method but is not handled - in such cases, the thread will STOP abruptly if execute is used. Unlike submit(), 
 * which supresses the exception. 
 * execute() v.s submit() :
 * 1. The difference is that execute doesn't return a Future but submit() does,
 * so you can't wait for the completion of the Runnable and get any exception it throws using that. 
 * 2. execute(Runnable) is that submit(...) can accept a Callable<V> (whereas execute() accepts only Runnable) 
 * and returns an instance of Future<V>, which you can use later in the caller to retrieve the result asynchronously 
 * (potentially blocking until the computation performed by the Callable is completed).
 */

/*
  0 -->  pool-1-thread-1
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
21 -->  pool-1-thread-2
22 -->  pool-1-thread-2
23 -->  pool-1-thread-2
24 -->  pool-1-thread-2
25 -->  pool-1-thread-2
26 -->  pool-1-thread-2
27 -->  pool-1-thread-2
28 -->  pool-1-thread-2
29 -->  pool-1-thread-2
30 -->  pool-1-thread-2
31 -->  pool-1-thread-2
32 -->  pool-1-thread-2
33 -->  pool-1-thread-2
34 -->  pool-1-thread-2
35 -->  pool-1-thread-2
36 -->  pool-1-thread-2
37 -->  pool-1-thread-2
38 -->  pool-1-thread-2
39 -->  pool-1-thread-2
Exception in thread "pool-1-thread-1" java.lang.IllegalArgumentException
	at com.kurshit.ExecutorFramework.PracticeExamples.SingleThreadExecutor.MyRunnableSTEE51.run(SingleThreadExecutorExample5.java:51)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:748)

 *  
 */


