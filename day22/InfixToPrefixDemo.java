package day22;
import java.util.Stack;

public class InfixToPrefixDemo {
    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    public static String infixToPrefix(String exp) {
        StringBuilder reversed = new StringBuilder(exp).reverse();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);

            if (Character.isLetterOrDigit(c))
                result.append(c);
            else if (c == ')')
                stack.push(c);
            else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')')
                    result.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek()))
                    result.append(stack.pop());
                stack.push(c);
            }
        }

        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String exp = "(A-B/C)*(A/K-L)";
        System.out.println("Infix: " + exp);
        System.out.println("Prefix: " + infixToPrefix(exp));
    }
}
