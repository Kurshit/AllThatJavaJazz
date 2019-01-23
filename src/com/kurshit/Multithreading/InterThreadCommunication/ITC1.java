package com.kurshit.Multithreading.InterThreadCommunication;

class MyITC1
{
	void m1() throws InterruptedException
	{
		System.out.println("In m1 : " +Thread.currentThread().getName());
		Thread.sleep(5000);
		for(int i=0; i< 20; i++)
		{
			System.out.println(Thread.currentThread().getName() + " : "+i);
		}
	}
	
	void m2() throws InterruptedException
	{

		System.out.println("In m2 : " +Thread.currentThread().getName());
		Thread.sleep(10000);
		for(int i=21; i< 40; i++)
		{
			System.out.println(Thread.currentThread().getName() + " : "+i);
		}
	
	}
}

class MyITCThread1 extends Thread
{
	MyITC1 itc1;
	
	public MyITCThread1(MyITC1 obj) {
		itc1 = obj;
	}
	
	public void run()
	{
		try {
			itc1.m1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class ITC1 {

	public static void main(String[] args) throws InterruptedException {
		
		MyITC1 itc1 = new MyITC1();
		MyITCThread1 th1 = new MyITCThread1(itc1);
		MyITCThread1 th2 = new MyITCThread1(itc1);
		System.out.println("In main 1:" +Thread.currentThread().getName());
		th1.start();
		itc1.m1();
	}

}
