package com.kurshit.MyQuestions;

public class ReverseANumber
{
	public static void main(String args[])
	{
		//1. Using while loop
		int num = 12345;
		int reversenum =0;


		while( num != 0 )
		{
			reversenum = reversenum * 10;
			reversenum = reversenum + num%10;
			num = num/10;
		}

		System.out.println("Reverse of input number is: "+reversenum);

		//2. Using Recusrion --

		num = 12345;
		reversenum = 0;

		System.out.print("Reverse of the input number is:");
		reverseMethod(num);
		System.out.println();

	}

	public static void reverseMethod(int number) {
		if (number < 10) {
			System.out.println(number);
			return;
		}
		else {
			System.out.print(number % 10);
			//Method is calling itself: recursion
			reverseMethod(number/10);
		}
	}

}
