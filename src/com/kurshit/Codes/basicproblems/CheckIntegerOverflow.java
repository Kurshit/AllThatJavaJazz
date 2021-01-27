package com.kurshit.Codes.basicproblems;

/*
 * Statement : Check if integer operation gets overflown. As in, when integer destination datatype cannot 
 * hold the value in it, it causes loss of data. The desination datatype cannot hold value if its maximum limit
 * is reached. 
 * 
 * The problem is to add one to maximum allowed integer range  
 *  
 */

public class CheckIntegerOverflow {
	
	public boolean checkIntOverflow(int x) {
		
		long result = (long) x + (long) 1;
		
		if((int)result != result)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		CheckIntegerOverflow cio = new CheckIntegerOverflow();
		System.out.println(cio.checkIntOverflow(Integer.MAX_VALUE));
	}

}
