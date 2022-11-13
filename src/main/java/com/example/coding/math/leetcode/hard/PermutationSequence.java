package com.example.coding.math.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labelling all of the permutations in order,
 * we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 *
 */
public class PermutationSequence {

    /**
     *
     * https://www.youtube.com/watch?v=wT7gcXLYoao
     * n = 4, k = 17
     * fact = fact(3) = 6
     * 1 2 3 4
     * 1 + [2,3,4]
     * 2 + [1,3,4]
     * 3 + [1,2,4]
     * 4 + [1,2,3]
     *
     * index = 17/6 = 2. So number is 3
     *
     * n = 3, k = 17%6 = 4 fact = fact(3)/size=3 :: 2
     *
     * 1 + [2,4]
     * 2 + [1,4]
     * 4 + [1,2]
     *
     * n = 2, k =
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numList = new ArrayList<>();

        /**
         * Get factorial upto n-1. Add numbers in list
         */
        for (int i=1; i<n; i++) {
            fact *= i;
            numList.add(i);
        }

        numList.add(n);

        k = k-1; // as we are taking 0 based index
        StringBuilder strBuilder = new StringBuilder();

        while (true) {
            int index = k/fact;

            strBuilder.append(numList.get(index));
            numList.remove(index);

            if (numList.size() == 0) {
                break;
            }

            k = k%fact;
            fact = fact/numList.size();
        }

        return strBuilder.toString();

    }

    public static void main(String[] args) {
        int n = 4;
        int k = 17;
        System.out.println(getPermutation(n,k));
    }
}
