package com.kurshit.Raw;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader */
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Raw4 {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        Map<String,Integer> map = new HashMap<>();
        Map<Character,Integer> lookup = new HashMap<>();
        while(N-->0) {

            String s1 = s.next();
            
            
            int prev = lookup.getOrDefault(s1.charAt(0), 0);
            
            int t = map.getOrDefault(s1.charAt(0) + String.valueOf(prev),0);
            
            if(t  == 10) {
            	lookup.put(s1.charAt(0), prev+1);
            	map.put(s1.charAt(0)+ String.valueOf(prev+1), t+1);
            } else {
            	map.put(s1.charAt(0) + String.valueOf(prev), t+1);
            	
            }
            
            
            


        }

        System.out.println(map.size());
        s.close();


        // Write your code here

    }
}
