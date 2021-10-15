package com.example.coding.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ReverseStack {
    public static void main(String[] args) {
        Vector<Integer> intVector = new Vector<>();
        intVector.addAll(Arrays.asList(1,2,3,4,5));

        solve(intVector);
        System.out.println(intVector);
    }

    public static void solve(Vector<Integer> intVector) {
        //Base Condition
        if (intVector.size() == 1) {
            return;
        }

        int temp = intVector.get(intVector.size() - 1);
        intVector.remove(intVector.size() - 1);
        solve(intVector);

        insertInRightPlace(intVector, temp);

    }

    public static void insertInRightPlace(Vector<Integer> intVector, int element) {
        if (intVector.size() == 0) {
            intVector.add(element);
            return;
        }

        int temp = intVector.get(intVector.size() - 1);
        intVector.remove(intVector.size() - 1);
        insertInRightPlace(intVector, element);

        intVector.add(temp);
    }
}
