package com.kurshit.Multithreading;

public class ThreadWithDifferentState extends Thread
{
	int x;
	
	public void run()
	{
		for(int i =1; i<= this.x; i++)
		{
			System.out.println(" Name:" +getName() + " and i :" +i);
		}
		
	}
	
	public ThreadWithDifferentState(int x) 
	{
		this.x = x;
	}
	public static void main(String[] args) 
	{
		ThreadWithDifferentState twds1 = new ThreadWithDifferentState(10);
		twds1.start();
		ThreadWithDifferentState twds2 = new ThreadWithDifferentState(20);
		twds2.start();
		
	}

}
