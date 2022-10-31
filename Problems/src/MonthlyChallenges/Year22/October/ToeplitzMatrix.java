package MonthlyChallenges.Year22.October;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        ToeplitzMatrix solution = new ToeplitzMatrix();

        int[][] test0 = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}};

        System.out.println(solution.isToeplitzMatrix(test0));
    }

    /**
     * LeetCode #766. Toeplitz Matrix.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param matrix - an array of integers.
     * @return - True - if every diagonal from top-left to bottom-right has the same elements. False - otherwise.
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < (width - 1); i++) {
            if (!isValidDiagonal(0, i, matrix)) return false;
        }

        for (int i = 1; i < (height - 1); i++) {
            if (!isValidDiagonal(i, 0, matrix)) return false;
        }

        return true;
    }

    private boolean isValidDiagonal(int row, int col, int[][] matrix) {
        int value = matrix[row++][col++];

        while (row < matrix.length && col < matrix[0].length) {
            if (matrix[row][col] != value) return false;
            row++;
            col++;
        }
        return true;
    }
}
