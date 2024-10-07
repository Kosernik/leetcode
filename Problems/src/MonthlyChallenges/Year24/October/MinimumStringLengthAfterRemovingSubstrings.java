package MonthlyChallenges.Year24.October;

import java.util.ArrayDeque;

public class MinimumStringLengthAfterRemovingSubstrings {

    /**
     * LeetCode №2696. Minimum String Length After Removing Substrings.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     * <p>
     * Remove operation: you can remove any occurrence of one of the substrings "AB" or "CD" from s.
     *
     * @param s - a string.
     * @return - the minimum possible length of the resulting string after performing remove operations.
     */
    public int minLength(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char letter : s.toCharArray()) {
            if (letter == 'B') {
                if (!stack.isEmpty() && stack.peek() == 'A') {
                    stack.pop();
                    continue;
                }
            } else if (letter == 'D') {
                if (!stack.isEmpty() && stack.peek() == 'C') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(letter);
        }

        return stack.size();
    }
}
