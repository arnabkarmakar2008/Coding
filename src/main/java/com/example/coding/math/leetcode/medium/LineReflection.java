package com.example.coding.math.leetcode.medium;


import java.util.HashSet;
import java.util.Set;

/**
 * Set of points given. We can draw a mirror parallel to Y-axis. Have to determine if all teh points are reflection
 * of one another or not.
 *
 * {{1,1}, {-1,1}} = true
 */
public class LineReflection {

    /**
     * https://www.youtube.com/watch?v=ArsRc6Wqy1o&t=985s pepcoding
     * @param points
     * @return
     */
    public static boolean isReflected(int[][] points) {
        //get two extreme points from the list.

        long maxX = Integer.MIN_VALUE;
        long minX = Integer.MAX_VALUE;
        Set<Long> set = new HashSet<>();

        for (int i=0; i< points.length; i++) {
            int xVal = points[i][0];
            int yVal = points[i][1];

            maxX = Math.max(xVal, maxX);
            minX = Math.min(minX, xVal);
            set.add((long)xVal * 100000000 + yVal);
        }

        //So leftmost point's X value = minX and rightmost point's Y value = minY
        // So mirror can be drawn at middle. So mirror's X value will be maxX-minX/2 = mirror X
        long mirrorX = maxX + minX; //here mirrox represents 2 * mirrox value to avoid float.

        for (int i=0; i< points.length; i++) {
            long xVal = points[i][0];
            long yVal = points[i][1];

            long xImage = mirrorX - xVal;
            long yImage = yVal;

            if (!set.contains((long) xImage*100000000+yImage)) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int[][] points = {{1,1},{-1,-1}};
        System.out.println(isReflected(points));
    }
}
