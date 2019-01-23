package com.kurshit.DesignPatterns.StrategyDesignPattern.Strategy;

import java.util.Arrays;
import java.util.List;

public class TestTotalMain
{

	public static void main(String[] args)
	{
		List<Integer> listOfNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		TotalDoer total = new EvenTotalConcrete();
		
		int result = total.doTotal(listOfNumbers);
		
		System.out.println(result);
		
		//change type at runtime
		
		total.setTotalBehaviour(new TotalOddValues());
		result = total.doTotal(listOfNumbers);
		System.out.println(result);
		
		
		

	}

}
