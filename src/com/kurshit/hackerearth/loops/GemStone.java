package com.kurshit.hackerearth.loops;


import java.io.IOException;


public class GemStone {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] A = new int[26];
		
		String[] input = {"abc","abc", "bc"};
		
		for(int i=0; i<26; i++) {
			A[i] = 0;
		}
		
		for(String s: input) {
			
			for(int i=0; i<s.length(); i++) {
				int key = s.charAt(i) - 97;
				A[key] = A[key] + 1;
			}
			
		}
		
		for(int i=0; i<26; i++) {
			int temp = A[i];
			if(temp == input.length) {
				char c = (char) (i + 97);
				System.out.println(c+ " ");
			}
			
		}
		

	}	
}
