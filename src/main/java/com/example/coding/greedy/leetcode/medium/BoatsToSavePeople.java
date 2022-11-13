package com.example.coding.greedy.leetcode.medium;

import java.util.Arrays;

/**
 * You are given an array people where people[i] is the weight of
 * the ith person, and an infinite number of boats where each boat can carry
 * a maximum weight of limit. Each boat carries at most two people at the same time,
 * provided the sum of the weight of those people is at most limit.
 *
 * Return the minimum number of boats to carry every given person.
 */
public class BoatsToSavePeople {

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int start = 0;
        int end = people.length-1;
        int boatCount = 0;
        //Note : Each boat carry at most 2 people *** This is main point of this problem
        while (end <= start) {
            int startWeight = people[0]; // light person
            int endWeight = people[end]; //heavy person

            if (endWeight == limit) {
                boatCount++; // if heavy person is in limit then he will go alone
                end--;
            } else if (startWeight + endWeight > limit) {
                boatCount++; // if combine weight is more than limit then heavy will go alone
                end--;
            } else {
                boatCount++;
                start++;
                end--;
            }
        }

        return boatCount;
    }

    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }
}
