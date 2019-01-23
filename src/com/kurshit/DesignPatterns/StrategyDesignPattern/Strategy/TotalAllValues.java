package com.kurshit.DesignPatterns.StrategyDesignPattern.Strategy;

import java.util.List;

class TotalAllValues implements Total
{

	@Override
	public int totalValues(List<Integer> numbers)
	{
		int result = 0;
		
		for(int i : numbers)
		{
			result += i;
		}
		return result;
	}

}
