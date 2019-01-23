package com.kurshit.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduledThreadPool1
{

	public static void main(String[] args)
	{
		ScheduledTPJob[] jobs = {new ScheduledTPJob("Kurshit"),
						   new ScheduledTPJob("Ravi"),
						   new ScheduledTPJob("Sagar")};
	
		ScheduledTPJob2[] jobs2 = {new ScheduledTPJob2("Kuku"),
				   new ScheduledTPJob2("Ravu"),
				   new ScheduledTPJob2("Sagu")};
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		
		for(ScheduledTPJob job :jobs)
		{
			service.submit(job);
		}
		
		for(ScheduledTPJob2 job :jobs2)
		{
			service.submit(job);
		}
		
		service.shutdown();
	}

}


class ScheduledTPJob implements Runnable
{
	String name;
	
	ScheduledTPJob(String name)
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

class ScheduledTPJob2 implements Runnable
{
	String name;
	
	ScheduledTPJob2(String name)
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
