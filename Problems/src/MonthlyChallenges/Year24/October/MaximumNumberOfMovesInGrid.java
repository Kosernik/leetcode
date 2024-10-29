package MonthlyChallenges.Year24.October;

import java.util.Arrays;

public class MaximumNumberOfMovesInGrid {
    public static void main(String[] args) {
        MaximumNumberOfMovesInGrid solution = new MaximumNumberOfMovesInGrid();

        int[][] test = {
                {3, 2, 4},
                {2, 2, 9},
                {1, 1, 7}
        };
        System.out.println(solution.maxMoves(test) == 2);

        int[][] test9 = {
                {1, 9, 9, 9},
                {9, 9, 9, 9},
                {9, 2, 9, 9},
                {9, 9, 9, 9},
                {9, 9, 3, 9}
        };
        System.out.println(solution.maxMoves(test9) == 1);
    }

    /**
     * LeetCode №2684. Maximum Number of Moves in a Grid.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param grid - a 2d array of positive integers.
     * @return - the maximum number of moves that you can perform.
     */
    public int maxMoves(int[][] grid) {
        int[][] flipped = new int[grid[0].length][grid.length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                flipped[col][row] = grid[row][col];
            }
        }

        return maxMovesFlipped(flipped);
    }

    private int maxMovesFlipped(int[][] grid) {
        int maxMoves = 0;

        int height = grid.length;
        int width = grid[0].length;

        int[] moves = new int[width];
        Arrays.fill(moves, 1);

        int[] prevRow = grid[0];

        for (int row = 1; row < height; row++) {
            int[] curRowMoves = new int[width];

            for (int col = 0; col < width; col++) {
                int bestMove = 0;

                if (col > 0 && grid[row][col] > prevRow[col - 1] && moves[col - 1] > 0) {
                    bestMove = Math.max(bestMove, moves[col - 1] + 1);
                }
                if (grid[row][col] > prevRow[col] && moves[col] > 0) {
                    bestMove = Math.max(bestMove, moves[col] + 1);
                }
                if ((col + 1) < width && grid[row][col] > prevRow[col + 1] && moves[col + 1] > 0) {
                    bestMove = Math.max(bestMove, moves[col + 1] + 1);
                }

                curRowMoves[col] = bestMove;
                maxMoves = Math.max(maxMoves, curRowMoves[col]);
            }

            moves = curRowMoves;
            prevRow = grid[row];
        }

        return Math.max(0, maxMoves - 1);
    }
}
