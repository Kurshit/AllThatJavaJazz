package com.kurshit.DesignPatterns.StrategyDesignPattern.Strategy;

class OddTotalConcrete extends TotalDoer
{
	public OddTotalConcrete()
	{
		totalBehaviour = new TotalOddValues();
	}
}
