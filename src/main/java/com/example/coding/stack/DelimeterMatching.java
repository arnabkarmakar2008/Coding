package com.example.coding.stack;

public class DelimeterMatching {
    public static void main(String[] args) {
        String input = "[ab{cd{(de)}]";
        MyStack myStack = new MyStack(input.length());
        for (int i=0; i < input.length(); i++) {
            char tempChar = input.charAt(i);

            if (tempChar == '{' || tempChar == '(' || tempChar == '[') {
                myStack.push(tempChar);
            } else if (tempChar == '}') {
                if (!((Character)myStack.pop()).equals('{')) {
                    System.out.println("Issue at index :: " + i);
                    break;
                }
            } else if (tempChar == ')') {
                if (!((Character)myStack.pop()).equals('(')) {
                    System.out.println("Issue at index :: " + i);
                    break;
                }
            } else if (tempChar == ']') {
                if (!((Character)myStack.pop()).equals('[')) {
                    System.out.println("Issue at index :: " + i);
                }
                break;
            }
        }
    }
}
