package com.kurshit.Multithreading.ThreadingBasics;

public class DataIntegrityIssue1 {

	public static void main(String[] args) throws InterruptedException 
	{
		final MyCriticalSection1 r1 = new MyCriticalSection1();
		for(int i =0; i<30; i++)
		{
			new Thread(r1).start();;
		}
		
		/*
		 * Out put is very compromised : The intention of changeNumber() was to change its value just ONCE and thats it.
		 * Logically, "Changed" output string should have come only once, but which ic not the case. Reason, multiple threads had read the value
		 * of changeNumber variable at a single time and while others change it, th value which was read before becomes invalid
		 * 
		 * Solution : Refer solution in class SolutionToIntegrity1
		 */
	}

}


class MyCriticalSection1 implements Runnable
{
	int number=0;
	
	public void run()
	{
		this.changeNumber();
	}
	
	void changeNumber()
	{
		if(number == 0)
		{
			System.out.println(Thread.currentThread() + " : " + "|| Changed");
			number = -1;
		}
		else
		{
			System.out.println(Thread.currentThread() + " : " + " || Not Changed");
		}
	}
}
