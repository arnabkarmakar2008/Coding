package com.example.coding.stack;

public class RainDropping {
    public static void main(String[] args) {
        int arr[] = {3,0,0,2,0,4};
        System.out.println(solve(arr, 6));
    }

    public static int solve(int[] arr, int size) {
        int[] maxL = new int[size];
        int[] maxR = new int[size];
        int[] water = new int[size];


        maxL[0] = arr[0];

        maxR[size-1] = arr[size-1];

        for (int i=1; i<size; i++) {
            maxL[i] = Math.max(maxL[i-1], arr[i]);
        }

        for (int j = size-2; j>=0; j--) {
            maxR[j] = Math.max(maxR[j+1], arr[j]);
        }

        for (int k=0; k<size-1; k++) {
            water[k] = Math.min(maxL[k], maxR[k]) - arr[k];
        }

        int sum = 0;

        for (int k=0; k<size-1; k++) {
            sum = sum + water[k];
        }

        return sum;

    }
}
