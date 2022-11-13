package com.example.coding.slidingwindow.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array fruits where fruits[i] is the type
 * of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on
 * the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree
 * (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 */
public class FruitBaskets {

    public static int totalFruit(int[] fruits, int numberOfBaskets) {
        int start=0, end = 0;
        int maxFruitCount = Integer.MIN_VALUE;
        int windowFruitCount = 0;

        Map<Integer, Integer> fruitMap = new HashMap<>();

        while (end < fruits.length) {
            fruitMap.put(fruits[end], fruitMap.getOrDefault(fruits[end], 0)+1);
            windowFruitCount++;

            if (fruitMap.size() < numberOfBaskets) {
                end ++;
            } else if (fruitMap.size() == numberOfBaskets) {
                maxFruitCount  = Math.max(windowFruitCount, maxFruitCount);
                end++;
            } else if (fruitMap.size() > numberOfBaskets) {
                while (fruitMap.size() > numberOfBaskets) {
                    windowFruitCount -= fruitMap.get(fruits[start]);
                    fruitMap.remove(fruits[start]);
                    start++;

                }

                end++;
            }
        }

        return maxFruitCount;
    }

    public static void main(String[] args) {
        int[] fruits = {1,2,1};
        int numberOfBaskets = 2;

        System.out.println(totalFruit(fruits, numberOfBaskets));
    }
}
