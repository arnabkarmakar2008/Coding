package com.example.coding.board;

import java.util.Arrays;
import java.util.Locale;
import java.util.Vector;

public class Recursion {

    public static void main(String[] args) {

        Vector<Integer> inputVector = new Vector<>();
        inputVector.addAll(Arrays.asList(5, 4, 3, 2, 1));
        solve(inputVector);
        System.out.println(inputVector);

        //solve(input, output);
    }

    private static void solve(Vector<Integer> inputVector) {

        if (inputVector.size() == 1) {
            return;
        }

        int temp = inputVector.get(inputVector.size()-1);
        inputVector.remove(inputVector.size()-1);
        solve(inputVector);

        insertInPlace(inputVector, temp);
    }

    private static void insertInPlace(Vector<Integer> inputVector, int temp) {
        if (inputVector.size() == 0) {
            inputVector.add(temp);
            return;
        }

        int top = inputVector.get(inputVector.size()-1);
        inputVector.remove(inputVector.size()-1);
        insertInPlace(inputVector, temp);
        inputVector.add(top);

    }
}
