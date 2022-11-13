package com.example.coding.search.binary;

/**
 * https://www.youtube.com/watch?v=FzvK5uuaki8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=13
 *
 *
 */
public class SearchElementInInfiniteSortedArray {

    public static int findElement(int[] nums, int element) {
        int start = 0;
        int end = 1;
        //Need to assign end as 1. Increment till search element is higher than nums[end]. Once smaller,
        // then we have target between start and end. Apply binary search after that.
        while (element > nums[end]) {
            start = end;
            end = end*2;
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,14,18,29,30,34,35,46,48,49,50};
        int element = 14;
    }
}
