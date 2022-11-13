package com.example.coding.priorityqueue.leetcode.hard;

import java.util.Arrays;
import java.util.List;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in
 * that city when viewed from a distance. Given the locations and heights of all the buildings,
 * return the skyline formed by these buildings collectively.
 *
 * The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
 *
 * lefti is the x coordinate of the left edge of the ith building.
 * righti is the x coordinate of the right edge of the ith building.
 * heighti is the height of the ith building.
 * You may assume all buildings are perfect rectangles grounded on an absolutely
 * flat surface at height 0.
 *
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate
 * in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
 *
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline.
 * For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines
 * of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]

 Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 Explanation:
 Figure A shows the buildings of the input.
 Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.

 */
public class SkylineProblem {

    static class BuildingPoint {
        int x;
        int height;
        boolean start;

        public BuildingPoint() {
        }

        /**
         * Compare x.
         * if x is same, and we are comparing start, then higher height bldg should come first
         * if x is same, and we are comparing end, then lower height bldg should come first
         * if x is same, and we are comparing start and end, then start should come first
         * @param buildingPoint
         * @return
         */
        public int compareTo(BuildingPoint buildingPoint) {
            if (buildingPoint.x != this.x) {
                return this.x - buildingPoint.x;
            } else {
                return (this.start ? -this.height : this.height) - (buildingPoint.start ? -buildingPoint.height : buildingPoint.height);
            }
        }
    }

    /**
     * Tushar Roy : https://www.youtube.com/watch?v=GSBLe8cKu0s
     *
     * Create structure like x - height - s/e from the buildings array
     * [[2,9,10],[3,7,15]]
     * Above will create below:
     *
     * 2 10 s
     * 9 10 e
     * 3 15 s
     * 7 15 e
     *
     * Sort this based on start
     *
     * There are 3 edge cases :
     * If start of the builds are same, then read building with greater height first
     * If end of the buildings are same, then read building with the lowest height first
     * If end and start of the buildings are same, then read building with start first
     *
     *
     *
     * Algo : Put height in the PQ for s. If PQ max changes. then add this to result.
     * For end, remove element from PQ. If PQ max changes, then add removed element and max from PQ in the result
     *
     * TC : We are adding, removing and getting max from PQ.  We are doing this for 2* N times.
     * So TC = NLogN
     *
     * @param buildings
     * @return
     */
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[2*buildings.length];
        int index = 0;
        for (int[] building : buildings) {
            BuildingPoint buildingPointStart = new BuildingPoint();
            buildingPointStart.x = building[0];
            buildingPointStart.height = building[2];
            buildingPointStart.start = true;

            buildingPoints[index] = buildingPointStart;

            BuildingPoint buildingPointEnd = new BuildingPoint();
            buildingPointEnd.x = building[1];
            buildingPointEnd.height = building[2];
            buildingPointEnd.start = false;

            buildingPoints[++index] = buildingPointStart;

        }

        Arrays.sort(buildingPoints);

        return null;
    }

    public static void main(String[] args) {

    }
}
