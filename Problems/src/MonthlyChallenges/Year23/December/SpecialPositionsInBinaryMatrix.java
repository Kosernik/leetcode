package MonthlyChallenges.Year23.December;

public class SpecialPositionsInBinaryMatrix {

    /**
     * LeetCode №1582. Special Positions in a Binary Matrix.
     * <p>
     * Complexity - (m*n)
     * Memory - O(1)
     *
     * @param mat - an m*n matrix of 0 and 1.
     * @return - the number of special positions in mat.
     */
    public int numSpecial(int[][] mat) {
        int result = 0;

        int height = mat.length, width = mat[0].length;
        int[] onesInRow = new int[height];
        int[] onesInCol = new int[width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 1) {
                    onesInRow[i]++;
                    onesInCol[j]++;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 1 && onesInRow[i] == 1 && onesInCol[j] == 1) result++;
            }
        }

        return result;
    }
}
