package MonthlyChallenges.Year24.July;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInMatrix {
    public static void main(String[] args) {
        LuckyNumbersInMatrix solution = new LuckyNumbersInMatrix();

        int[][] test0 = {
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        };
        System.out.println(solution.luckyNumbers(test0));
    }

    /**
     * LeetCode №1380. Lucky Numbers in a Matrix.
     * <p>
     * Complexity - O(N*M), N = height of a matrix, M = width of a matrix.
     * Memory - O(N).
     * <p>
     * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its
     * column.
     *
     * @param matrix - a matrix of distinct numbers.
     * @return - a list of all lucky numbers.
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> numbers = new ArrayList<>();

        int[] minIdx = new int[matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            int min = 0;
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] < matrix[row][min]) {
                    min = col;
                }
            }
            minIdx[row] = min;
        }

        for (int col = 0; col < matrix[0].length; col++) {
            int maxIdx = 0;
            for (int row = 1; row < matrix.length; row++) {
                if (matrix[row][col] > matrix[maxIdx][col]) {
                    maxIdx = row;
                }
            }

            if (minIdx[maxIdx] == col) {
                numbers.add(matrix[maxIdx][col]);
            }
        }

        return numbers;
    }
}
