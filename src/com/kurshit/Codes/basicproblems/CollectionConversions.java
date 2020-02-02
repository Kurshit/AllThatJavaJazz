package com.kurshit.Codes.basicproblems;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CollectionConversions {

	/*
	 * Following method converts the List<Integer> into int[]. 
	 * This does not check if values are null
	 */

	public int[] convertListToPrimitiveInt(List<Integer> list) {

		/* Approach 1: 
		 * 
		 */

		/*int[] result = list.stream()
			.mapToInt(Integer :: new)
			.toArray();
		 */
		
		/*
		 * Approach 2 :  
		 * 
		 * toArray right away gives int primitive as return value. 
		 * No need to convert it
		 */
		
		/*int[] result = list.stream()
				.mapToInt(e -> e)
				.toArray();
		*/
		
		/* Approach 3:
		 * Or can be done in following way
		 */

		int[] result = list.stream()
				.mapToInt(Integer :: intValue)
				.toArray();
		


		return result;

	}

	public int[] convertListToPrimitiveIntHandlingNull(List<Integer> list) {

		/* Approach 1: 
		 * Using != null equation  in filter 
		 */

		/*int[] result = list.stream()
				.filter(value -> value != null)
				.mapToInt(Integer :: new)
				.toArray();
		*/

		/* Approach 2:
		 * Or can be done in following way
		 */

		int[] result = list.stream()
				.filter(Objects :: nonNull)
				.mapToInt(Integer :: intValue)
				.toArray();



		return result;

	}


	public void printArray(int[] arr) {
		for(int i: arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		CollectionConversions underTest = new CollectionConversions();

		List<Integer> list = Arrays.asList(10,20,30,40,50,60,70,80,90,100);
		
		List<Integer> listWithNulls = Arrays.asList(10,20,null,40,50,null,70,80,null,100);
		
		int[] result = underTest.convertListToPrimitiveInt(list);
		underTest.printArray(result);
		
		// This will throw NPE
		//result = underTest.convertListToPrimitiveInt(listWithNulls);
		
		result = underTest.convertListToPrimitiveIntHandlingNull(listWithNulls);
		
		System.out.println("With handling null - ");
		underTest.printArray(result);
		
		

	}

}
