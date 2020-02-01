package com.ilango.pradeep.problems;

import java.util.Stack;

public class ParenthesisValidator {

    public static boolean validate(char[] input) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<input.length; i++) {
            if (input[i] == '[' || input[i] == '{' || input[i] == '(') {
                stack.push(input[i]);
            }
            if (input[i] == ']' || input[i] == '}' || input[i] == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                else if (!isMatchingPair(stack.pop(), input[i])) {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isMatchingPair(char a, char b) {
        if (a == '{' && b == '}') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        if (a == '(' && b ==')') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[] input = {'{','(',')','}','[',']'};
        if (ParenthesisValidator.validate(input)) {
            System.out.println("Parenthesis are Balanced");
        } else {
            System.out.println("Parenthesis are not Balanced");
        }

        char[] input1 = {'{','(','}',')','[',']'};
        if (ParenthesisValidator.validate(input1)) {
            System.out.println("Parenthesis are Balanced");
        } else {
            System.out.println("Parenthesis are not Balanced");
        }
    }
}
