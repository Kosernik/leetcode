package MonthlyChallenges.Year24.April;

import java.util.HashMap;
import java.util.Map;

public class LongestIdealSubsequence {
    public static void main(String[] args) {
        LongestIdealSubsequence solution = new LongestIdealSubsequence();

        String s0 = "acfgbd";
        int k0 = 2;
        System.out.println(solution.longestIdealString(s0, k0) == 4);

        String s1 = "abcd";
        int k1 = 3;
        System.out.println(solution.longestIdealString(s1, k1) == 4);

        String s2 = "pvjcci";
        int k2 = 4;
        System.out.println(solution.longestIdealString(s2, k2) == 2);

        String s3 = "eduktdb";
        int k3 = 15;
        System.out.println(solution.longestIdealString(s3, k3) == 5);
    }

    /**
     * LeetCode №2370. Longest Ideal Subsequence.
     * <p>
     * Complexity - O(N*k), N = s.length, k = k
     * Memory - O(N)
     *
     * @param s - a string of lowercase English letters.
     * @param k - an integer, 0 <= k <= 25.
     * @return - the length of the longest ideal string.
     */
    public int longestIdealString(String s, int k) {
        int[][] dp = new int[s.length() + 1][2];

        Map<Character, Integer> charLastIdx = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char curLetter = s.charAt(i);

            int curCharIdx = charLastIdx.getOrDefault(curLetter, -1);
            int prevValid = curCharIdx == -1 ? 0 : dp[curCharIdx + 1][0];

            for (int j = 1; j <= k; j++) {
                char prev = (char) (curLetter - j);
                int prevIdx = charLastIdx.getOrDefault(prev, -1);
                if (prevIdx != -1) {
                    prevValid = Math.max(prevValid, dp[prevIdx + 1][0]);
                }

                char next = (char) (curLetter + j);
                int nextIdx = charLastIdx.getOrDefault(next, -1);
                if (nextIdx != -1) {
                    prevValid = Math.max(prevValid, dp[nextIdx + 1][0]);
                }
            }

            dp[i + 1][0] = prevValid + 1;
            dp[i + 1][1] = Math.max(dp[i][0], dp[i][1]);

            charLastIdx.put(curLetter, i);
        }

        return Math.max(dp[s.length()][0], dp[s.length()][1]);
    }
}
