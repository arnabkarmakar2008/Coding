package com.example.coding.math.leetcode.medium;

/**
 * Given the coordinates of two rectilinear rectangles in a 2ay2 plane, return
 * the total area covered by the two rectangles.
 *
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right
 * corner (ax2, ay2).
 *
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right
 * corner (bx2, by2).
 */
public class RectangleArea {

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int E, int F, int G, int H) {
        int areaRect1 = 0;
        int areaRect2 = 0;

        areaRect1 = (ax2-ax1) * (ay2-ay1);
        areaRect2 = (G-E) * (H-F);

        int left = Math.max(ax1, E);
        int right = Math.min(ax2, G);
        int top = Math.min(ay2, H);
        int bottom = Math.max(ay1, F);
        int overLap = 0;
        if (right > left && top > bottom) {
            overLap = (right - left) * (top - bottom);
        }

        return areaRect1+ areaRect2 - overLap;
    }

    public static void main(String[] args) {
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;

        System.out.println(computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));

    }
}
