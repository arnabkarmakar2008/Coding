package com.example.coding.bit.leetcode;

public class HammingDistanceBetweenTwoNumber {

    public static int hammingDistance(int m, int n) {

        int result = 0;

        while (m > 0 || n > 0) {
            // Even number last bit will be 0 and odd last bit will be 1
            result += (m%2)^(n%2); //xor will give 1 if two bits are diff. Here we are checking the last bit.
            m >>= 1; //shifting the bit. Basically m = m/2;
            n >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int m = 14;
        int n = 4;

        System.out.println(hammingDistance(m,n));
    }
}
