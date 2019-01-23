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
 * This examples shows how once thread can be used to handle two different tasks with exception thrown and exception is handled in run().
 * Also shows the use of Future object
 * The thread would run one task at a time when it is idle
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutorExample4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		//ExecutorService service = Executors.newFixedThreadPool(1); // replacing above line with this is same.. no change
		
		Future result1 = service.submit(new MyRunnableSTEE41());
		
		Future result2 = service.submit(new MyRunnableSTEE42());			
		
		System.out.println(result1.get()); 	// This get() would throw the exception occured in task1
		System.out.println(result2.get());
		
		System.out.println(result1.isDone()); // this would return null in this case, since exception has been handled
		System.out.println(result1.isCancelled());
		
		System.out.println(result2.isDone());
		System.out.println(result2.isCancelled());
		
	}

}

class MyRunnableSTEE41 implements Runnable 
{
	public void run()
	{
		try
		{
			for(int i = 0; i<20; i++)
			{
				System.out.println(i + " -->  " + Thread.currentThread().getName());
				
				if(i == 10)
					throw new IllegalArgumentException(); // exception is thrown but not handled
					
			}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Handled the exception");
		}
			
	
			
	}
}

class MyRunnableSTEE42 implements Runnable
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
 * ( Notice output in next comment section - it has skipped printing values after 10 )
 * Exception is thrown in run method but is not handled - in such cases, the thread will not stop abruptly. Exception will be bypassed.
 * For Callable objects, there is a method in Future object to get returned result of call(). get() is that method which returns 
 * result after running call(). 
 * But in case of run(), which does not return any result, so if Future.get() returns null - it would mean task executed successfully
 * else if task had got some exception and exception was NOT handled, The "future.get()" - get() itself will throw an exception 
 * that occured in task - IllegalArgException in this case. 
 * 
 * But in this case, since the exception is handled and run method resturns null, this will not stop abruptly, and result1.get()
 * would NOT throw an exception this time. It would resturn null 
 *  
 * 
 */

/*
 * Output : skipped after 10th no
 *  
 *	0 -->  pool-1-thread-1
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
Handled the exception
null
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
null
true
false
true
false
  
 *  
 */


