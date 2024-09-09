package MonthlyChallenges.Year24.September;

import Utils.ListNode;

import java.util.Arrays;

public class SpiralMatrixIV {
    public static void main(String[] args) {
        SpiralMatrixIV solution = new SpiralMatrixIV();

        ListNode test0 = ListNode.getListFromArray(new int[]{3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0});
        int m0 = 3;
        int n0 = 5;
        int[][] result0 = solution.spiralMatrix(m0, n0, test0);
        for (int[] r : result0) {
            System.out.println(Arrays.toString(r));
        }
    }


    /**
     * LeetCode №2326. Spiral Matrix IV.
     * <p>
     * Complexity - O(m*n)
     * Memory - O(1)
     *
     * @param m    -the height of a matrix, a positive integer.
     * @param n    -the width of a matrix, a positive integer.
     * @param head - the head of a linked list.
     * @return -  an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise),
     * starting from the top-left of the matrix. If there are remaining empty spaces, they are filled with -1.
     */
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] row : matrix) Arrays.fill(row, -1);

        int[] directions = {0, 1, 0, -1, 0};
        int row = 0, col = 0, directionIdx = 0;

        while (head != null) {
            for (int c = 0; c < n; c++, head = head.next) {
                if (head == null) return matrix;

                matrix[row][col] = head.val;
                col += directions[directionIdx + 1];
            }
            col -= directions[directionIdx + 1];
            directionIdx = (directionIdx + 1) % 4;
            row += directions[directionIdx];
            m--;

            for (int r = 0; r < m; r++, head = head.next) {
                if (head == null) return matrix;

                matrix[row][col] = head.val;
                row += directions[directionIdx];
            }
            row -= directions[directionIdx];
            directionIdx = (directionIdx + 1) % 4;
            col += directions[directionIdx + 1];
            n--;
        }

        return matrix;
    }
}
