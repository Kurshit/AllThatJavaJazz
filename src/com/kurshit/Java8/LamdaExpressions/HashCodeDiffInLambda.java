package com.kurshit.Java8.LamdaExpressions;

class LambdaParent
{
	
}

class LambdaChild extends LambdaParent
{
	
}

interface LambdaSAMInterface
{
	int test();
	
}

public class HashCodeDiffInLambda {

	public static void main(String[] args) 
	{
		//printing its own object gives its own class name
		LambdaChild lc = new LambdaChild();
		System.out.println(lc);
		
		//keeping parent class ref variable that holde child class object
		LambdaParent lp = new LambdaChild();
		System.out.println(lp); // this would print child's object only
		
		LambdaSAMInterface lsi = ()-> 0;
		
		System.out.println(lsi);
		

	}

}
