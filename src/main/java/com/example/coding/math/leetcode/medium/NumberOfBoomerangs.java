package com.example.coding.math.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given n points in the plane that are all distinct,
 * where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k)
 * such that the distance between i and j equals the distance between i and
 * k (the order of the tuple matters).
 *
 * Return the number of boomerangs.
 */
public class NumberOfBoomerangs {

    /**
     * For each point, calculate the distance of all other points.
     * Store the distance and count of points in map.
     *
     * Now lets say from point A, there are point B, C, and D in the same distance say 2 units.
     * Then number of boomerangs will be :
     *
     * [A, B, C]
     * [A, C, B]
     * [A, B, D]
     * [A, D, B]
     * [A, C, D]
     * [A, D, C]
     *
     * Basically we have to place 3 elements in two positions. So count will be
     * 3 * (3-1) = 6
     *
     * @param points
     * @return
     */
    public static int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> distanceMap = new HashMap<>();

        for (int i=0; i< points.length; i++) {
            for (int j=0; j < points.length; j++) {
                if (i == j) continue; // if same point then continue

                int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                        (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);

                distanceMap.put(distance, distanceMap.getOrDefault(distance, 0) + 1);
            }

            for (int count : distanceMap.values()) {
                result += count * (count-1);
            }

            distanceMap.clear(); //clear the map to compute for all points
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println(numberOfBoomerangs(points));
    }
}
