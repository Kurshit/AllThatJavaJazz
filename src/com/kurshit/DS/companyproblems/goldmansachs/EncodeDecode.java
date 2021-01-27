package com.kurshit.DS.companyproblems.goldmansachs;

import java.io.*;


/*
 * Encode and Decode based on a key
 */

public class EncodeDecode {



    
    // Complete the secureChannel function below.
    static String secureChannel(int operation, String message, String key) {

     switch(operation) {
         case 1 : return encode(message, key);

         case 2: return decode(message, key);

         default : return "-1";
     }    


    }

    private static String encode(String message, String key) {

        boolean isValid = isValidString(message, key); 

        if(!isValid)
        return "-1";

        int index = 0;

        StringBuilder result = new StringBuilder();

        char[] keys = key.toCharArray();

        int i;

        for(i=0; i< keys.length; i++) {

            if(index < message.length()) {

                char current = message.charAt(index);

                if(Character.isDigit(keys[i])) {

                    int keyV = keys[i] - '0';

                    for(int x = 0; x< keyV; x++) {
                        result.append(current);
                    }

                    index++;

                } else 
                    return "-1";
            } else 
                    break;
        }

        return getMessage(message, index, result, keys, i);
    }

    private static boolean isValidString(String message, String key) {
        if(message == null || key == null)
            return false;

        if(message.isEmpty() && key.isEmpty())
            return false;

        if(!message.isEmpty() && key.isEmpty())
            return false;

        if(message.isEmpty() && !key.isEmpty())
            return false;

        return true;
    }

    private static String decode(String message, String key) {

        boolean isValid = isValidString(message,key);

        if(!isValid)
            return "-1";

        if(key.equals("0"))
            return message;

        int index = 0;

        StringBuilder result = new StringBuilder();

        char[] keys = key.toCharArray();

        int i;

        for(i=0; i< keys.length; i++) {

            if(index < message.length()) {

                char current = message.charAt(index);

                if(Character.isDigit(keys[i])) {
                    int keyV = keys[i] - '0';

                    int x = 1;

                    while(x + index < message.length() && message.charAt(x+index) == current) {
                        x++;
                    }

                    if(x == keyV) {
                        result.append(current);
                    } else {
                        return "-1";
                    }

                    index = index +x;
                } else 
                	return "-1";
            } else break;
        }

        return getMessage(message, index, result, keys, i);

    }

    private static String getMessage(String message, int index, StringBuilder result, char[] keys, int i) {

        if(index < message.length()) {
            String remaining = message.substring(index);
            result.append(remaining);
        }

        return result.toString();

    }
    public static void main(String[] args) throws IOException {
    	int operation = 2;
    	String message = "Oppeeennnn";
    	String key = "1234";
        String res = secureChannel(operation, message, key);

        System.out.println(res);
    }
    
}