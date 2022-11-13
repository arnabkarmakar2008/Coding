package com.example.coding.greedy.leetcode.easy;

import java.util.Arrays;

/**
 * Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie.
 *
 * Each child i has a greed factor g[i], which is the minimum size of a cookie
 * that the child will be content with; and each cookie j has a size s[j].
 * If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be
 * content. Your goal is to maximize the number of your content children and output
 * he maximum number.
 */
public class AssignCookies {

    public static int findContentChildren(int[] greedFactor, int[] cookieSize) {
        Arrays.sort(greedFactor);
        Arrays.sort(cookieSize);

        int cookieSizeStart = 0;
        int count = 0;

        for (int i = 0; i < greedFactor.length; i++) {
            while ((cookieSizeStart < cookieSize.length && greedFactor[i] > cookieSize[cookieSizeStart])) {
                cookieSizeStart++;
            }

            if (cookieSizeStart < cookieSize.length) {
                count++;
            }

            cookieSizeStart++;
        }

        return count;
    }


    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};

        System.out.println(findContentChildren(g, s));
    }
}
