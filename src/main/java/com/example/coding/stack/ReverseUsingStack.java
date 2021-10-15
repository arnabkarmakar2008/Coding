package com.example.coding.stack;

public class ReverseUsingStack {
    public static void main(String[] args) {
        String input = "arnabkarmakar";

        MyStack myStack = new MyStack(input.length());

        for (int i=0; i < input.length(); i++) {
            myStack.push(input.charAt(i));
        }

        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }
}
