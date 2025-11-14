package MonthlyChallenges.Year25.November;

public class IncrementSubmatricesByOne {

    /**
     * LeetCode №2536. Increment Submatrices by One.
     * <p>
     * Complexity - O(N), N = n*n
     * Memory - O(1)
     *
     * @param n       - the height and the width of the resulting matrix.
     * @param queries - an array of queries where query[i] = [row1-i, col1-i, row2-i, col2-i] represents coordinates of
     *                a rectangle. Values at each cell in this rectangle is incremented by 1.
     * @return - the matrix result of size n*n after performing every query.
     */
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] result = new int[n][n];

        for (int[] query : queries) {
            int startRow = query[0], startCol = query[1];
            int endRow = query[2], endCol = query[3] + 1;

            for (int row = startRow; row <= endRow; row++) {
                result[row][startCol]++;
                if (endCol < n) result[row][endCol]--;
            }
        }

        for (int r = 0; r < n; r++) {
            int number = 0;
            for (int c = 0; c < n; c++) {
                number += result[r][c];
                result[r][c] = number;
            }
        }

        return result;
    }
}
