package day23;

import java.util.Stack;

public class EvaluatePostfix {
    public static void main(String[] args) {
        String expr = "231*+9-"; // Example: 2 + (3 * 1) - 9 = -4
        System.out.println("Postfix Expression: " + expr);
        System.out.println("Evaluation Result: " + evaluatePostfix(expr));
    }

    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int val2 = stack.pop();
                int val1 = stack.pop();
                switch (ch) {
                    case '+': stack.push(val1 + val2); break;
                    case '-': stack.push(val1 - val2); break;
                    case '*': stack.push(val1 * val2); break;
                    case '/': stack.push(val1 / val2); break;
                }
            }
        }
        return stack.pop();
    }
}
