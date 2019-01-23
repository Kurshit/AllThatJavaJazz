// This is Producer COnsumer Problem SOlution using wait,notify, notifyAll methods

package com.kurshit.Multithreading;

import java.util.ArrayList;

public class ProducerConsumerSolution1
{

	public static void main(String[] args)
	{
		ArrayList sharedList = new ArrayList();
		int size = 5;
		Producer1 produce = new Producer1(sharedList,size);
		Consumer1 consume = new Consumer1(sharedList,size);
		Thread producerThread = new Thread(produce, "Producer");
		Thread consumerThread = new Thread(consume, "Consumer");
		producerThread.start();
		consumerThread.start();		

	}

}

class Producer1 implements Runnable
{
	private final ArrayList sharedList;
	private final int SIZE;
	
	public Producer1(ArrayList sharedList, int size)
	{
		this.sharedList = sharedList;
		this.SIZE = size;
	}
	
	public void run()
	{
		for(int i = 1; i<=10; i++)
		{
			
			try
			{
				produce(i);
				System.out.println("Produced : " + i);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void produce(int i) throws InterruptedException
	{
		//wait if list  if full and let consumer consume the item from list
		synchronized(sharedList)
		{
			while(sharedList.size() == SIZE)
			{
				//synchronized(sharedList)
				//{
					System.out.println("List is full :" +Thread.currentThread().getName() + " is waiting, size >> " + sharedList.size());
					sharedList.wait();
				
			//	}
				
			}
		}
		
		
		//once item is consumed.. produce the item
		
		synchronized(sharedList)
		{
			sharedList.add(i);
			sharedList.notifyAll();
		}
		
	}
}

class Consumer1 implements Runnable
{
	private final ArrayList sharedList;
	private final int SIZE;
	
	public Consumer1(ArrayList sharedList, int size)
	{
		this.sharedList = sharedList;
		this.SIZE = size;
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				consume();
				//System.out.println("Consumed : " + consume());
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	private void consume() throws InterruptedException
	{
		//wait if List is empty -- let producer produce the items
		
		synchronized(sharedList)
		{
			while(sharedList.isEmpty())
			{
				//synchronized(sharedList)
				//{
					System.out.println("List is empty :" +Thread.currentThread().getName() + " is waiting, size >>" + sharedList.size());
					sharedList.wait();
				//}
			}
		}	
		
		
		//Once produced, consume the item
		
		synchronized (sharedList)
		{
			sharedList.notifyAll();
			System.out.println("Consumed :" + sharedList.remove(0));
			//return (int) sharedList.remove(0);
		}
		
	}
}


