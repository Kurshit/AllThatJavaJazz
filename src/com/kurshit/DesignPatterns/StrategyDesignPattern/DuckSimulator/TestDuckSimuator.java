package com.kurshit.DesignPatterns.StrategyDesignPattern.DuckSimulator;

public class TestDuckSimuator {

	/*This is enhanced version of main method for instantiating different duck classes.
	 * For previous versions, see the commented code in the end
	 */
	
	public static void main(String[] args) {
		
		Duck duck = new MallardDuck();
		
		//Mallard Duck
		duck.display();
		duck.performQuack();
		duck.performFly();
		
		System.out.println();
		
		//changing behaviour of this duck for fly and quack
		
		duck.setQuackBehaviour(new DoNotQuack());
		duck.setFlyBheaviour(new DoNotFly());
		
		duck.display();
		duck.performQuack();
		duck.performFly();
		

	}

}

interface Flyable
{
	void fly();
}

interface Quackable
{
	void quack();
}

class FlyWithWings implements Flyable
{

	@Override
	public void fly() {
		System.out.println("Flying with wings");
		
	}
		
}

class DoNotFly implements Flyable
{

	@Override
	public void fly() {
		System.out.println("Can't fly");
		
	}
	
}

class DoQuack implements Quackable
{

	@Override
	public void quack() {
		System.out.println("I Quack");
		
	}
	
}

class Squeak implements Quackable
{

	@Override
	public void quack() {
		System.out.println("I Squeak");
	}
}

class DoNotQuack implements Quackable
{

	@Override
	public void quack() {
		System.out.println("Can't quack");
		
	}
	
}

abstract class Duck
{
	Flyable flyable;
	Quackable quackable;
	
	abstract void display();
	
	public void performQuack()
	{
		quackable.quack();
	}
	
	public void performFly()
	{
		flyable.fly();
	}
	// following two are added in version 2
	public void setFlyBheaviour(Flyable flyable)
	{
		this.flyable = flyable;
	}
	
	public void setQuackBehaviour(Quackable quackable)
	{
		this.quackable = quackable;
	}
}

class MallardDuck extends Duck
{

	MallardDuck()
	{
		flyable = new FlyWithWings();
		quackable = new DoQuack();
	}
	
	@Override
	void display() {
		System.out.println("I am mallard duck");
		
	}
	
	
}

class RubberDuck extends Duck
{
	RubberDuck()
	{
		flyable = new DoNotFly();
		quackable = new Squeak();
	}
	
	void display()
	{
		System.out.println("I am a RubberDuck");
	}
}

class RedHeadDuck extends Duck
{
	RedHeadDuck()
	{
		flyable = new FlyWithWings();
		quackable = new DoNotQuack();
	}
	
	void display()
	{
		System.out.println("I am a RedHeadDuck");
	}
}

/* Version1 : Direct instantiation 
 * 
  public static void main(String[] args) {
		
		Duck duck = new MallardDuck();
		
		//Mallard Duck
		duck.display();
		duck.performQuack();
		duck.performFly();
		
		System.out.println();
		
		//RedHeadDuck
		duck = new RedHeadDuck();
		duck.display();
		duck.performQuack();
		duck.performFly();
		
		System.out.println();
		
		//RubberDuck
		duck = new RubberDuck();
		duck.display();
		duck.performQuack();
		duck.performFly();
	}
	
  * Version 2 : Changinf fly and quack behaviour at runtime
  * 
   public static void main(String[] args) {
		
		Duck duck = new MallardDuck();
		
		//Mallard Duck
		duck.display();
		duck.performQuack();
		duck.performFly();
		
		System.out.println();
		
		//changing behaviour of this duck for fly and quack
		
		duck.setQuackBehaviour(new DoNotQuack());
		duck.setFlyBheaviour(new DoNotFly());
		
		duck.display();
		duck.performQuack();
		duck.performFly();
		

	}
	


*/

