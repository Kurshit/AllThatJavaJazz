package com.kurshit.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool1
{

	public static void main(String[] args)
	{
		PrintJob[] jobs = {new PrintJob("Kurshit"),
						   new PrintJob("Ravi"),
						   new PrintJob("Sagar")};
		CachedThreadPoolJob[] jobs2 = {new CachedThreadPoolJob("Kuku"),
				   new CachedThreadPoolJob("Ravu"),
				   new CachedThreadPoolJob("Sagu")};
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		for(PrintJob job :jobs)
		{
			service.submit(job);
		}
		
		for(CachedThreadPoolJob job :jobs2)
		{
			service.submit(job);
		}
		
		service.shutdown();
	}

}

class CachedThreadPoolJob implements Runnable
{
	String name;
	
	CachedThreadPoolJob(String name)
	{
		this.name = name;
	}
	
	public void run()
	{
		try
		{
			System.out.println("Thread :" +Thread.currentThread().getName() + " Name :"  +name);
			
			Thread.sleep(6000);
		}
		catch(InterruptedException e){}
		
		System.out.println("Commpleted : " + "Thread :" +Thread.currentThread().getName() + " Name :"  +name);
		
	}
}
