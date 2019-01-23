package com.kurshit.MyQuestions;

//Question : If i have just parameterized constructor, and I do not have any default constructor,
//so what is output of following program 

public class ConstructorQ1 {

	public ConstructorQ1(int a) 
	{
		System.out.println("Inside paramaterized const");
	}
	public static void main(String[] args) 
	{
		//ConstructorQ1 c1 = new ConstructorQ1();	

	}

}

//Perform -- Uncomment line 14 to get original question
//Answer: CE --ConstructorQ1 is undefined