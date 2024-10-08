package MonthlyChallenges.Year24.October;

import java.util.ArrayDeque;

public class MinimumNumberOfSwapsToMakeStringBalanced {

    /**
     * LeetCode №1963. Minimum Number of Swaps to Make the String Balanced.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of '[' and ']'. s.length is even. s consists of exactly length/2 opening brackets '[' and
     *          length/2 closing brackets ']'.
     * @return - the minimum number of swaps to make s balanced.
     */
    public int minSwaps(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char letter : s.toCharArray()) {
            if (letter == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(letter);
        }

        return (int) Math.ceil(stack.size() / 4.0);
    }
}
