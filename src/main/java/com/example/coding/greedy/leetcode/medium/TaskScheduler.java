package com.example.coding.greedy.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a characters array tasks, representing the tasks a CPU needs to do,
 * where each letter represents a different task. Tasks could be done in any order.
 * Each task is done in one unit of time. For each unit of time, the CPU could complete
 * either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between
 * two same tasks (the same letter in the array), that is that there must be at least n units
 * of time between any two same tasks.
 *
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 *
 *
 */
public class TaskScheduler {

    /**
     * https://www.youtube.com/watch?v=Z2Plc8o1ld4
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval(char[] tasks, int n) {
        /**
         * AAABC n =2
         *
         * freqArray : A = 3 B=1, C=1
         *
         * 25th element will be 3. 24th will be 1 and 23rd will be 1
         *
         * Now most frequent element is having 3 occurrence. So there will be (3-1) * 2 = 4 idle time
         *
         * A _ _ A _ _ A
         *
         * Now place next most frequent elemnt
         * AB_A__A
         * Now place next most frequent elemet
         * ABCA_ _ A
         *
         * So total time will be 7
         *
         *
         */

        int[] freqArray = new int[26];

        for (char c : tasks) {
            freqArray[c - 'A']++;
        }

        //sort the array
        Arrays.sort(freqArray);

        int maxFrequency = freqArray[25];
        int maxFrequencyCount = 1;

        for (int ct=24; ct>=0; ct--) {
            if (maxFrequency != freqArray[ct]) {
                break;
            } else {
                maxFrequencyCount += 1;
            }
        }

        /**
         * Lets say B:4 A:3 and n=2;
         *
         * B _ _ B _ _ B _ _ B
         *
         * So there will be (maxFreq-1) section and each section will have n+1 cycle.
         * So total will be (maxFrequency-1) * (n+1) and then we have to add for the last B.
         *
         * Now lets say B:4 A:4 and n=2;
         *
         * B A _ B A _ B A _ B A
         *
         * So here it will be (4-1) * (2+1) and add count of max freq element. There are 2 elements with
         * same max freq. So final answer will be (4-1) * (2+1) + 2 = 11
         */
        return (maxFrequency-1) * (n+1) + maxFrequencyCount;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}
