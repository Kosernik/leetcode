package MonthlyChallenges.Year22.June;

public class TransposeMatrix {

    /**
     * LeetCode 867. Transpose Matrix.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param matrix - a 2d matrix.
     * @return - transposed input matrix.
     */
    public int[][] transpose(int[][] matrix) {
        int length = matrix.length;
        int width = matrix[0].length;

        int[][] result = new int[width][length];

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                result[col][row] = matrix[row][col];
            }
        }

        return result;
    }
}
