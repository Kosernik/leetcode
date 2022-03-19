package Problems;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();

        System.out.println(solution.longestPalindromeSubseq("bbbaba"));

//        StringBuilder builder = new StringBuilder();
//        Random r = new Random();
//
//        for (int i = 0; i < 1000; i++) {
//            int randInt = r.nextInt(26);
//
//            builder.append((char) ('a'+randInt));
//        }
//
//        System.out.println(builder.toString());
//        System.out.println(solution.longestPalindromeSubseq(builder.toString()));
    }

    /**
     * LeetCode #516. Longest Palindromic Subsequence.
     *
     * Complexity - O(N^2)
     * Memory - O(N^2)
     *
     * @param s - a string of english lowercase letters.
     * @return - the length of the longest palindrome subsequence.
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        char[] letters = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = s.length()- 1; i >= 0; i--) {
            for (int j = i+1; j < s.length(); j++) {
                if (letters[j] == letters[i]) {
                    int curMax = 0;
                    if (j+1 == i) {
                        curMax = 2;
                    } else {
                        curMax = dp[i + 1][j - 1] + 2;
                    }
                    dp[i][j] = curMax;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][dp.length-1];
    }
}
