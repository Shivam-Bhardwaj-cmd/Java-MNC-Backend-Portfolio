package day22;
import java.util.Stack;

public class ExpressionEvaluationDemo {

    public static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val2 = stack.pop();
                int val1 = stack.pop();

                switch (c) {
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
        String exp = "231*+9-"; // equivalent to ((2 + 3*1) - 9)
        System.out.println("Postfix Expression: " + exp);
        System.out.println("Evaluation Result: " + evaluatePostfix(exp));
    }
}
