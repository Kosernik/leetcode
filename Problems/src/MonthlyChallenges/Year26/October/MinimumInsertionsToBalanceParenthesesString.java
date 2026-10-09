package MonthlyChallenges.Year26.October;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumInsertionsToBalanceParenthesesString {

    /**
     * LeetCode №1541. Minimum Insertions to Balance a Parentheses String
     * <p>
     * A parentheses string is balanced if:
     * * Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
     * * Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
     *
     * @param s - a string of '(' and ')'.
     * @return - the minimum number of insertions needed to make s balanced.
     */
    public int minInsertions(String s) {
        int result = 0;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);

            if (curChar == '(') {
                if (!stack.isEmpty() && stack.peek() != '(') {
                    if (stack.peek() == ')') {
                        result++;
                    }

                    result++;
                    stack.pop();
                }

                stack.push('(');
            } else {    //  curChar == ')'
                if (stack.isEmpty()) {
                    stack.push(')');
                } else {
                    char top = stack.pop();
                    if (top == '(') {
                        stack.push('0');
                    } else if (top == ')') {
                        result++;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            char top = stack.pop();

            if (top == '(' || top == ')') {
                result++;
            }
            result++;
        }

        return result;
    }
}
