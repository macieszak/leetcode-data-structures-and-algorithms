package leetcode_problems.stack.reverse_polish_notation;

import java.util.Stack;

public class RPN {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String value : tokens) {
            switch (value) {
                case "+" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    int result = a + b;
                    stack.push(result);
                }
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    int result = a - b;
                    stack.push(result);
                }
                case "*" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    int result = a * b;
                    stack.push(result);
                }
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    int result = a / b;
                    stack.push(result);
                }
                default -> stack.push(Integer.parseInt(value));
            }
        }
        return stack.pop();
    }

}
