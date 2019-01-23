package com.kurshit.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor1
{

	public static void main(String[] args)
	{
		PrintJob[] jobs = {new PrintJob("Kurshit"),
						   new PrintJob("Ravi"),
						   new PrintJob("Sagar")};
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		for(PrintJob job :jobs)
		{
			service.submit(job);
		}

	}

}

class PrintJob implements Runnable
{
	String name;
	
	PrintJob(String name)
	{
		this.name = name;
	}
	
	public void run()
	{
		try
		{
			System.out.println("Thread :" +Thread.currentThread().getName() + " Name :"  +name);
			
			Thread.sleep(3000);
		}
		catch(InterruptedException e){}
		
		System.out.println("Commpleted : " + "Thread :" +Thread.currentThread().getName() + " Name :"  +name);
		
	}
}
