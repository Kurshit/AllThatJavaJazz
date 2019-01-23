package com.kurshit.MyQuestions;

public class Override1 {

	public static void main(String[] args) {
		Avani a1 = new Avani();
		a1.m1();
		a1.m2();
		a1.m3();
		System.out.println("------a1----------");
		Bhavani b1 = new Bhavani();
		b1.m1();
		b1.m2();
		b1.m3();
		b1.m4();
		System.out.println("------b1----------");
		Avani a2 = new Bhavani();
		a2.m1();
		a2.m2();
		a2.m3();
		//a2.m4();
		System.out.println("------a2----------");
		Avani a3 = (Avani) b1;
		a3.m1();
		a3.m2();
		a3.m3();
		//a3.m4();
		System.out.println("------a3----------");
	}

}

class Avani
{
	void m1()
	{
		System.out.println("A > m1");
	}
	
	void m2()
	{
		System.out.println("A > m2");
	}
	
	static void m3()
	{
		System.out.println("static A > m3");
	}
}

class Bhavani extends Avani
{
	void m1()
	{
		System.out.println("B > m1");
	}
	
	void m2()
	{
		System.out.println("B > m2");
	}
	
	static void m3()
	{
		System.out.println("static B > m3");
	}
	
	void m4()
	{
		System.out.println("B > m4");
	}
}
