package com.coreexamples.CoreJava;

import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args) {

        printPrimers ();

        System.exit (0);

        long currentTime = System.currentTimeMillis ();

        //Sequential stream
         long count = IntStream.rangeClosed (2, 15).filter (PrimeNumber::isPrime).count ();
        System.err.println ("No of primes seq. : " + count);
        System.err.println ("Time taken : " + (System.currentTimeMillis () - currentTime));

        //Parallel stream
        currentTime = System.currentTimeMillis ();
        count = IntStream.rangeClosed (2, 15).parallel ().filter (PrimeNumber::isPrime).count ();
        System.err.println ("No of primes parallel : " + count);
        System.err.println ("Time taken : " + (System.currentTimeMillis () - currentTime));

    }

    public static void isPrimeN(int num) {
        boolean isPrime = true;
        int temp;
        for (int i = 2; i < num / 2; i++) {
            temp = num % i;
            if (temp == 0) {
                isPrime = false;
                break;
            }
        }

        if(isPrime){
            System.out.println (num+" is a prime number ");
        }
    }
    public static void printPrimers(){
        int i =0, num = 0;
        String numbers = "";
        for (i = 1; i < 100; i++) {
            int counter =0;
            for (num = i; num >= 1; num--) {
                if(i%num == 0){
                    counter = ++counter;
                }
            }
            if (counter == 2){
                numbers = numbers+" "+i;
            }
        }

        System.out.println (numbers);

        isPrimeN (5);
    }

    public static boolean isPrime(long num) {

        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        long maxDivisor = (long) Math.sqrt (num);

        for (int i = 3; i < maxDivisor; i++) {
            if (num % i == 0) return false;
        }
        System.out.print (num+" ");
        return true;

    }
}
