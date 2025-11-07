package day23;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String expr = "{[()]}";
        System.out.println(expr + " is " + (isValid(expr) ? "valid" : "invalid"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') || 
                    (ch == '}' && top != '{') || 
                    (ch == ']' && top != '['))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
