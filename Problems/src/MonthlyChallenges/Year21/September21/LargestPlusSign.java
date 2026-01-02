package MonthlyChallenges.Year21.September21;

import java.util.Arrays;

public class LargestPlusSign {
    public static void main(String[] args) {
        LargestPlusSign solution = new LargestPlusSign();

        int[][] test0 = {{4, 2}};
        System.out.println(solution.orderOfLargestPlusSign(5, test0));
    }


    /**
     * LeetCode #764. Largest Plus Sign.
     * <p>
     * Complexity - O(N^2)
     * Memory - O(N^2)
     *
     * @param n     - the size of a grid.
     * @param mines - an array of coordinates of mines.
     * @return - the length of the side of the largest "plus sign" on the grid.
     */
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (n == 1) return 0;

        // [][][0] - up
        // [][][1] - left
        // [][][2] - down
        // [][][3] - right
        int[][][] preSums = new int[n][n][4];

        for (int[] mine : mines) {
            Arrays.fill(preSums[mine[0]][mine[1]], -1);
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (preSums[row][col][0] != -1) {
                    int prev;
                    if ((row - 1) >= 0 && preSums[row - 1][col][0] != -1) {
                        prev = preSums[row - 1][col][0];
                    } else {
                        prev = 0;
                    }
                    preSums[row][col][0] = prev + 1;
                }
                if (preSums[row][col][1] != -1) {
                    int prev;
                    if ((col - 1) >= 0 && preSums[row][col - 1][1] != -1) {
                        prev = preSums[row][col - 1][1];
                    } else {
                        prev = 0;
                    }
                    preSums[row][col][1] = prev + 1;
                }
            }
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (preSums[row][col][2] != -1) {
                    int prev;
                    if ((row + 1) < n && preSums[row + 1][col][2] != -1) {
                        prev = preSums[row + 1][col][2];
                    } else {
                        prev = 0;
                    }
                    preSums[row][col][2] = prev + 1;
                }
                if (preSums[row][col][3] != -1) {
                    int prev;
                    if ((col + 1) < n && preSums[row][col + 1][3] != -1) {
                        prev = preSums[row][col + 1][3];
                    } else {
                        prev = 0;
                    }
                    preSums[row][col][3] = prev + 1;
                }
            }
        }

        int largestPlus = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (preSums[row][col][0] == -1) continue;
                int curRes = Math.min(
                        Math.min(preSums[row][col][0], preSums[row][col][1]),
                        Math.min(preSums[row][col][2], preSums[row][col][3]));
                largestPlus = Math.max(largestPlus, curRes);
            }
        }

        return largestPlus;
    }
}
