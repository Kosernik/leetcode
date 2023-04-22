package MonthlyChallenges.Year23.April;

import java.util.Arrays;

public class MinimumInsertionStepsToMakeStringPalindrome {

    /**
     * LeetCode #1312. Minimum Insertion Steps to Make a String Palindrome.
     *
     * @param s - a string.
     * @return - he minimum number of insertions to make s palindrome.
     */
    public int minInsertions(String s) {
        int[][] computed = new int[s.length()][s.length()];
        for (int[] row : computed) {
            Arrays.fill(row, -1);
        }
        String reversed = new StringBuilder(s).reverse().toString();

        return s.length() - lcs(s.length() - 1, reversed.length() - 1, s, reversed, computed);
    }

    private int lcs(int firstIdx, int secondIdx, String first, String second, int[][] computed) {
        if (firstIdx < 0 || secondIdx < 0) {
            return 0;
        } else if (computed[firstIdx][secondIdx] != -1) {
            return computed[firstIdx][secondIdx];
        }
        int length;
        if (first.charAt(firstIdx) == second.charAt(secondIdx)) {
            length = lcs(firstIdx - 1, secondIdx - 1, first, second, computed) + 1;
        } else {
            length = Math.max(
                    lcs(firstIdx - 1, secondIdx, first, second, computed),
                    lcs(firstIdx, secondIdx - 1, first, second, computed));
        }
        computed[firstIdx][secondIdx] = length;
        return length;
    }
}
