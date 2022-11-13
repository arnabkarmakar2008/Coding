package com.example.coding.math.leetcode.medium;

/**
 * You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.
 *
 * Player 1 and player 2 take turns, with player 1 starting first.
 * Both players start the game with a score of 0. At each turn, the player takes one of the numbers
 * from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of
 * the array by 1. The player adds the chosen number to their score.
 * The game ends when there are no more elements in the array.
 *
 * Return true if Player 1 can win the game. If the scores of both players are equal,
 * then player 1 is still the winner, and you should also return true.
 * You may assume that both players are playing optimally.
 */
public class PredictTheWinner {

    public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i=0; i<n; i++) {
            sum += nums[i];
        }

        int bestScore = recursion(nums, 0, n-1);
        int opponentScore = sum - bestScore;

        return bestScore >= opponentScore;
    }

    /**
     * Here opponent will try to maximize his score. So we will get minimum of the options.
     * After evaluating both left and right we have to get max of the options.
     * @param nums
     * @param i
     * @param j
     * @return
     */

    private static int recursion(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }

        //I can choose ith element. Then opponent can choose i+1 or jth element.
        //If opponent choose i+1th element then I have option to choose from i+2 and jth element
        //If opponent choose jth element then I have option to choose from i+1 and jth element
        int score1 = nums[i] + Math.min(recursion(nums, i+2, j), recursion(nums, i+1, j-1));

        //I can choose jth element. Then opponent can choose ith or j-1th element.
        //If opponent choose ith element then I have option to choose from i+1 and j-1th element
        //If opponent choose j-1th element then I have option to choose from i and j-2th element
        int score2 = nums[j] + Math.min(recursion(nums, i+1, j-1), recursion(nums, i, j-2));

        return Math.max(score1, score2);
    }


    public static void main(String[] args) {
        int[] nums = {1,5,2};
        System.out.println(predictTheWinner(nums));
    }
}
