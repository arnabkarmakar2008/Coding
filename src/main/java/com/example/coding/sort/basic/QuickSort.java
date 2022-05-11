package com.example.coding.sort.basic;

public class QuickSort {

  public static void quickSort(int[] nums, int low, int high) {

    if (low >= high) {
      return;
    }

    int pivot = nums[high];
    int pivotIndex = partitionArray(nums, pivot);
    quickSort(nums, 0, pivotIndex-1);
    quickSort(nums, pivotIndex+1, high);
  }

  public static int partitionArray(int[] nums, int pivot) {
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

    return j-1;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }


  public static void main(String[] args) {
    int[] nums = {7, 9, 4, 8, 3, 6, 2, 1};
    quickSort(nums, 0, nums.length-1);


    for (int num : nums) {
      System.out.println(num);
    }
  }
}
