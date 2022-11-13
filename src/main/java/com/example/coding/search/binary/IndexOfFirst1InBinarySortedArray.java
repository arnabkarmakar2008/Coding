package com.example.coding.search.binary;

/**
 * https://www.youtube.com/watch?v=8x6dmO6XW8k&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=14
 *
 * Array is infinite
 */
public class IndexOfFirst1InBinarySortedArray {

    public static int find(int[] nums) {
        int start = 0;
        int end = 1;
        int answer = -1;
        while (nums[end] != 1) {
            start = end;
            end = end*2;
        }

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == 1) {
                answer = mid;

                end = mid-1;
            } else if (nums[mid] == 0) {
                start = mid+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
        System.out.println(find(nums));
    }
}
