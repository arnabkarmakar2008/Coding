package com.example.coding.sort.basic;

public class InsertionSort {

  /**
   * 2 9 5 1 3
   *
   * Start with index 1. Compare with 0th index. So after first run 2 9
   * 2 nd run : Index at 5. compare with 9. 9 is greater. So swap between 9 and 5. So 2 5 9. Now compare
   * 2 and 5. Both are in correct position. So move to 1. Now array is 2 5 9 1 3.
   *
   * 3rd run : Comapre 1 and 9 -> Swap- ? 2 5 1 9 3->compare 5 and 1 -> swap -> 2 1 5 9 3 -> Compare 2 ad 1.
   * -> swap -> 1 2 5 9 3......
   *
   * Time Complexity
   *
   * Best Case : When array is sorted. 1 2 3 4 5 6 7. 1 is compared with 2. No swap needed. Then 2 is compared with 3.
   * then 3 is compared with 4 and so on. So there are N-1 comparison. So it is O(N)
   *
   * Worst Case : When array is reverse sorted. 7 6 5 4 3 2. 6 needs 1 comparison. 5 needs 2. 4 needs 3 comparisons. 3 needs 4 comparisons.
   * ... 2 needs 5 comparisons. So total we need 1+2+3+4+5 = 15 1+2+3+4+(N-1) = N*(N-1)/2 = N^2 -N = O(N^2)
   *
   * Average = O(N^2)
   * https://www.youtube.com/watch?v=MMt2x6an_i8 Pepcoding
   *
   * @param nums
   */
  public static void insertionSort(int[] nums) {
    if (nums.length == 0 || nums.length == 1) {
      return;
    }

    for (int i = 1; i < nums.length; i++) {
      for (int j = i-1; j >=0; j--) {
        if (isGreater(nums, j, j+1)) {
          swap(nums, j, j+1);
        } else {
          break;
        }
      }
    }
  }


  private static void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  private static boolean isGreater(int[] nums, int i, int j) {
    return (nums[i] > nums[j]);
  }

  public static void main(String[] args) {
    int[] nums = {2, 9,5,1,3};
    insertionSort(nums);

    for (int num : nums) {
      System.out.println(num);
    }
  }
}
