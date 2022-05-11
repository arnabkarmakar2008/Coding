package com.example.coding.sort.basic;

public class CountSort {

  /**
   * https://www.youtube.com/watch?v=p-OyKUgIrx4
   *
   * Get the min and max from nums. Create frequency array of size max-min+1.
   * Now fill the frequency array.
   *
   * 9 6 3 5 3 4
   *
   * Min = 3 Max= 9
   * feq[9-3+1] = feq[6] = new int[];
   *
   * Convert feq array to prefix sum array.
   *
   * Traverse main array from end and adjust prefix sum value.
   * https://www.youtube.com/watch?v=p-OyKUgIrx4
   * @param nums
   */
  public static int[] countSort(int[] nums) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int num : nums) {
      if (num < min) {
        min = num;
      }

      if (num > max) {
        max = num;
      }
    }

    int[] frequencyArray = getFrequencyArray(nums, min, max);
    getPrefixSumArray(frequencyArray);

    int[] sortedArray = new int[nums.length];

    for (int ct = nums.length-1; ct >=0; ct--) {
      //get value from prefix sum frequency array
      int currentNum = nums[ct];

      int prefixSumValue = frequencyArray[currentNum-min];
      sortedArray[prefixSumValue-1] = currentNum;
      frequencyArray[currentNum-min]--;
    }

    return sortedArray;

  }

  private static int[] getFrequencyArray(int[] nums,int min, int max) {
    int[] feqArray = new int[max-min+1];

    for (int ct = 0; ct < nums.length; ct++) {
      int currentNum = nums[ct];
      feqArray[currentNum-min]++;
    }

    return feqArray;
  }

  /**
   * Prefix sum will tell from which position to which position number will lie. Note we have to adjust
   * the sum to index by reducing one from it.
   * @param feqArray
   */
  private static void getPrefixSumArray(int[] feqArray) {
    for (int i=1; i< feqArray.length; i++) {
      feqArray[i] = feqArray[i] + feqArray[i-1];
    }
  }

  public static void main(String[] args) {
    int[] nums = {9,6,3,5,3,4,3,9,6,4,6,5,8,9,9};
    int[] sorted = countSort(nums);

    for (int num : sorted) {
      System.out.print( num + " ");
    }
  }
}
