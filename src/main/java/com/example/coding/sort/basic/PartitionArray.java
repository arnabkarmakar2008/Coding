package com.example.coding.sort.basic;

/**
 * This is the base for quick sort
 */
public class PartitionArray {

  /**
   * Need to partition array based on pivot, All elements less or equal to will be in the left side and greater
   * will be right.
   *
   *          7   9   4   8   3   6   2   1
   *
   * We will have 3 region. Unknown = i -> end. Greater = j -> i . Less Equal = -> 0 -> j-1
   *
   * i and j both will start from 0.
   *
   * if ( a[i] > pivot) {
   *   i++;
   * } else if (a[i] <= pivot) {
   *   swap(a, i, j);
   *   i++;
   *   j++;
   * }
   *
   * @param nums
   * @param pivot
   * @return
   */
  public static int[] partitionArray(int[] nums, int pivot) {
    int i = 0;
    int j = 0;

    while (i < nums.length && j < nums.length) {
      if (nums[i] > pivot) {
        i++;
      } else {
        swap(nums, i, j);
        i++;
        j++;
      }
    }

    return nums;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  public static void main(String[] args) {
    int[] nums = {7, 9, 4, 8, 3, 6, 2, 1};
    nums = partitionArray(nums, 8);


    for (int num : nums) {
      System.out.println(num);
    }
  }
}
