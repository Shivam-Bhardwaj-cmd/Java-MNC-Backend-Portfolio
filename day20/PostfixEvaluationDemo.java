package day20;

import java.util.Stack;

public class PostfixEvaluationDemo {
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

    public static void main(String[] args) {
        String expr1 = "23*54*+9-";
        String expr2 = "231*+9-";

        System.out.println(expr1 + " → Result: " + evaluatePostfix(expr1));
        System.out.println(expr2 + " → Result: " + evaluatePostfix(expr2));
    }
}
