package com.example.coding.math.basic;

public class TrailingZerosInFactorial {

    /**
     * 10! = 1*2*3*4*5*6*7*8*9*10 = 3628800
     * Number of 5 in above will give 0 count. 5 and 10 contains 5. So there are 2 5s in 10!. So trailing zero
     * will be 2.
     *
     * In 30! there are 5, 10, 15, 20, 25 and 30 :: 6 fives. But in 25 there are 2 5s. So total there are
     * 7 5s.
     *
     * Count of trailing zero in 30! = 30/5 + 30/25
     *
     * @param n
     * @return
     */
    public static int trailingZeros(int n) {
        int result = 0;

        for (int i = 5; i <= n; i = i*5) {
            result += n/i;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 130;
        System.out.println(trailingZeros(n));
    }
}
