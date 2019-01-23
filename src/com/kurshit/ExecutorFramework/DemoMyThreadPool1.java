package com.kurshit.ExecutorFramework;

import java.util.concurrent.Executors;

import com.kurshit.MyThreadPool.ThreadPool;

public class DemoMyThreadPool1
{

	public static void main(String[] args) throws Exception
	{
		MyThreadPoolJob[] jobs = {new MyThreadPoolJob("Kurshit"),
						   new MyThreadPoolJob("Ravi"),
						   new MyThreadPoolJob("Sagar")};
	
		
		ThreadPool service = new ThreadPool(2, 3);
		
		/*for(MyThreadPoolJob job :jobs)
		{
			service.execute(job);
		}*/
		
		service.execute(new MyThreadPoolJob("Kurshit"));
		service.execute(new MyThreadPoolJob("kuku"));
		service.execute(new MyThreadPoolJob("Kurs"));
		//Thread.sleep(4000);
		service.stop();
	}

}


class MyThreadPoolJob implements Runnable
{
	String name;
	
	MyThreadPoolJob(String name)
	{
		this.name = name;
	}
	
	public void run()
	{
		try
		{
			System.out.println("Thread :" +Thread.currentThread().getName() + " Name :"  +name);
			
			Thread.sleep(300);
		}
		catch(Exception e){}
		
		System.out.println("Commpleted : " + "Thread :" +Thread.currentThread().getName() + " Name :"  +name);
		
	}
}

