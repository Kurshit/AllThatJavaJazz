package com.kurshit.interview;

public class SharedResource {
	
	public static boolean changeRequested = false;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while(!changeRequested) {
					i++;
				}
				
				System.out.println("So done with boring while loop ");
			}
		});
		
		backgroundThread.start();
		
		Thread.sleep(2000);
		changeRequested = true;
		System.out.println("Finised");
		
		
		
		
		
		
		
		
		

	}

}
