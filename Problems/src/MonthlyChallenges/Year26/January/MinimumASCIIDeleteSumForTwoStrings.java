package MonthlyChallenges.Year26.January;

public class MinimumASCIIDeleteSumForTwoStrings {
    public static void main(String[] args) {
        MinimumASCIIDeleteSumForTwoStrings solution = new MinimumASCIIDeleteSumForTwoStrings();

        String s1_0 = "sea";
        String s2_0 = "eat";
        int result0 = 231;
        System.out.println(solution.minimumDeleteSum(s1_0, s2_0) == result0);
    }

    /**
     * LeetCode №712. Minimum ASCII Delete Sum for Two Strings.
     *
     * @param s1 - a string of lowercase English letters.
     * @param s2 - a string of lowercase English letters.
     * @return - the lowest ASCII sum of deleted characters to make two strings equal.
     */
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 2];

        for (int i = 0; i < s1.length(); i++) {
            dp[i + 1][0] = dp[i][0] + s1.charAt(i);
        }
        for (int j = 0; j < s2.length(); j++) {
            dp[0][j + 1] = dp[0][j] + s2.charAt(j);
        }

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int removeBoth = dp[i][j] + s1.charAt(i) + s2.charAt(j);
                    int removeFirst = dp[i][j + 1] + s1.charAt(i);
                    int removeSecond = dp[i + 1][j] + s2.charAt(j);
                    dp[i + 1][j + 1] = Math.min(removeBoth, Math.min(removeFirst, removeSecond));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
