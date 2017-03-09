package com.example.garima.myapplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Garima on 3/8/17.
 */

public class CheckPalindrome {
    /*public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        CheckPalindrome c = new CheckPalindrome();
        if(c.checkPalindrome(str))
            System.out.println("This is a Palindrome ");
        else
            System.out.println("This is not a Palindrome");

    }*/

    public static String checkPalindrome(String letters) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : letters.toCharArray()){
            int val = 0;
            if(map.containsKey(c))
                val = map.get(c);
            map.put(c, val+1);
        }
        boolean firstOdd = false;
        char[] palin = new char[letters.length()];
        int start =0;
        int end = letters.length()-1;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if( value %2 ==1 ){
                if(firstOdd)
                    return "This is not a Palindrome";
                firstOdd= true;
                palin[letters.length()/2]= entry.getKey();
                value--;
            }
            while(value !=0){
                palin[start] = entry.getKey();
                palin[end-start] = entry.getKey();
                start++;
                value -=2;
            }

        }
        return new String(palin);
    }
}
