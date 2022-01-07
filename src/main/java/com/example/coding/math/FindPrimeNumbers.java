package com.example.coding.math;

public class FindPrimeNumbers {

    /**
     * The sieve of Eratosthenes is one of the most efficient ways to find
     * all primes smaller than n when n is smaller than 10 million
     * @param destNumber
     */

    public static void findPrime(int destNumber) {
        //Create a boolean array
        boolean[] boolArray = new boolean[destNumber+1];

        for (int i=0; i<=destNumber; i++) {
            boolArray[i] = true;
        }

        for (int p = 2; p*p <= destNumber; p++) {
            if (boolArray[p] == true) {
                for (int j = p*p; j <= destNumber; j+=p) {
                    boolArray[j] = false;
                }
            }
        }

        System.out.println("Prime Number from 0 to "+destNumber+" = ");
        for (int ct=0; ct <= destNumber; ct++) {
            if (boolArray[ct] == true) {
                System.out.print(" " + ct + " ");
            }

        }
    }

    public static void main(String[] args) {
        findPrime(9999);
    }
}
