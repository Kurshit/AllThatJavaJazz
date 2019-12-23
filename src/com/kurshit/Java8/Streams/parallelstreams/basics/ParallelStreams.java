package com.kurshit.Java8.Streams.parallelstreams.basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {

	public static int transform(int number) {
		sleep(1000);
		return number * 1;
	}
	
	public static int transformObserveThread(int number) {
		System.out.println("t: " + number + "--" + Thread.currentThread());
		sleep(1000);
		return number * 1;
	}
	
	public static boolean sleep(int ms) {
		try {
			Thread.sleep(ms);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}	
	
	
	public static void useSequential(Stream<Integer> stream) {
		
		stream
			.map( e -> transform(e))
			.forEach(System.out :: println);
	}
	
	public static void useParallel(Stream<Integer> stream) {
		
		stream
			.parallel()
			.map( e -> transform(e))
			.forEach(System.out :: println);
	}
	
	
	public static void useMultiple(Stream<Integer> stream) {
		
		stream 
			.parallel()             // no op because of sequential(0 below
			.map( e -> transform(e))
			.sequential()
			.forEach(System.out :: println);
	}
	
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		
		/*
		 *	The following code would print numbers from 1 to 10 sequentially.
		 *	
		 *  In following example, we are creating the streams	
		 * 
		 */
				
		/*numbers.stream()
		 .map(e -> transform(e))
		.forEach(System.out :: println);*/
		
		/*
		 * There are to approaches to execute parallel code using streams
		 * 
		 * Approach 1: When we oursleves create the streams as below
		 */
		
		/*
		 * Following would print all numbers parallaly in 2-3 secs
		 */
		
		
		numbers.parallelStream()    // making it parallel while creating it
			.map(e -> transform(e))
			.forEach(System.out :: println);		
		
		
		/*
		 * Approach 2: When the streams are already been created and then we make it parallel as below - Sequential then parallel 
		 */
		
		/*
		 * 
		 */
		
		System.out.println("Aproach 2 - Sequential");
		useSequential(numbers.stream());
				
		System.out.println("\nAproach 2 - Parallel ----");
		
		useParallel(numbers.stream()); 
		
		/*
		 * In useParallel - even thought streams that were passed in were STREAM and not parallel stream, we can convert it to parallel. 
		 * Also, if streams were created as parallel streams and passed in to a function, we can change it to sequential()
		 */
		
		/*
		 * Tricky question - What if there are multiple streams called in use() like following -
		 * 
		 * What would be the output of it ? 
		 * 
		 * One might say - map would run parallely and forEach will run in sequential mode. 
		 * 
		 * Unfortunately this is not the case.
		 * 
		 * Ans: In this case, the very last one wins. This is goint to affect the behavioir of entire pipeline.
		 * 
		 * Just because we make it parallel, does not mean it will run parallely. The very last one is gonna win.
		 * 
		 *  The last one -? what does it mean here --
		 *  
		 *  Ans - the one before terminal operations. Termical operation is decisive factor and last call before terminal takes over and is executed.
		 * 
		 */
		
		System.out.println("\nMultiple streams called in - ");
		
		useMultiple(numbers.stream());
		
		/*
		 * Observing Threads - The following code would run sequentially in main thread itself
		 * 
		 */
		
		System.out.println("\nObserving the threads : ");
		numbers.stream()
				.map(e -> transformObserveThread(e))
				.forEach(e -> {});
		
		/*
		 * Output : 
		 * 	t: 1--Thread[main,5,main]
		 *	t: 2--Thread[main,5,main]
		 */
				
		/*
		 * Now making changes to run it parallaly using parallel streams -
		 * 
		 * This would run parallely in different threads
		 */
		
		System.out.println("\nObserving the threads using parallel streams : ");
		numbers.parallelStream()
				.map(e -> transformObserveThread(e))
				.forEach(e -> {});
		
		/*
		 * Output : 
		 * 
		 * t: 7--Thread[main,5,main]
		 *	t: 9--Thread[ForkJoinPool.commonPool-worker-3,5,main]
		 *	t: 3--Thread[ForkJoinPool.commonPool-worker-2,5,main]
		 * 
		 */
		

	}	

}
