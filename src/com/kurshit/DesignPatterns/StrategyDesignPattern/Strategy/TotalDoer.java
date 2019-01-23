package com.kurshit.DesignPatterns.StrategyDesignPattern.Strategy;

import java.util.List;

public class TotalDoer
{
	protected Total totalBehaviour;
	
	public int doTotal(List<Integer> numbers)
	{
		return totalBehaviour.totalValues(numbers);
	}
	
	public void setTotalBehaviour(Total behaviour)
	{
		this.totalBehaviour = behaviour;
	}
}
