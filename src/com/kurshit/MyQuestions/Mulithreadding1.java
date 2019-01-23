package com.kurshit.MyQuestions;

class Sample
{
	
	 public static void m1()
	{
		 synchronized(Sample.class)
		 {
			 for(int i=1; i<=100;i++)
				{
					System.out.println(Thread.currentThread().getName()+" :" + "in m1 "+i + " this is :" + " Sample.class is" + Sample.class);

				}

		 }
		 		 
	}
	
	 public  void  m2()
	{
		 synchronized(Sample.class)
		 {
			 for(int i=1; i<=100;i++)
				{
					System.out.println(Thread.currentThread().getName()+" :" + "in m2 "+i + " this is :" + " Sample.class is" + Sample.class);
				} 
		 }
	}	 	
				
	
	
}

class MyThread extends Thread
{
	Sample s;
	
	MyThread(Sample s)
	{
		this.s =s;
	}
	
	public void run()
	{
		s.m1();
	}
}
public class Mulithreadding1
{

	public static void main(String[] args)
	{
		Sample s1 = new Sample();
		Sample s2 = new Sample();
		MyThread t1 = new MyThread(s1);
		t1.start();
		s2.m1();
		
		try
		{
			s1.wait(100);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		

	}

}
