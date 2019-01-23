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
 * This simple examples shows how once thread can be used to handle two different tasks (without any delays applied & exceptions thrown).
 * The thread would take another task in hand only after finishing off the first task
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		//ExecutorService service = Executors.newFixedThreadPool(1);  // replacing above line with this is same.. no change
		
		service.submit(new MyRunnableSTEE1());
		
		service.submit(new MyRunnableSTEE2());
				
	}

}

class MyRunnableSTEE1 implements Runnable
{
	public void run()
	{
		
		for(int i = 0; i<20; i++)
		{
			System.out.println(i + " -->  " + Thread.currentThread().getName());
				
		}	
	}
}

class MyRunnableSTEE2 implements Runnable
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
 *  First it will print all numbers from first task, then only will finish other task of printing last twenty numbers
 * 
 */

/*
 * Output :
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


