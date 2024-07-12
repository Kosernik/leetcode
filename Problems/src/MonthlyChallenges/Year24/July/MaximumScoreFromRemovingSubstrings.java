package MonthlyChallenges.Year24.July;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        MaximumScoreFromRemovingSubstrings solution = new MaximumScoreFromRemovingSubstrings();

        String test0 = "cdbcbbaaabab";
        int x0 = 4;
        int y0 = 5;
        System.out.println(solution.maximumGain(test0, x0, y0) == 19);
    }

    /**
     * LeetCode №1717. Maximum Score From Removing Substrings.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string.
     * @param x - the score for removing "ab" substring from s.
     * @param y - the score for removing "ba" substring from s.
     * @return - the maximum score after applying remove operations.
     */
    public int maximumGain(String s, int x, int y) {
        if (x >= y) {
            return removeABFirst(s, x, y);
        } else {
            return removeBAFirst(s, x, y);
        }
    }

    private int removeABFirst(String s, int x, int y) {
        int score = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (char letter : s.toCharArray()) {
            if (letter == 'a') {
                stack.push(letter);
            } else if (letter == 'b') {
                if (!stack.isEmpty() && stack.peek() == 'a') {
                    stack.pop();
                    score += x;
                } else {
                    stack.push(letter);
                }
            } else {
                score += y * getMinCount(stack);
                stack.clear();
            }
        }

        score += y * getMinCount(stack);

        return score;
    }

    private int removeBAFirst(String s, int x, int y) {
        int score = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (char letter : s.toCharArray()) {
            if (letter == 'a') {
                if (!stack.isEmpty() && stack.peek() == 'b') {
                    stack.pop();
                    score += y;
                } else {
                    stack.push(letter);
                }
            } else if (letter == 'b') {
                stack.push(letter);
            } else {
                score += x * getMinCount(stack);
                stack.clear();
            }
        }

        score += x * getMinCount(stack);

        return score;
    }

    private int getMinCount(Deque<Character> stack) {
        if (stack.isEmpty()) return 0;
        char last = stack.peek();
        int count = 0;
        while (!stack.isEmpty() && stack.peek() == last) {
            stack.pop();
            count++;
        }
        return Math.min(stack.size(), count);
    }
}
