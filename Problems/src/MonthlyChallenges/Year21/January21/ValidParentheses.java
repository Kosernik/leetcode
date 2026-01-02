package MonthlyChallenges.Year21.January21;

import java.util.ArrayDeque;

public class ValidParentheses {
    /**
     * LeetCode #20.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string containing characters '(', ')', '{', '}', '[' and ']'.
     * @return - True - if all parentheses valid, false - otherwise.
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.offer(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char prev = stack.peekLast();
                if ((prev == '(' && c == ')') || (prev == '{' && c == '}') || (prev == '[' && c == ']')) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
