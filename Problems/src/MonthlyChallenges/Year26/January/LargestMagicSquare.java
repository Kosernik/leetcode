package MonthlyChallenges.Year26.January;

public class LargestMagicSquare {
    public static void main(String[] args) {
        LargestMagicSquare solution = new LargestMagicSquare();

        int[][] grid0 = {
                {7, 1, 4, 5, 6},
                {2, 5, 1, 6, 4},
                {1, 5, 4, 3, 2},
                {1, 2, 7, 3, 4}
        };
        int result0 = 3;
        System.out.println(solution.largestMagicSquare(grid0) == result0);
    }

    /**
     * LeetCode №1895. Largest Magic Square.
     *
     * @param grid - a rectangle array of integers.
     * @return - the size of the largest magic square.
     */
    public int largestMagicSquare(int[][] grid) {
        int height = grid.length, width = grid[0].length;

        //  preSums[r][c][0] - horizontal prefix sums
        //  preSums[r][c][1] - vertical prefix sums
        //  preSums[r][c][2] - top-left to bottom-right diagonal prefix sums
        //  preSums[r][c][3] = top-right to bottom-left diagonal prefix sums
        int[][][] preSums = new int[height + 1][width + 2][4];

        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= width; col++) {
                int curNumber = grid[row - 1][col - 1];

                //  Horizontal
                preSums[row][col][0] = preSums[row][col - 1][0] + curNumber;
                //  Vertical
                preSums[row][col][1] = preSums[row - 1][col][1] + curNumber;
                //  Diagonal top-left to bottom-right
                preSums[row][col][2] = preSums[row - 1][col - 1][2] + curNumber;
                //  Diagonal top-right to bottom-left
                preSums[row][col][3] = preSums[row - 1][col + 1][3] + curNumber;
            }
        }

        for (int length = Math.min(height, width); length > 1; length--) {
            if (hasMagicSquare(length, preSums)) return length;
        }

        return 1;
    }

    private boolean hasMagicSquare(int length, int[][][] preSums) {
        for (int row = 1; row + length <= preSums.length; row++) {
            for (int col = 1; col + length <= (preSums[0].length - 1); col++) {
                if (isSquareMagic(length, row, col, preSums)) return true;
            }
        }

        return false;
    }

    private boolean isSquareMagic(int length, int row, int column, int[][][] preSums) {
        int sum = preSums[row + length - 1][column][3] - preSums[row - 1][column + length][3];

        for (int r = 0; r < length; r++) {
            if ((preSums[row + r][column + length - 1][0] - preSums[row + r][column - 1][0]) != sum) return false;
        }
        for (int c = 0; c < length; c++) {
            if ((preSums[row + length - 1][column + c][1] - preSums[row - 1][column + c][1]) != sum) return false;
        }

        if ((preSums[row + length - 1][column + length - 1][2] - preSums[row - 1][column - 1][2]) != sum) return false;

        return true;
    }
}
