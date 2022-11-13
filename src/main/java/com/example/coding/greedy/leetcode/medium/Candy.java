package com.example.coding.greedy.leetcode.medium;

import java.util.Arrays;

/**
 * There are n children standing in a line. Each child is assigned a rating value
 * given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 */
public class Candy {

    /**
     * Assign 1 candy for all.
     * Traverse from left -> right. And compare with left element only. If right > left then add +1 to right candidate.
     *
     * Traverse from right -> left. And compare with right element only. If left > right then ass +1 tp left candicate.
     *
     * Take max of 2 values from same index.
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {

        int[] leftToRight = new int[ratings.length];
        Arrays.fill(leftToRight, 1);

        int[] rightToLeft = new int[ratings.length];
        Arrays.fill(rightToLeft, 1);

        for (int i=1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                leftToRight[i] = leftToRight[i-1]+1;
            }
        }

        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i+1] < ratings[i]) {
                rightToLeft[i] = rightToLeft[i+1]+1;
            }
        }

        int result = 0;

        for (int ct=0; ct< ratings.length; ct++) {
            result += Math.max(rightToLeft[ct], leftToRight[ct]);
        }

        for (int i : leftToRight) {
            System.out.println(i);
        }

        System.out.println("=========");

        for (int i : rightToLeft) {
            System.out.println(i);
        }



        return result;
    }

    public static void main(String[] args) {
        int[] ratings = {12, 4, 3, 11, 34, 34, 1, 67};
        System.out.println(candy(ratings));
    }
}
