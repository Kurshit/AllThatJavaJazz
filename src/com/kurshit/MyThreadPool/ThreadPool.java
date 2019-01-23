package com.kurshit.MyThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool
{
	private  BlockingQueue taskQueue = null;
	private List<PoolThread> threads = new ArrayList<PoolThread>();
	private boolean isStopped = false;
	
	public ThreadPool(int noOfThreads, int maxNoOfTasks)
	{
		taskQueue = new ArrayBlockingQueue(maxNoOfTasks);
		
		for(int i = 0; i<noOfThreads; i++)
		{
			threads.add(new PoolThread(taskQueue));
		}
		
		for(PoolThread pt : threads)
		{
			pt.start();
		}
		
	}
	
	public synchronized void execute(Runnable task) throws Exception
	{
		if(this.isStopped)
			throw new IllegalThreadStateException("Thread Pool is stopped");
		
		this.taskQueue.offer(task);
	}
	
	public synchronized void stop()
	{
		this.isStopped = true;
		for(PoolThread pt : threads)
		{
			pt.doStop();
		}
	}


}


class PoolThread extends Thread
{
	private BlockingQueue taskQueue = null;
	private boolean isStopped = false ;
	
	public PoolThread(BlockingQueue queue)
	{
		this.taskQueue = queue;
	}
	
	public void run()
	{
		while(!isStopped())
		{
			try
			{
				Runnable runnable = (Runnable) taskQueue.poll();
				runnable.run();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void doStop()
	{
		isStopped = true;
		System.out.println("shutdown initiated");
		//this.interrupt(); //breaks pull thread
	}
	
	public synchronized boolean isStopped()
	{
		return isStopped;
	}
}