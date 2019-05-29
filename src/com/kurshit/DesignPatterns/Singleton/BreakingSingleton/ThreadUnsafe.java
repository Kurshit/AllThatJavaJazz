package com.kurshit.DesignPatterns.Singleton.BreakingSingleton;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.kurshit.DesignPatterns.Singleton.LazyInitialization;

public class ThreadUnsafe {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		//make LazyInitialization's getInstance method non-synchronized before running this
		
		Callable<LazyInitialization> call1 = () -> LazyInitialization.getInstance();
		Callable<LazyInitialization> call2 = () -> LazyInitialization.getInstance();
		Callable<LazyInitialization> call3 = () -> LazyInitialization.getInstance();
		Callable<LazyInitialization> call4 = () -> LazyInitialization.getInstance();
		Callable<LazyInitialization> call5 = () -> LazyInitialization.getInstance();
		
		List<Callable<LazyInitialization>> callables = Arrays.asList(call1, call2, call3, call4, call5);
		List<Future<LazyInitialization>> invokeAll = service.invokeAll(callables);
		
		for(Future<LazyInitialization> e : invokeAll) {
			System.out.println(e.get());
		}
		
		/*GetInstanceRunnable runnable = new GetInstanceRunnable();
		
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);
		Thread t4 = new Thread(runnable);
		Thread t5 = new Thread(runnable);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();*/
		
	}

}

class GetInstanceRunnable implements Runnable {

	@Override
	public void run() {
					
		try {
			System.out.println(LazyInitialization.getInstance());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
