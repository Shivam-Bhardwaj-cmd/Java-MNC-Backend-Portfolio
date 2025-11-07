package day27;

import java.util.Stack;

public class BalancedParenthesesDemo {
    public static void main(String[] args) {
        String expr1 = "{[()]}";
        String expr2 = "{[(])}";
        String expr3 = "((()))";

        System.out.println(expr1 + " → " + isBalanced(expr1));
        System.out.println(expr2 + " → " + isBalanced(expr2));
        System.out.println(expr3 + " → " + isBalanced(expr3));
    }

    static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{'))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
