package com.example.coding.math.leetcode.medium;

/**
 * You are given two jugs with capacities jug1Capacity and jug2Capacity liters.
 * There is an infinite amount of water supply available. Determine whether it is possible to
 * measure exactly targetCapacity liters using these two jugs.
 *
 * If targetCapacity liters of water are measurable, you must have targetCapacity liters of water
 * contained within one or both buckets by the end.
 *
 * Operations allowed:
 *
 * Fill any of the jugs with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full, or the first jug
 * itself is empty.
 */
public class WaterAndJugProblem {

    /**
     * There is math behind this problem. https://www.youtube.com/watch?v=0Oef3MHYEC0
     * We have to find the GCD of the jug capacities. Then we can measure GCD and multiples of GCD using
     * two jug capacities.
     * @param jug1Capacity
     * @param jug2Capacity
     * @param targetCapacity
     * @return
     */
    public static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }

        if (jug1Capacity == targetCapacity || jug2Capacity == targetCapacity
                || jug2Capacity+jug1Capacity == targetCapacity) {
            return true;
        }

        int gcd = getGCD(jug1Capacity, jug2Capacity);

        return targetCapacity%gcd == 0;
    }

    private static int getGCD (int num1, int num2) {
        int gcd = 0;

        for (int i=1; i<= num1; i++) {
            if (num1%i == 0 && num2%i ==0) {
                gcd = i;
            }
        }

        return gcd;
    }

    public static void main(String[] args) {
        int jug1Capacity = 6;
        int jug2Capacity = 15;
        int target = 10;

        System.out.println(canMeasureWater(jug1Capacity, jug2Capacity, target));

    }
}
