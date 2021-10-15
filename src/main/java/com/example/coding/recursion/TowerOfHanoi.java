package com.example.coding.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        solve(3, 1, 3, 2);
    }

    public static void solve(int n, int source, int destination, int helper) {

        if (n == 1) {
            System.out.println("Moving Disc = "+ n +" from " + source + " to " + destination +" ");
            return;
        }

        solve(n-1, source, helper, destination);

        System.out.println("Moving Disc = "+ n +" from " + source + " to " + destination +" ");

        solve(n-1, helper, destination, source);

    }
}
