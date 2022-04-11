package MonthlyChallenges.Year22.April;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public static void main(String[] args) {
        Shift2DGrid solution = new Shift2DGrid();

        int[][] test0 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        int[][] test1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };

        int[][] test2 = {
                {1,2,3,4}
        };

        int[][] test3 = {
                {1},
                {2},
                {3},
                {4}
        };

        int[][] test4 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][][] tests = new int[5][][];
        tests[0] = test0;
        tests[1] = test1;
        tests[2] = test2;
        tests[3] = test3;
        tests[4] = test4;

        for (int[][] test : tests) {
            List<List<Integer>> curResult = solution.shiftGrid(test, 2);

            for (List<Integer> row : curResult) {
                System.out.println(row);
            }

            System.out.println("----------");
        }
    }

    /**
     * LeetCode #1260. Shift 2D Grid.
     *
     * Complexity - O(N), N = grid.length * grid[0].length
     * Memory - O(N)
     *
     * @param grid - a 2d square matrix of integers.
     * @param k - an integer.
     * @return - the grid after shifting k-times.
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int height = grid.length;
        int width = grid[0].length;
        int length = height * width;

        int[] flatGrid = flattenGrid(grid);
        int numberOfLoops = gcd(length, k);

        shiftFlatGrid(flatGrid, k, numberOfLoops);

        List<List<Integer>> result = new ArrayList<>();
        int idx = 0;

        for (int i = 0; i < height; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add(flatGrid[idx++]);
            }
            result.add(row);
        }

        return result;
    }

    private void shiftFlatGrid(int[] flatGrid, int k, int numberOfLoops) {
        if (k > flatGrid.length) k = k % flatGrid.length;
        if (k == 0) return;

        int lengthOfLoop = flatGrid.length/numberOfLoops;
        for (int i = 0; i < numberOfLoops; i++) {
            int temp = flatGrid[i];
            int idx = (i+k) % flatGrid.length;

            for (int j = 0; j < lengthOfLoop; j++) {
                int curTemp = flatGrid[idx];
                flatGrid[idx] = temp;
                temp = curTemp;

                idx = (idx + k) % flatGrid.length;
            }
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int[] flattenGrid(int[][] grid) {
        int[] flatGrid = new int[grid.length * grid[0].length];

        int idx = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                flatGrid[idx++] = cell;
            }
        }

        return flatGrid;
    }
}
