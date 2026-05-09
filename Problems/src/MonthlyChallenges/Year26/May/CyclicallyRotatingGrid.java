package MonthlyChallenges.Year26.May;

import java.util.Arrays;

public class CyclicallyRotatingGrid {
    public static void main(String[] args) {
        CyclicallyRotatingGrid solution = new CyclicallyRotatingGrid();

        int[][] grid0 = {
                {40, 10},
                {30, 20}
        };
        int k0 = 1;
        for (int[] r : grid0) System.out.println(Arrays.toString(r));
        System.out.println("-------------");
        int[][] rotated0 = solution.rotateGrid(grid0, k0);
        for (int[] r : rotated0) System.out.println(Arrays.toString(r));

        System.out.println();
        int[][] grid1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int k1 = 2;
        for (int[] r : grid1) System.out.println(Arrays.toString(r));
        System.out.println("-------------");
        int[][] rotated1 = solution.rotateGrid(grid1, k1);
        for (int[] r : rotated1) System.out.println(Arrays.toString(r));

        System.out.println();
        int[][] grid4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int k4 = 11;
        for (int[] r : grid4) System.out.println(Arrays.toString(r));
        System.out.println("-------------");
        int[][] rotated4 = solution.rotateGrid(grid4, k4);
        for (int[] r : rotated4) System.out.println(Arrays.toString(r));
    }

    /**
     * LeetCode №1914. Cyclically Rotating a Grid.
     *
     * @param grid - a 2d matrix of integers. grid height is even and grid width is even.
     * @param k    - the number of cyclic counter-clockwise rotations.
     * @return - grid after k rotations.
     */
    public int[][] rotateGrid(int[][] grid, int k) {
        int leftIdx = 0, rightIdx = grid[0].length - 1;
        int topIdx = 0, bottomIdx = grid.length - 1;

        while (leftIdx < rightIdx && topIdx < bottomIdx) {
            int circleLength = rightIdx - leftIdx + rightIdx - leftIdx + bottomIdx - topIdx + bottomIdx - topIdx;
            int curK = k % circleLength;

            if (curK == 0) {
                leftIdx++;
                rightIdx--;
                topIdx++;
                bottomIdx--;
                continue;
            }

            int[] circleValues = parseCircle(leftIdx, rightIdx, topIdx, bottomIdx, grid);
            writeCircle(circleValues, leftIdx, rightIdx, topIdx, bottomIdx, grid, curK);

            leftIdx++;
            rightIdx--;
            topIdx++;
            bottomIdx--;
        }

        return grid;
    }

    private void writeCircle(int[] values, int leftIdx, int rightIdx, int topIdx, int bottomIdx, int[][] grid, int k) {
        int directionR = 1;
        int directionC = 1;
        int turns = 0;

        for (int i = 0, row = topIdx, col = leftIdx, valIdx = values.length - k; i < values.length; i++, valIdx = (valIdx + 1) % values.length) {
            grid[row][col] = values[valIdx];

            if (turns == 0) {
                row += directionR;

                if (row >= bottomIdx) {
                    turns++;
                    row = bottomIdx;
                    directionR = -1;
                }
            } else if (turns == 1) {
                col += directionC;

                if (col >= rightIdx) {
                    turns++;
                    col = rightIdx;
                    directionC = -1;
                }
            } else if (turns == 2) {
                row += directionR;

                if (row <= topIdx) {
                    turns++;
                    row = topIdx;
                }
            } else {
                col += directionR;
            }
        }
    }

    private int[] parseCircle(int leftIdx, int rightIdx, int topIdx, int bottomIdx, int[][] grid) {
        int circleLength = rightIdx - leftIdx + rightIdx - leftIdx + bottomIdx - topIdx + bottomIdx - topIdx;
        int[] result = new int[circleLength];

        int directionR = 1;
        int directionC = 1;
        int turns = 0;
        for (int i = 0, row = topIdx, col = leftIdx; i < circleLength; i++) {
            result[i] = grid[row][col];

            if (turns == 0) {
                row += directionR;

                if (row >= bottomIdx) {
                    turns++;
                    row = bottomIdx;
                    directionR = -1;
                }
            } else if (turns == 1) {
                col += directionC;

                if (col >= rightIdx) {
                    turns++;
                    col = rightIdx;
                    directionC = -1;
                }
            } else if (turns == 2) {
                row += directionR;

                if (row <= topIdx) {
                    turns++;
                    row = topIdx;
                }
            } else {
                col += directionR;
            }
        }

        return result;
    }
}
