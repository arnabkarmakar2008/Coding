package com.example.coding.search.leetcode.medium;

import java.util.Arrays;

/**
 * Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
 *
 * Every house can be warmed, as long as the house is within the heater's warm radius range.
 *
 * Given the positions of houses and heaters on a horizontal line, return the minimum
 * radius standard of heaters so that those heaters could cover all houses.
 *
 * Notice that all the heaters follow your radius standard, and the warm radius will the same.
 *
 * Input: houses = [1,2,3,4], heaters = [1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4.
 * We need to use radius 1 standard, then all the houses can be warmed.
 */
public class Heaters {

    public static class Pair {
        int lower = -1;
        int higher = -1;

        public Pair(int lower, int higher) {
            this.lower = lower;
            this.higher = higher;
        }

        public Pair() {
        }
    }

    /**
     * Have to find floor and ceil for each house from heaters array. Take the min from floor and ceil.
     * Now take max from all houses.
     *
     * Sort the heaters array first to optimize ceil and floor
     *
     * @param houses
     * @param heaters
     * @return
     */
    public static int findRadius(int[] houses, int[] heaters) {
        int result = 0;

        Arrays.sort(heaters);

        for (int i=0; i< houses.length; i++) {
            int hp = houses[i];

            Pair pr = binarySearch(hp, heaters);

            int d1 = pr.lower == -1 ? Integer.MAX_VALUE : hp - pr.lower;
            int d2 = pr.higher == -1 ? Integer.MAX_VALUE : pr.higher - hp;
            int minimumRadius = Math.min(d1,d2);
            result = Math.min(minimumRadius, result);

        }

        return result;
    }

    private static Pair binarySearch(int target, int[] nums) {
        int low = 0;
        int high = nums.length-1;
        Pair pr = new Pair();

        while (low <= high) {
            int mid = (low+high)/2;

            if (nums[mid] == target) {
                //Heater is at the room position. So just return the room/heater position.
                pr.lower = nums[mid];
                pr.higher = nums[mid];
                break;

            } else if (target > nums[mid]) {
                //This will determine floor value. BS will continue to run. So this
                // will just return the just smaller value than target
                low = mid+1;
                pr.lower = nums[mid];
            } else {
                high = mid-1;
                pr.higher = nums[mid];
            }
        }

        return pr;
    }

    public static void main(String[] args) {
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};

        System.out.println(findRadius(houses, heaters));
    }

}
