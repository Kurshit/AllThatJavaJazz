package com.kurshit.Multithreading.InterThreadCommunication;

public class PingPongExample {

	static DisplayPing ping = new DisplayPing();
	static DisplayPong pong = new DisplayPong();
	static Thread th1 = new Thread(ping);
	static Thread th2 = new Thread(pong);
	static boolean isFirstCalled = false;
	public static void main(String[] args) {
		
		th1.setPriority(10);
		th1.start();
		th2.start();
		
		
		
	}
	
	

}

class DisplayPing implements Runnable
{
	public void run()
	{
		try
		{
			while(true)
			{
				System.out.println("PING");
				PingPongExample.th2.join(1000);
			}
		}
		catch(Exception e)
		{
			
		}
		
		
	}
	
}

class DisplayPong implements Runnable
{
	public void run()
	{

		try
		{
			while(true)
			{
				System.out.println("PONG");
				PingPongExample.th1.join(1000);
				
			}
		}
		catch(Exception e)
		{
			
		}
		
		
	
	}
}


