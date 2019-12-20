package com.kurshit.ConcurrentUtilities;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueue1
{

	public static void main(String[] args) throws Exception
	{
		BlockingQueue queue = new ArrayBlockingQueue(1024);
		Producer produce = new Producer(queue);
		Consumer consume = new Consumer(queue);
		new Thread(produce).start();
		new Thread(consume).start();
		Thread.sleep(5000);
	}

}

class Producer implements Runnable
{
	protected BlockingQueue queue = null;
	
	Producer(BlockingQueue queue)
	{
		this.queue = queue;
	}
	
	@Override
	public void run()
	{
		try
		{
			queue.offer(null);
			Thread.sleep(1000);
			queue.offer("2");
			Thread.sleep(1000);
			queue.offer("3");
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}	
	
}

class Consumer implements Runnable
{
	protected BlockingQueue queue = null;
	
	Consumer(BlockingQueue queue)
	{
		this.queue = queue;
	}
	
	public void run()
	{
		try
		{
			System.out.println(queue.poll());
			Thread.sleep(1000);
			System.out.println(queue.poll());
			System.out.println(queue.poll());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
