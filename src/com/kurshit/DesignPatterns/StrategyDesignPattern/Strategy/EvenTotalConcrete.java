package com.kurshit.DesignPatterns.StrategyDesignPattern.Strategy;

public class EvenTotalConcrete extends TotalDoer
{
	EvenTotalConcrete()
	{
		totalBehaviour = new TotalEvenValues();
	}
	
	
}
