package com.example.coding.search.leetcode.easy;

/**
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns three possible results:
 *
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 */
public class GuessNumberHigherOrLower {

    private static int guess(int num) {
        if (num > 6) {
            return -1;
        } else if (num < 6) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int guessNumber (int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = (low+high)/2;

            int numberLevel = guess(mid);

            if (numberLevel == 0) {
                return mid;
            } else if (numberLevel == 1) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }



}
