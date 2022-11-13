package com.example.coding.math.basic;

import java.util.Arrays;

/**
 * It tells the number of prime number within a range.
 */
public class SeiveOfEratoshenes {

    public static boolean[] numberOfPrime(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i=2; i*i <=n; i++) {
            //we have to check till sqrt of N

            for (int j = 2*i; j<=n; j +=i) {
                isPrime[j] = false;
            }
        }

        return isPrime;
    }

    public static void main(String[] args) {
        boolean[] arr = numberOfPrime(20);

        for (int i = 0; i <= 20; i++) {
            System.out.println(i + " = " + arr[i]);
        }
    }
}
