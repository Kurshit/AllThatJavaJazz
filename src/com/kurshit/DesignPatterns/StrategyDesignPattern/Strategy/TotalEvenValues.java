package com.kurshit.DesignPatterns.StrategyDesignPattern.Strategy;

import java.util.List;

class TotalEvenValues implements Total
{

	@Override
	public int totalValues(List<Integer> numbers)
	{
		int result = 0;
		
		for(int i : numbers)
		{
			if(i%2 == 0)
			{
				result +=i;
			}
		}
		
		return result;
		
	}
}
