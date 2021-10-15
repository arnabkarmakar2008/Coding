package com.example.coding.recursion;

import java.util.Arrays;
import java.util.Vector;

public class SortArray {
    public static void main(String[] args) {
        Vector<Integer> intVector = new Vector<>();
        intVector.addAll(Arrays.asList(2,5,1,6,0,8,9));
        arraySort(intVector);
        System.out.println(intVector);
    }

    public static void arraySort(Vector<Integer> intVector) {
        //Base Condition
        if (intVector.size() ==1) {
            return;
        }

        //Hypothesis
        int temp = intVector.get(intVector.size()-1);
        intVector.remove(intVector.size()-1);
        arraySort(intVector);

        //Induction
        insertRightPlace(intVector, temp);

    }

    public static void insertRightPlace(Vector<Integer> intVector, int num) {
        //Base
        if (intVector.size() == 0 || intVector.get(intVector.size()-1) <= num) {
            intVector.add(num);
            return;
        }

        //Hypo
        int val = intVector.get(intVector.size()-1);
        intVector.remove(intVector.size()-1);
        insertRightPlace(intVector, num);

        //Induction
        intVector.add(val);
    }
}
