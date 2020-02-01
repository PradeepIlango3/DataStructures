package com.ilango.pradeep.problems;

import java.util.Stack;

public class InfixToPostfixConverter {

    public static String convert(String input) {
        String output = new String();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                output += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    output += stack.pop();
                }
                stack.pop();
            } else {
                while ((!stack.isEmpty() && stack.peek()!='(') && (precedence(c) <= precedence(stack.peek()))) {
                    output += stack.pop();
                }
                stack.push(c);
            }
        }
        return output;
    }

    public static int precedence(char c) {
        switch(c) {
            case '+' :
                return 1;
            case '-' :
                return 1;
            case '*' :
                return 2;
            case '/' :
                return 2;
            case '^' :
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        String expression = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(InfixToPostfixConverter.convert(expression));
    }
}
