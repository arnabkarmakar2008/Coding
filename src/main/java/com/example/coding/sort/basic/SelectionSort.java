package com.example.coding.sort.basic;

/**
 * Time Complexity
 *
 * Best Case : Sorted ascending order. 10 20 30 40 50 60. For 10 there are 5 comp. For 20 there are 4 comp. For 30 there are 3 comp.
 * So total 0+1+2+3+4..+(N-1) = N(N-1)/2 = O(N^2)
 *
 * Worst Case : Sorted descending order. 60 50 40 30 20 10. There are n-1, n-2 , n-3...1 comp. N(N-1)/2 = O(N^2)
 *
 *
 */

public class SelectionSort {

  /**
   * 2 9 5 1 3
   * @param nums
   */
  public static void insertionSort(int[] nums) {
    if (nums.length == 0 || nums.length == 1) {
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      int minIndex = i;
      for (int j = i+1; j < nums.length; j++) {

        if (nums[j] < nums[minIndex] ) {
          minIndex = j;
        }
      }

      swap(nums, i, minIndex);
    }
  }


  private static void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  private static boolean isSmaller(int[] nums, int i, int j) {
    return (nums[i] < nums[j]);
  }

  public static void main(String[] args) {
    int[] nums = {2, 9,5,1,3};
    insertionSort(nums);

    for (int num : nums) {
      System.out.println(num);
    }
  }
}
