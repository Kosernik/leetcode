package MonthlyChallenges.Year25.November;

import java.util.Arrays;
import java.util.stream.IntStream;

public class OnesAndZeroes {

    /**
     * LeetCode №474. Ones and Zeroes.
     * <p>
     * Complexity - O(S), S = strs.length, M = m, N = n.
     * Memory - O(S*M*N)
     *
     * @param strs - an array of binary strings.
     * @param m    - the maximum number of 0.
     * @param n    - the maximum number of 1.
     * @return - the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] computed = new int[strs.length][m + 1][n + 1];
        Arrays.stream(computed).forEach(ints -> IntStream.range(0, m + 1).forEach(j -> Arrays.fill(ints[j], -1)));

        return dp(0, strs, m, n, computed);
    }

    private int dp(int idx, String[] words, int zeroes, int ones, int[][][] computed) {
        if (idx >= words.length) {
            return 0;
        } else if (computed[idx][zeroes][ones] != -1) {
            return computed[idx][zeroes][ones];
        }

        int result = dp(idx + 1, words, zeroes, ones, computed);

        int[] count = countDigits(words[idx]);
        if (count[0] <= zeroes && count[1] <= ones) {
            int pickCurrent = 1 + dp(idx + 1, words, zeroes - count[0], ones - count[1], computed);

            result = Math.max(result, pickCurrent);
        }

        computed[idx][zeroes][ones] = result;
        return result;
    }

    private static int[] countDigits(String word) {
        int[] count = new int[2];

        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - '0']++;
        }

        return count;
    }
}
