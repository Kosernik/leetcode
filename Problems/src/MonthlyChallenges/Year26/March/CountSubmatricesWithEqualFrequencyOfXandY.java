package MonthlyChallenges.Year26.March;

public class CountSubmatricesWithEqualFrequencyOfXandY {

    /**
     * LeetCode №3212. Count Submatrices With Equal Frequency of X and Y.
     * <p>
     * Complexity - O(N*M), N = grid.length, M = grid[i].length
     * Memory - O(M)
     *
     * @param grid - a 2d matrix of 'X', 'Y' and '.'.
     * @return - the number of submatrices that contain:
     * * grid[0][0],
     * * an equal frequency of 'X' and 'Y',
     * * at least one 'X'.
     */
    public int numberOfSubmatrices(char[][] grid) {
        int totalCount = 0;

        int width = grid[0].length;
        int[][] prevRowsCounts = new int[width][2];

        for (char[] row : grid) {
            int curRowX = 0, curRowY = 0;

            for (int col = 0; col < width; col++) {
                if (row[col] == 'X') {
                    curRowX++;
                } else if (row[col] == 'Y') {
                    curRowY++;
                }

                prevRowsCounts[col][0] += curRowX;
                prevRowsCounts[col][1] += curRowY;

                if (prevRowsCounts[col][0] > 0 && prevRowsCounts[col][0] == prevRowsCounts[col][1]) {
                    totalCount++;
                }
            }
        }

        return totalCount;
    }
}
