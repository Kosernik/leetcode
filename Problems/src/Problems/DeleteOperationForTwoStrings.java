package Problems;

public class DeleteOperationForTwoStrings {

    /**
     * LeetCode #583. Delete Operation for Two Strings.
     *
     * Complexity - O(m*n), m = word1.length(), n = word2.length()
     * Memory - O(m*n)
     *
     * @param word1 - a string, not null.
     * @param word2 - a string, not null.
     * @return - the minimum number of deletions required to make word1 and word2 the same.
     */
    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);

        return word1.length() + word2.length() - 2*lcs;
    }

    //  LeetCode #1143. Longest Common Subsequence.
    //  Returns the length of the longest common subsequence.
    private int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dpArr = new int[length1+1][length2+1];
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        for (int h = 0; h < length1+1; h++) {
            dpArr[h][0] = 0;
        }
        for (int w = 0; w < length2+1; w++) {
            dpArr[0][w] = 0;
        }

        for (int i = 1; i < length1+1; i++) {
            for (int j = 1; j < length2+1; j++) {
                if (char1[i-1] == char2[j-1]) {
                    dpArr[i][j] = 1 + dpArr[i-1][j-1];
                } else {
                    dpArr[i][j] = Math.max(dpArr[i-1][j], dpArr[i][j-1]);
                }
            }
        }
        return dpArr[length1][length2];
    }
}
