package MonthlyChallenges.Year26.March;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSumGridPartitionII {
    public static void main(String[] args) {
        EqualSumGridPartitionII solution = new EqualSumGridPartitionII();

        int[][] grid0 = {{10, 5, 4, 5}};
        boolean result0 = false;
        System.out.println(solution.canPartitionGrid(grid0) == result0);
    }

    /**
     * LeetCode №3548. Equal Sum Grid Partition II.
     * <p>
     * Complexity - O(N*M), N = grid.length, M = grid[i].length.
     * Memory - O(N*M)
     *
     * @param grid - a 2d matrix of positive integers.
     * @return - true if there exists a partition (vertical of horizontal) of a matrix into two sections where the sum
     * of the elements in both sections is equal, or can be made equal by discounting at most one single cell in total
     * (from either section). If a cell is discounted, the rest of the section must remain connected. False - otherwise.
     */
    public boolean canPartitionGrid(int[][] grid) {
        int height = grid.length, width = grid[0].length;

        long[] rowSums = new long[height];
        long[] colSums = new long[width];

        Map<Long, List<int[]>> coordinates = new HashMap<>();
        List<int[]> EMPTY = new ArrayList<>();

        for (int col = 0; col < width; col++) {
            long number = grid[0][col];

            rowSums[0] += number;
            colSums[col] += number;

            if (!coordinates.containsKey(number)) {
                coordinates.put(number, new ArrayList<>());
            }
            coordinates.get(number).add(new int[]{0, col});
        }

        for (int row = 1; row < height; row++) {
            rowSums[row] += rowSums[row - 1];

            for (int col = 0; col < width; col++) {
                long number = grid[row][col];

                rowSums[row] += number;
                colSums[col] += number;

                if (!coordinates.containsKey(number)) {
                    coordinates.put(number, new ArrayList<>());
                }
                coordinates.get(number).add(new int[]{row, col});
            }
        }

        long totalSum = rowSums[height - 1];

        for (int splitIdx = 0; splitIdx < height - 1; splitIdx++) {
            long topSum = rowSums[splitIdx];
            long bottomSum = totalSum - topSum;

            if (topSum == bottomSum) {
                return true;
            }

            long diff = Math.abs(topSum - bottomSum);

            int heightTop = splitIdx + 1;
            int heightBot = height - heightTop;

            for (int[] coordinate : coordinates.getOrDefault(diff, EMPTY)) {
                int row = coordinate[0];
                int col = coordinate[1];

                if (topSum > bottomSum && (row <= splitIdx && (heightTop > 1 || (col == 0 || col == (width - 1))))) {
                    if (width > 1 || (row == 0 || row == splitIdx)) {
                        return true;
                    }
                } else if (topSum < bottomSum) {
                    if (row > splitIdx && (heightBot > 1 || (col == 0 || col == (width - 1)))) {
                        if (width > 1 || (row == (splitIdx + 1) || row == (height - 1))) {
                            return true;
                        }
                    }
                }
            }
        }

        for (int splitIdx = 0; splitIdx < width - 1; splitIdx++) {
            long leftSum = colSums[splitIdx];
            long rightSum = totalSum - leftSum;

            if (leftSum == rightSum) {
                return true;
            }

            long diff = Math.abs(leftSum - rightSum);

            int widthLeft = splitIdx + 1;
            int widthRight = width - widthLeft;

            for (int[] coordinate : coordinates.getOrDefault(diff, EMPTY)) {
                int row = coordinate[0];
                int col = coordinate[1];

                if (leftSum > rightSum && (col <= splitIdx && (widthLeft > 1 || (row == 0 || row == (height - 1))))) {
                    if (height > 1 || (col == 0 || col == splitIdx)) {
                        return true;
                    }
                } else if (leftSum < rightSum) {
                    if (col > splitIdx && (widthRight > 1 || (row == 0 || row == (height - 1)))) {
                        if (height > 1 || (col == (splitIdx + 1) || col == (width - 1))) {
                            return true;
                        }
                    }
                }
            }

            colSums[splitIdx + 1] += colSums[splitIdx];
        }

        return false;
    }
}
