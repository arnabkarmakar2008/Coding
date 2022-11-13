package com.example.coding.math.leetcode.medium;

public class MultiplyStringNumbers {

    public static String multiply(String num1, String num2) {

        int l1 = num1.length();
        int l2 = num2.length();
        int[] resultArray = new int[l1+l2]; // Size of the result can be max till l1+l2

        int pf = 0; //this is to control the X we put in manual multiplication
        int i = l1-1;

        while (i >= 0) {
            int iVal = num1.charAt(i) - '0';

            int k = resultArray.length-1 - pf;
            int carry = 0;
            int j = l2-1;

            while (j >=0 || carry != 0) {
                int jVal = j >= 0 ? num2.charAt(j) - '0' : 0;
                int prod = iVal * jVal + carry + resultArray[k];

                resultArray[k] = prod%10;
                carry = prod/10;
                k--;
                j--;

            }
            pf++;
            i--;
        }

        StringBuilder strBuilder = new StringBuilder();
        boolean flag = false;

        for (int ct = 0; ct < resultArray.length; ct++) {
            if (resultArray[ct] == 0 && flag == false) {
                continue;
            } else {
                flag = true;
                strBuilder.append(resultArray[ct]);
            }
        }

        return strBuilder.toString();

    }

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "456";
        System.out.println(multiply(str1, str2));
    }
}
