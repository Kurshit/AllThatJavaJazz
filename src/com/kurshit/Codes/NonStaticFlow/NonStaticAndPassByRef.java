package com.kurshit.Codes.NonStaticFlow;

/*
 *  Try out this program witjout touching a pen and figure out the output
 *  This example shows how pass by ref and current object works for non-static code flow
 * 
 */

class NonStaticAndPassByRef 
{
	int x;
	int y;
	
	void m1(NonStaticAndPassByRef r)
	{
		 x = x+1;
		 y = y+2;
		 
		 r.x = r.x+3;
		 r.y = r.y+4;
		 
	}
	public static void main(String[] args)
	{
		NonStaticAndPassByRef r1 = new NonStaticAndPassByRef();
		NonStaticAndPassByRef r2 = new NonStaticAndPassByRef();
		
		r1.m1(r2);
		System.out.println(r1.x+ " .. " +r1.y); //
		System.out.println(r2.x+ " .. " +r2.y); //
		
		System.out.println();
		
		r2.m1(r1);
		System.out.println(r1.x+ " .. " +r1.y);  //
		System.out.println(r2.x+ " .. " +r2.y); //		
		System.out.println();
		
		r1.m1(r1);
		System.out.println(r1.x+ " .. " +r1.y); //
		System.out.println(r2.x+ " .. " +r2.y); //
		
		System.out.println();
		
		r2.m1(r2);
		System.out.println(r1.x+ " .. " +r1.y); //
		System.out.println(r1.x+ " .. " +r1.y); //
		
	}	
	
	
}

