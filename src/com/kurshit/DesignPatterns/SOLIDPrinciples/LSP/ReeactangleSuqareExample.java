package com.kurshit.DesignPatterns.SOLIDPrinciples.LSP;

public class ReeactangleSuqareExample {

	public static int calculateArea(Reactangle r)
	{
		return r.getArea();
	}
	
	public static Reactangle reactangleFactory()
	{
		// This could be a facory returning the particular type or subcass of Reactangle
		
		return new Square();
	}
	
	public static void main(String[] args)
	{
		
		
		Reactangle r1 = reactangleFactory();
		r1.setBreadth(5);
		r1.setLength(8);
		
		System.out.println(calculateArea(r1)); // O/P : 64 instead of 40
		
		/*
		 *  In above case, customer might consider r1 to be of reactangle, and ends up with wrong result. This is violation of LSP.
		 *  The Suqare is Reactangle is not true in a sense here. The inherited methods are not useful in this case. This is violation of principle
		 *  logically, as class does allows to replace base class object with subclass object, but is very confusing and incorrect methods. 
		 *  Clearly, a square is a rectangle for all normal intents and purposes. Since the ISA relationship holds, it is logical to model the Square 
		 *  class as being derived from Rectangle. This use of the ISA relationship is considered by many to be one of the fundamental techniques of Object Oriented
		 *	Analysis. A square is a rectangle, and so the Square class should be derived from the Rectangle class. However this kind of thinking can lead to
		 *	some subtle, yet significant, problems. Generally these problem are not foreseen until we actually try to code the application. Our first clue 
		 *	might be the fact that a Square does not need both itsHeight and itsWidth member variables. Yet it will inherit them anyway. Clearly this is wasteful.
		 *   
		 *  Solution : Use composition/delegation if you want to use  a  class without changing its behaviour.
		 */
			
		
	}
	
}

class Reactangle {
	
	int length,breadth;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	
	public int getArea()
	{
		return length*breadth;
	}
		
}

class Square extends Reactangle {
	
	@Override
	public void setLength(int length) {
		this.length = length;
		this.breadth = length;
	}
	
	@Override
	public void setBreadth(int breadth) {
		this.length = breadth;
		this.breadth = breadth;		
	}
}


