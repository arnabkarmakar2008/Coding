package com.example.coding.greedy.leetcode.easy;

/**
 * At a lemonade stand, each lemonade costs $5. Customers are standing
 * in a queue to buy from you and order one at a time (in the order specified by bills).
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
 * You must provide the correct change to each customer so that the net transaction is that
 * the customer pays $5.
 *
 * Note that you do not have any change in hand at first.
 *
 * Given an integer array bills where bills[i] is the bill the ith customer pays, return
 * true if you can provide every customer with the correct change, or false otherwise.
 */
public class LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        int cashInHand = 0;

        for (int ct = 0; ct< bills.length; ct++) {
            if (bills[ct] == 5) {
                cashInHand += 5;
            } else if (bills[ct] == 10) {
                if (cashInHand < 5) {
                    return false;
                } else {
                    cashInHand += 5;
                }

            } else {
                if (cashInHand < 15) {
                    return false;
                } else {
                    cashInHand += 5;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        System.out.println(lemonadeChange(bills));
    }
}
