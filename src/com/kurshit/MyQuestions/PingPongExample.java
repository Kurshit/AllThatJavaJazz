//Pring PING then PONG alternatively for 20 secs using two threads
//Solution : 1. Using ScheduleExecutor normally
// 2. Using Scheduled Executoer with Lambda

package com.kurshit.MyQuestions;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class PingPongExample
{
	
	public static void main(String[] args) throws InterruptedException
	{
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		service.scheduleAtFixedRate(() -> System.out.println("PING"), 0, 2, TimeUnit.SECONDS);
		service.scheduleAtFixedRate(() -> System.out.println("PONG"), 1, 2, TimeUnit.SECONDS);
		
		
		Thread.sleep(20000);
		
		service.shutdown();
		
		

	}


}

