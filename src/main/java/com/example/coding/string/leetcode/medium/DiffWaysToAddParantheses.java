package com.example.coding.string.leetcode.medium;

import java.util.*;

/**
 * Given a string expression of numbers and operators, return all possible
 * results from computing all the different possible ways to group numbers and operators.
 * You may return the answer in any order.
 *
 * Input: expression = "2*3-4*5"
 * Output: [-34,-14,-10,-10,10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 */
public class DiffWaysToAddParantheses {

    /**
     * https://www.youtube.com/watch?v=binXv9-uT3A
     * @param expression
     * @return
     */
    public static List<Integer> diffWaysToCompute(String expression, Map<String, List<Integer>> memoMap) {
        List<Integer> resultList = new ArrayList<>();

        for (int start=0; start < expression.length(); start++) {
            char ch = expression.charAt(start);

            if (ch == '+' || ch == '-' || ch == '*') {
                String firstPart = expression.substring(0, start);
                String secondPart = expression.substring(start+1);

                List<Integer> firstPartResult = null;

                if (memoMap.containsKey(firstPart)) {
                    firstPartResult = memoMap.get(firstPart);
                } else {
                    firstPartResult = diffWaysToCompute(firstPart, memoMap);
                    memoMap.put(firstPart, firstPartResult);
                }

                List<Integer> secondPartResult = null;

                if (memoMap.containsKey(secondPart)) {
                    secondPartResult = memoMap.get(secondPart);
                } else {
                    secondPartResult = diffWaysToCompute(secondPart, memoMap);
                    memoMap.put(secondPart, secondPartResult);
                }

                for (Integer firstInt : firstPartResult) {
                    for (Integer secondInt : secondPartResult) {
                        if (ch == '+') {
                            resultList.add(firstInt + secondInt);
                        }

                        if (ch == '-') {
                            resultList.add(firstInt - secondInt);
                        }

                        if (ch == '*') {
                            resultList.add(firstInt * secondInt);
                        }
                    }
                }
            }
        }

        //At the leaf node we will have integer only. So just return integer back in the list.
        if (resultList.size() == 0) {
            resultList.add(Integer.valueOf(expression));
            memoMap.put(expression, Arrays.asList(Integer.valueOf(expression)));
        }

        return resultList;
    }

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> resultList = diffWaysToCompute(expression, map);

        System.out.println(resultList);
    }
}
