package MonthlyChallenges.Year22.May;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {

    /**
     * LeetCode #32. Longest Valid Parentheses.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of '(' and ')'.
     * @return - the length of the longest valid (well-formed) parentheses substring.
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        int result = 0;
        char[] parentheses = s.toCharArray();

        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i] == '(') {
                stack.push(i);
            } else {
                int prevIdx = stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int curRes = i - stack.peek();
                    result = Math.max(result, curRes);
                }
            }
        }

        return result;
    }
}
