package com.example.coding.recursion;

import java.util.Arrays;
import java.util.Vector;

public class DeleteMiddleElementOfStack {
    public static void main(String[] args) {
        /**
         * Middle element index = size/2 + 1;
         */

        Vector<Integer> intVector = new Vector<>();
        intVector.addAll(Arrays.asList(2,5,1,6,0,8,9));
        int middleElement = intVector.size()/2 + 1;

        solve(intVector, middleElement);
        System.out.println(intVector);
    }

    public static void solve(Vector<Integer> intVector, int middleElement) {
        if (middleElement == 1) {
            intVector.remove(intVector.size() -1);
            return;
        }

        int temp = intVector.remove(intVector.size() -1);
        solve(intVector, middleElement-1);

        intVector.add(temp);

    }
}
