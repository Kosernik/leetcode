package MonthlyChallenges.Year24.July;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    /**
     * LeetCode №1190. Reverse Substrings Between Each Pair of Parentheses.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param s - a string with letters and parentheses. All parentheses are balanced.
     * @return - a string after reversing all strings in side matching parentheses, starting from the innermost one.
     * Resulting string does not consist any parentheses.
     */
    public String reverseParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] letters = s.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == '(') {
                stack.push(i);
            } else if (letters[i] == ')') {
                int startIdx = stack.pop();
                reverseArray(letters, startIdx, i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : letters) {
            if (ch == '(' || ch == ')') continue;
            result.append(ch);
        }

        return result.toString();
    }

    private void reverseArray(char[] letters, int startIdx, int endIdx) {
        startIdx++;
        endIdx--;
        while (startIdx < endIdx) {
            char temp = letters[startIdx];
            letters[startIdx] = letters[endIdx];
            letters[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
    }
}
