package com.kurshit.Java8.Streams.ParallelStreams;

import java.util.Arrays;
import java.util.List;

/*
 * Subject - Parallel Streams and CompletableFuture by Venkatesh
 * 
 * Video URL - https://www.youtube.com/watch?v=0hQvWIdwnw4&t=7502s
 * 
 * One nodte - Java 8 
 * 
 * 		Topic -- PArallel Streams Tab - Introduction 
 * 		Sub Topic - Sequential vs PArallel Execution using streams
 */

public class ParallelExecution {
	
	
	public static int transform(int number) {
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

	
	public static void main(String[] args) {
		
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		// Using sequential approach 
		
		numbers.parallelStream()
				.map( e -> transform(e))
				.forEach(e -> System.out.println(e));
		
	}

}
