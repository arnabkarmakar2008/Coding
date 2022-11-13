package com.example.coding.slidingwindow.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 *
 * A good array is an array where the number of different integers in that array is exactly k.
 *
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 *
 * Input: nums = [1,2,1,2,3], k = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers:
 * [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
 */
public class CountSubArraysWithKDiffIntegers {

    /**
     * https://www.youtube.com/watch?v=CBSeilNvZHs&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=13
     *
     * We have to maintain two hashmap. Bigger map will contain K elements and smaller will contain k-1
     *
     * Subarray count with at most k element - Subarray count with at most k-1 element = Subarray count with exactly k element
     *
     * 1 2 3 1
     *
     * Subarrays with at most 3 elements : 1 & 2 & 3 & 1 & 1 2 & 2 3 & 3 1 & 1 2 3 & 2 3 1 & 1 2 3 1 = 10
     *
     * Subarrays with at most 2 elements : 1 & 2 & 3 & 1 & 1 2 & 2 3 & 3 1 = 7
     *
     * 10 - 7 = 3 will be number of subarrays with exact 3 elements = 1 2 3 & 2 3 1 & 1 2 3 1
     *
     * @param nums
     * @param k
     * @return
     */

    /**
     * This is the efficient one and easy to remember.
     * Just find count with at most k - count with atmost k-1 element
     *
     * https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/523136/JavaC%2B%2BPython-Sliding-Window
     *
     *
     * @param s
     * @param k
     * @return
     */
    public static int countOfSubstringWithArMostKDistinct(int[] nums, int k) {
        int start = 0;
        int end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        while (end < nums.length) {
            map.put(nums[end], map.getOrDefault(nums[end], 0)+1);

            /**
             * I can explain ret += j - i + 1 :)
             *
             * suppose initial window [a] then subarrays that ends with this element are [a]--> 1
             * now we expand our window [a,b] then subarrays that ends with this new element are [b], [a,b] -->2
             * now we expand our window [a,b,c] then subarrays that ends with this new element are [c], [b, c], [a,b,c] -->3
             * now we expand our window [a,b,c,d] and let suppose this is not valid window so we compress window from left side to make it valid window
             * [b,c,d] then subarrays that ends with this new element are [d], [c,d], [b,c,d] -->3
             *
             * You can observe that we are only considering subarrays with new element in it which auto. eliminate the counting of duplicate subarrays that we already considered previously.
             * And surprisingly the number of sub-arrays with this new element in it is equal to the length of current window.
             */

            if (map.size() <= k) {
                count = count + (end-start+1);
                end++;
            } else {
                while (map.size() > k) {
                    int ct = map.get(nums[start]);

                    if (ct-1 == 0) {
                        map.remove(nums[start]);
                    } else {
                        map.put(nums[start], map.getOrDefault(nums[start],0)-1);
                    }

                    start++;
                }
                count = count + (end-start+1);
                end++;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 3;
        System.out.println(countOfSubstringWithArMostKDistinct(nums, k) - countOfSubstringWithArMostKDistinct(nums, k-1));
    }
}
