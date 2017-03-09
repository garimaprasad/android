package com.example.garima.myapplication;


import java.util.Scanner;

/**
 * Created by Garima on 3/8/17.
 */

public class AddTwoNum {
    /*public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int first = s.nextInt();
        int second = s.nextInt();
        AddTwoNum a= new AddTwoNum();
        System.out.println("Sum of "+first +" and "+second+ " is : "+ a.getSum(first,second));
    }*/

    public static long getSum(int first, int second) {
        long a = (long) first;
        long b = (long) second;
        while(b != 0){
            long carry = a&b;
            a = a^b;
            b = carry<<1;
        }
        return a;
    }


}
