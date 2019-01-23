/*
 *  Title : Programming with streams in Java 8
 *  Source(s) : https://www.youtube.com/watch?v=rVfRDLIw_Zw
 *  Author : Venkat
 *  Location : D:\Kurshit\All owned notes\JAVA 8\Basics of streams
 *  Eclipse : Survival/com.kurshit.Java8.Streams.BasicStreams
 *    
 */
package com.kurshit.Java8.Streams.BasicStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Sample
{
	public static List<Person> createList()
	{
		return Arrays.asList(
				new Person("Shweta",Gender.FEMALE, 20),
				new Person("Shweta",Gender.FEMALE, 2),
				new Person("Sumit",Gender.MALE, 20),
				new Person("Kurshit",Gender.MALE, 27),
				new Person("Sharda",Gender.FEMALE, 32),
				new Person("Sakshi",Gender.FEMALE, 2),
				new Person("Sakshi",Gender.FEMALE, 42),
				new Person("Devesh",Gender.MALE, 12),	
				new Person("Sumit",Gender.MALE, 72)
			);
	}
	
	public static void main(String args[])
	{
		List<Person> people = createList();
		
		
		//people.stream()
				
		
		
		
		//Ques :1 get names of all people older than 18 , in upper case
		
		//1. traditional approach -->
		
		List<String> names = new ArrayList<>();
		
		for(Person person : people)
		{
			if(person.getAge()>18)
			{
				names.add(person.getName().toUpperCase());				
			}
		}
		
		System.out.println(names); 
		System.out.println();
		//2. Using streams
		
		/*List<String> newNames = people.stream()
									  .filter(person -> person.getAge() > 18)  //filter only people who are greater than 18 years
									  .map(person -> person.getName()) // get the names of all such people
									  .map(n -> n.toUpperCase()) // convert those names to upper case
									  .collect(java.util.stream.Collectors.toList());  // return the result in collection
		*/
		
		//above can be used or below method reference can be used
		
		List<String> newNames = people.stream()
									  .filter(person -> person.getAge() > 18)  //filter only people who are greater than 18 years
									  .map(Person :: getName) // get the names of all such people
									  .map(String :: toUpperCase) // convert those names to upper case
									  .collect(java.util.stream.Collectors.toList());  // return the result in collection
		
 
		System.out.println(newNames);
		
		System.out.println();
		
		//Ques 2: Print all the males of collection
		
		/*people.stream()
				.filter(person -> person.getGender() == Gender.MALE)
				.forEach(e -> System.out.println(e));
		*/
		
		people.stream()
				.filter(person -> person.getGender() == Gender.MALE)
				.forEach(System.out :: println);
		

		//Ques 3: Print all the males of collection, but with name in uppercase
		
		/*people.stream()
				.filter(person -> person.getGender() == Gender.MALE)
				.map(person -> new Person(person.getName().toUpperCase(), person.getGender(), person.getAge()))
				.forEach(e -> System.out.println(e));*/
		
		//above can also be used
		System.out.println();
		
		people.stream()
				.filter(person -> person.getGender() == Gender.MALE)
				.map(person -> new Person(person.getName().toUpperCase(), person.getGender(), person.getAge()))
				.forEach(System.out :: println);

		// Above code does not change the people collection.
		
		
		//Ques 4 : Total the age of all people
		System.out.println();
		
		System.out.println(
				people.stream()
			  	.map(Person::getAge) 					// avoid other things that dont matter
			  	.reduce(0, (carry,age) -> carry + age ));   //
		
		System.out.println();
		
		 /*reduce logic -- starts from 0 - posted note, takes its own age, totals it with the value 0 and carry forwards the posted
		 note to next person, next person takes the posted note, adds it current age, totals it with posted note and carry forwards
		 to next person untill iterates through all
		 0 = intitial value passed to first element
		 carry  = partial result thats brewing and age is age of every single person
		  */
		
		//alternatively, to above solution
		
		System.out.println(
				people.stream()
			  	.map(Person::getAge) 					// avoid other things that dont matter
			  	.reduce(0,Integer :: sum));   		// instead of reduce or impl our own function
		
		//or alternative we can also use sum() of streams
		
		System.out.println(
				people.stream()
			  		.mapToInt(Person::getAge) 					// mind the mapToInt here
			  		.sum());   								// instead of reduce or impl our own function
		
		/* mapToInt Reason -- sum only adds up Integers, Longs, Doubles. Thus, only map() would give error not 
		 * knowing how would add person. sum() is defined on Collection of Integers and not collection of objects. Hence the conversion
		 * to Int
		 * Q : Is it converting to Integer object
		 * Ans: NO!. It already knows its an int. Its converiting into collection of integer streams, hence sum is valid of it.
		 * Not that - sum() is the operation on collection and not on individual elements
		 */
		
		
		//Ques 5: Get the oldest person in collection result
		
		System.out.println(
				people.stream()
					.max((person1,person2) -> person1.getAge() > 
							person2.getAge()? 1 : -1)
				);
		
		// Result will have optional clause : indicates collection could be empty
		
		//Ques 6: Get the youngest person in collection result
		
		System.out.println(
				people.stream()
					.min((person1,person2) -> person1.getAge() > 
							person2.getAge()? 1 : -1)
				);
	
		// instead of max(), min() only is used
		
		//Ques 7: Count the total of Non-Adults
		
		System.out.println(
				people.stream()
					.filter(person -> person.getAge() < 18)
					.count()
				);
	
		
		//Ques 8: Wrong way v.s Right way - List all adult names in upper case
		
		// Following is wrong way
		
		List<String> adultNames = new ArrayList<>();
		
		//imperative style
		
		/*
		 * for(Person p : people)
		 * {
		 * 		if(p.getAge() > 17)
		 * 		{
		 * 			adultNames.add(p)
		 *  	}
		 * }
		 */
		
		//functional style
		
		people.stream()
			.filter(person -> person.getAge() > 17)
			.map(person -> person.getName().toUpperCase())
			.forEach(name -> adultNames.add(name));
		
		System.out.println(adultNames);
		 
		/*
		 * This causes correct results but this is such a bad idea. 
		 * Why ? - We are mutating variables. 
		 * Imagin - we are performing this operation concurrently, adultNames would be impacted with inconsistent result.
		 * Putting synchronized around it worse - like bang-the-head-on-wall pattern. B'coz, streams has been given to handle thread
		 * safety. Never sneak in and perform mutatate operation in forEach. Following is solution to above problem.
		 */
		
		List<String> adultNames2 = 
				people.stream()
					.filter(person -> person.getAge() > 17)
					.map(person -> person.getName().toUpperCase())
					.collect(
						() -> new ArrayList<>(),   //this is supplier
						(list , name) -> list.add(name),
						(list1, list2) -> list1.addAll(list2));
	
		System.out.println(adultNames2);
		
		
		/*
		 * 1. line - () -> new AL<>() --> is called Supplier : something you give nothing and give you back something. This serves 
		 * as the intitial value to work with. 
		 * 2. line (list,name -> list.add(name) -- is not this mutation operation again ? : NO: 
		 * Explain : Collect method says - I will take care of all the concurrency issues.  But in streams case, they gave you 
		 * collection and contructs - list, list1 and list2 in above case, they wrote the collect(), so why bother us managing the
		 * concurrency. They manage the concurrency. 
		 * collect does manage the thread safety - How ? Two things -
		 * 1. collect is done by them and 2. on line - (list1, list2) -> list1.addAll(list2). Now see, in previus forEach problem
		 * where we mutated anc caused concurrency problem, we did add on Object outside of that - pure evil. But in current case, 
		 * we did add on whatever was handed on to us, which means is a temp object not shared by other objects. Thus manintains the 
		 * thread safety. 
		 * We can also avoid verbose code and use toList() as follows
		 */
		
		//Alternatively, using toList()
		
		List<String> adultNames3 = 
				people.stream()
					.filter(person -> person.getAge() > 17)
					.map(person -> person.getName().toUpperCase())
					.collect(Collectors.toList());
	
		System.out.println(adultNames3);
		
		
		//Ques 10: Lets say we want list of male persons name's
		
		List<String> malesNamesList = 
				people.stream()
					.filter(person -> person.getGender() == Gender.MALE)
					.map(Person :: getName)
					.collect(Collectors.toList());
		
		System.out.println(malesNamesList);
		
		// Output will have duplicate sumit name. Lets use Set<Person> instead of List<Person>
		
		Set<String> malesNamesSet = 
				people.stream()
					.filter(person -> person.getGender() == Gender.MALE)
					.map(Person :: getName)
					.collect(Collectors.toSet());
		
		System.out.println(malesNamesSet); // This will avoid duplicate
		
		//We can also map it to Map object

		Map<String, Person> personMap = 
				people.stream()
					  .collect(Collectors.toMap(
						person -> person.getName() + " : " +person.getAge(),
						person -> person
					));
		
		System.out.println(personMap);
		
		// we can also take Map of String and List <Person> itself
		
		Map<String, List<Person>> personMapGrouping = 
				people.stream()
					  .collect(Collectors.groupingBy(Person :: getName));
		 
		System.out.println(personMapGrouping);
		
		//lets iterate over above map for details
		
		personMapGrouping.forEach((k,v) -> System.out.println(k + " --  " +v));
	
		//Ques 11: Find the first person whose name is 6 letters but is older than 20
		// Efficiency example
		
		System.out.println(
			people.stream()
				.filter(Sample :: is6Letters)
				.filter(person -> person.getAge() > 20 )
				//.findFirst()
			);
	
		/* What is efficiency of above example ?
		 *  Ans : This is Lazy evaluation approach. Lets comment findFirst() in above last line and notice output
		 *  It wont call any methods
		 */
	}
	
	public static boolean is6Letters(Person person)
	{
		System.out.println("Called for " +person);
		return person.getName().length() == 6; 
	}
	
}
