package MonthlyChallenges.Year24.August;

public class MagicSquaresInGrid {
    public static void main(String[] args) {
        MagicSquaresInGrid solution = new MagicSquaresInGrid();

        int[][] test = {
                {4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}
        };

        System.out.println(solution.numMagicSquaresInside(test));

        int[][] test0 = {
                {4, 3, 8},
                {9, 5, 1},
                {2, 7, 6}
        };
        System.out.println(solution.validSquare(test0, 0, 0));
    }

    /**
     * LeetCode №840. Magic Squares In Grid.
     * <p>
     * Complexity - O(N*M), N = grig.length, M = grid[i].length
     * Memory - O(1)
     *
     * @param grid - a 2d matrix.
     * @return - the total number of magic squares.
     */
    public int numMagicSquaresInside(int[][] grid) {
        int magicSquares = 0;

        int height = grid.length;
        int width = grid[0].length;

        for (int row = 0; row < height - 2; row++) {
            for (int col = 0; col < width - 2; col++) {
                if (validSquare(grid, row, col)) {
                    magicSquares++;
                }
            }
        }

        return magicSquares;
    }

    private boolean validSquare(int[][] grid, int row, int col) {
        boolean[] distinct = new boolean[10];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int curNum = grid[row + r][col + c];
                if (0 == curNum || curNum > 9) return false;
                if (distinct[curNum]) return false;
                distinct[curNum] = true;
            }
        }

        int topDiag = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int botDiag = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];

        if (topDiag != botDiag) return false;

        int topRow = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int midRow = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int botRow = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];

        if (topRow != midRow || midRow != botRow) return false;

        int leftCol = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int midCol = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int rightCol = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];

        if (leftCol != midCol || midCol != rightCol) return false;

        return true;
    }
}
