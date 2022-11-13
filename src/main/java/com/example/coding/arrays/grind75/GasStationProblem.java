package com.example.coding.arrays.grind75;

/**
 * There are n gas stations along a circular route, where the amount of gas at the
 * ith station is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
 * from the ith station to its next (i + 1)th station. You begin the journey with an empty
 * tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost, return the starting gas station's index if you can
 * travel around the circuit once in the clockwise direction, otherwise return -1.
 * If there exists a solution, it is guaranteed to be unique
 */
public class GasStationProblem {

    /**
     * https://www.youtube.com/watch?v=lJwbPZGo05A
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currentGas = 0;
        int startPoint = 0;

        for (int ct = 0; ct < gas.length; ct++) {
            currentGas += gas[ct] - cost[ct];
            totalGas += gas[ct] - cost[ct];

            if (currentGas < 0) {
                currentGas = 0;
                startPoint = ct+1;
            }
        }

        return totalGas < 0 ? -1 : startPoint;
    }

    public static void main(String[] args) {
       int[] gas = {1,2,3,4,5};
       int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }
}
