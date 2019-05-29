package com.kurshit.Multithreading.ThreadingBasics;

import java.util.concurrent.TimeUnit;

public class EffectiveJava {

	/** The stop requested. */
	//private static boolean stopRequested;
	private static int stopRequested = 0;
	
	public static void main(String[] args) throws InterruptedException {
			
		/*	Thread r = new Thread(new Runnable() {
				public void run() {
					int i = 0;
					while(stopRequested == 0)
						i++;
					
					System.out.println("Stopped");
				}
			});
		*/
		
		Thread r = new Thread(() -> {
				int i = 0;
				while(stopRequested == 0)
					i++;
				
				System.out.println("Stopped");
			});
		
		
		r.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("After sleep");
		//stopRequested = true;
		stopRequested = 1;
		
		System.out.println("after changing var : " +stopRequested);

	}
	


}
