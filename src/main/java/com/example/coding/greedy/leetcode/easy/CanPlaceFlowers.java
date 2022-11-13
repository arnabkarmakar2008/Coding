package com.example.coding.greedy.leetcode.easy;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
 * and an integer n, return if n new flowers can be planted in the flowerbed without violating the
 * no-adjacent-flowers rule.
 */
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int ct = 0; ct < flowerbed.length && n > 0; ct++) {
            if (ct == 0 && flowerbed[ct] == 0 && flowerbed[ct+1] == 0) {
                flowerbed[ct] = 1;
                n--;
            } else if (ct == flowerbed.length-1 && flowerbed[flowerbed.length-2] == 0 && flowerbed[flowerbed.length-1] == 0) {
                flowerbed[ct] = 1;
                n--;
            } else {
                if (flowerbed[ct] == 0 && flowerbed[ct-1] == 0 && flowerbed[ct+1]== 0) {
                    flowerbed[ct] = 1;
                    n--;
                }
            }
        }

        return n == 0;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1,0,0};
        int newFlower = 2;

        System.out.println(canPlaceFlowers(flowerbed, newFlower));
    }
}
