package com.example.coding.math.leetcode.hard;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
 * return the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnALine {

    /**
     * p1 = (x1, y1) p2 = (x2, y2)
     * slope = y2-y1 / x2-x1
     *
     * If p3 = (x3,y3)
     *
     * y2-y1 / x2-x1 = y3-y1/x3-x1 then p1,p2 and p3 lie on same straight line
     *
     * @param p
     * @return
     */
    public static int maxPoints(int[][] p) {
        int size = p.length;

        if (size <=2) {
            return size;
        }

        int max = 2;

        for (int i=0; i< size; i++) {
            for (int j = i+1; j < size; j++) {
                int total = 2;
                for (int k = 0; k < size; k++) {
                    if (k != i && k != j) {
                        if ( (p[j][1] - p[i][1]) * (p[k][0] - p[i][0]) == (p[k][1] - p[i][1]) * (p[j][0] - p[i][0]) ) {
                            total++;
                        }
                    }
                }

                max = Math.max(max, total);
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[][] points = {{1,1}, {2,2}, {3,3}};
        System.out.println(maxPoints(points));
    }
}
