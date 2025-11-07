package day21;
import java.util.Stack;

class Pair {
    int price;
    int span;
    Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

public class StockSpanProblemDemo {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);

        System.out.print("Stock Span: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }

    public static int[] calculateSpan(int[] prices) {
        int[] spans = new int[prices.length];
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            int span = 1;
            while (!stack.isEmpty() && stack.peek().price <= prices[i]) {
                span += stack.pop().span;
            }
            stack.push(new Pair(prices[i], span));
            spans[i] = span;
        }

        return spans;
    }
}
