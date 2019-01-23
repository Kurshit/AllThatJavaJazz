
/*
 *  Title : Programming with streams in Java 8
 *  Source(s) : https://www.youtube.com/watch?v=rVfRDLIw_Zw
 *  Author : Venkat
 *  Location : D:\Kurshit\All owned notes\JAVA 8\Basics of streams
 *  Eclipse : Survival/com.kurshit.Java8.Streams.BasicStreams
 *    
 */

package com.kurshit.Java8.Streams.BasicStreams;

public class Person
{
	private final String name;
	private final Gender gender;
	private final int age;
	
	public Person(String name, Gender gender, int age)
	{
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	@Override
	public String toString()
	{
		return String.format("%s -- %s -- %d",name, gender, age);
	}

	

	public String getName()
	{
		return name;
	}

	public Gender getGender()
	{
		return gender;
	}

	public int getAge()
	{
		return age;
	}

}

enum Gender
{
	MALE,FEMALE
}