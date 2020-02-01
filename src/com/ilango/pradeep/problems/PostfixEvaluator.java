package com.ilango.pradeep.problems;
import java.util.Stack;

public class PostfixEvaluator {

    public static int evaluate(String input) {

        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            }
            else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result;
                switch(c) {
                    case '+' :
                        stack.push(op1 + op2);
                        break;
                    case '-':
                        stack.push(op1 - op2);
                        break;
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    case '/':
                        stack.push(op1 / op2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "231*+9-";
        System.out.println(PostfixEvaluator.evaluate(expression));
    }
}
