package com.example.coding.sort.basic;

public class RadixSort {

  /**
   * 345, 567,231,589
   * Compare unit digits and sort : 231 345 567 589
   * 10th digit : 231 345 567 589
   * 100th digit : 231 345 567 589
   *
   * We have to do count sort for each digit.
   */

  public static void radixSort(int[] nums) {

    //Count sort will run for number of digits in the max of the array
    int max = Integer.MIN_VALUE;

    for (int num : nums) {
      if (num > max) {
        max = num;
      }
    }



  }

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

  }
}
