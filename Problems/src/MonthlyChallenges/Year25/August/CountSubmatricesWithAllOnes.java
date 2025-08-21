package MonthlyChallenges.Year25.August;

public class CountSubmatricesWithAllOnes {

    /**
     * LeetCode №1504. Count Submatrices With All Ones.
     * <p>
     * Complexity - O(N^2*M), N = mat.length, M = mat[i].length.
     * Memory - O(N*M)
     *
     * @param mat - a 2d array of 0 and 1.
     * @return - the number of submatrices that have all ones.
     */
    public int numSubmat(int[][] mat) {
        int result = 0;

        int length = mat.length, width = mat[0].length;
        int[][] dp = new int[length][width + 1];

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                if (mat[row][col] == 1) {
                    dp[row][col + 1] = dp[row][col] + 1;
                    int minWidth = dp[row][col + 1];

                    for (int i = row; i >= 0 && dp[i][col + 1] > 0; i--) {
                        minWidth = Math.min(minWidth, dp[i][col + 1]);
                        result += minWidth;
                    }
                }
            }
        }

        return result;
    }
}
