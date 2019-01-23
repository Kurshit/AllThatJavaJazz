package com.kurshit.ExecutorFramework.PracticeExamples.SingleThreadScheduledExecutor;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*Title: Executor framework in Java
 * Sources : -- 
 * Author : --
 * Refer Notes : Executor Framework in Java
 * Loc : D:\Kurshit\All owned notes\Executor framework\
 * Eclipse :  Survival\src\com\kurshit\ExecutorFramework\PracticeExamples
 *  
 */

/*
 * 
 */

public class SingleThreadScheduledExecutorExample1 {

	public static void main(String[] args) throws InterruptedException {
		
		ScheduledExecutorService service1 = Executors.newSingleThreadScheduledExecutor();
		//ScheduledExecutorService service2 = Executors.newSingleThreadScheduledExecutor();
		
		//service1.scheduleAtFixedRate(new MyRunnableSTSEE1(), 0, 1, TimeUnit.MINUTES);
		//service2.scheduleAtFixedRate(new MyRunnableSTSEE2(), 10, 60, TimeUnit.SECONDS);	
		
		service1.scheduleWithFixedDelay(new MyRunnableSTSEE1(), 0, 1, TimeUnit.MINUTES);
		
		service1.scheduleWithFixedDelay(new MyRunnableSTSEE2(), 10, 60, TimeUnit.SECONDS);
		
		
		
		
	

	}

}

class MyRunnableSTSEE1 implements Runnable
{
	public void run()
	{
		
		System.out.println(new Date() + " start making coffee");
				
			
	}
}

class MyRunnableSTSEE2 implements Runnable
{
	public void run()
	{
		
		System.out.println(new Date() + " finish making coffee");
				
	}
} 

