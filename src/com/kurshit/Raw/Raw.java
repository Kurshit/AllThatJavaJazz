package com.kurshit.Raw;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class Raw {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        
        */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dwno = Integer.parseInt(br.readLine());                // Reading input from STDIN
        
        List<String> dislikedList = new ArrayList<>();
        
        for(int i=0; i< dwno; i++) {
            dislikedList.add(br.readLine());
        }
        
        int noOfWords = Integer.parseInt(br.readLine());
        
        String[] sentence = br.readLine().split(" ");
        String result = "";
        for(String s : sentence) {
            if(!dislikedList.contains(s)) {
                int ascii = s.charAt(0);
                ascii = ascii - 32;
                char value = (char)ascii;
                result = result + value + "."; 
            }
        }
        
        result = result.substring(0,result.length()-1);
        
        System.out.println(result);

        // Write your code here

    }
}
