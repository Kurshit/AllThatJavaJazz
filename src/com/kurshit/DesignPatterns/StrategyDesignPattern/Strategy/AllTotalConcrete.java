package com.kurshit.DesignPatterns.StrategyDesignPattern.Strategy;

public class AllTotalConcrete extends TotalDoer
{
	public AllTotalConcrete()
	{
		totalBehaviour = new TotalAllValues();
	}
}
