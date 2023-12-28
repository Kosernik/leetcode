package MonthlyChallenges.Year23.December;

import java.util.Arrays;

public class StringCompressionII {

    /**
     * LeetCode №1531. String Compression II.
     *
     * @param s - a string.
     * @param k - the maximum number of characters that can be removed.
     * @return - the minimum length of the run-length encoded version of s after deleting at most k characters.
     */
    public int getLengthOfOptimalCompression(String s, int k) {
        int[][] dp = new int[s.length() + 1][k + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        Arrays.fill(dp[0], 0);

        char[] letters = s.toCharArray();
        for (int i = 1; i <= letters.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (j > 0) { // removing current letter
                    dp[i][j] = dp[i - 1][j - 1];
                }

                int removed = 0;
                int length = 0;
                for (int left = i; left > 0; left--) {
                    if (letters[left - 1] == letters[i - 1]) {
                        length++;
                    } else {
                        removed++;
                        if (removed > j) break;
                    }

                    dp[i][j] = Math.min(dp[i][j], dp[left - 1][j - removed] + getNumberLength(length) + 1);
                }
            }
        }
        return dp[s.length()][k];
    }

    private int getNumberLength(int length) {
        if (length >= 100) return 3;
        else if (length >= 10) return 2;
        else if (length >= 2) return 1;
        return 0;
    }
}
