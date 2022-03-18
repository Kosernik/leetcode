package Problems;

import java.util.ArrayDeque;

public class EvaluateReversePolishNotation {

    /**
     * LeetCode #150. Evaluate Reverse Polish Notation.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param tokens - tokens[i] is either an operator: "+", "-", "*", or "/", or an integer.
     * @return - the result of all operations.
     */
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first + second);
            } else if (token.equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if (token.equals("*")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first * second);
            } else if (token.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
