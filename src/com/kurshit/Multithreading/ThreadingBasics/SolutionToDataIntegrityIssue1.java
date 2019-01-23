package com.kurshit.Multithreading.ThreadingBasics;

import java.util.stream.IntStream;

/* This program demonstarates the solution to problem described in DataIntegrityIssue1 file
 * Class Name MyCriticalSection1 (of problem file DII1.java) has been changed to MyCriticalSectionSolution1
 * 
 * THis also shows practical proof of volatile keyword
 * 
 * IMP : Read all inline comments.. each and every
 *  */
/*
 * Solutions :
 * 1. Using synchronized method changeNumber() or writing its code in synchronized block - this will make output "Changed" to be printed just once.
 * 2. making the number variable as volatile : doing this in the output you would get "changed" for first few threads - as few threads might have read
 * this value (value = 0) from memory already. But when one of the threads changed its value to 1 - this will be visible to all other threads and hence, 
 * after first "Not" Changed", rest all output will be "Not Changed". observer the ooutput for solution 1 and two and original problem 
 */

public class SolutionToDataIntegrityIssue1 
{
	public static void main(String[] args) throws InterruptedException 
	{
		final MyCriticalSectionSolution1 r1 = new MyCriticalSectionSolution1();
		
		for(int i =0; i<30; i++)
		{
			new Thread(r1).start();
		}
		
		
				
	}


}

class MyCriticalSectionSolution1 implements Runnable
{
	volatile int number=0;
	//volatile int number = 0; // try this solution 2 by uncommenting this
	
	public void run()
	{
		this.changeNumber();
	}
	
	//solution can be achived by making this method as synchronized or writing code in synchonized block as commented here
	  void changeNumber()
	  {
		 //synchronized(this)
		 //{
			 if(number == 0)
		 	 {
		  			System.out.println(Thread.currentThread() + " : " + "|| Changed");
					number = -1;
					//System.out.println(Thread.currentThread() + " : " + "|| Changed");
					/*
					 * Writing the sysout statement after number = -1 will make a lot of diff in output. Please try this out
					 * 
					 */
					
				}
				else
				{
					System.out.println(Thread.currentThread() + " : " + " || Not Changed");
				}
		 //}
		 
	}
}

/*
 * Original Output :
 * Thread[Thread-0,5,main] : || Changed
Thread[Thread-3,5,main] : || Changed
Thread[Thread-2,5,main] : || Changed
Thread[Thread-1,5,main] : || Changed
Thread[Thread-6,5,main] :  || Not Changed
Thread[Thread-5,5,main] :  || Not Changed
Thread[Thread-8,5,main] :  || Not Changed
Thread[Thread-4,5,main] : || Changed
Thread[Thread-7,5,main] :  || Not Changed
Thread[Thread-9,5,main] :  || Not Changed
Thread[Thread-10,5,main] :  || Not Changed
Thread[Thread-11,5,main] :  || Not Changed
Thread[Thread-12,5,main] :  || Not Changed
Thread[Thread-13,5,main] :  || Not Changed
Thread[Thread-14,5,main] :  || Not Changed
Thread[Thread-15,5,main] :  || Not Changed
Thread[Thread-16,5,main] :  || Not Changed
Thread[Thread-19,5,main] :  || Not Changed
Thread[Thread-17,5,main] :  || Not Changed
Thread[Thread-18,5,main] :  || Not Changed
Thread[Thread-21,5,main] :  || Not Changed
Thread[Thread-20,5,main] :  || Not Changed
Thread[Thread-23,5,main] :  || Not Changed
Thread[Thread-22,5,main] :  || Not Changed
Thread[Thread-25,5,main] :  || Not Changed
Thread[Thread-24,5,main] :  || Not Changed
Thread[Thread-26,5,main] :  || Not Changed
Thread[Thread-27,5,main] :  || Not Changed
Thread[Thread-28,5,main] :  || Not Changed
Thread[Thread-29,5,main] :  || Not Changed


diff output can come every time
 * 
 * 
*/