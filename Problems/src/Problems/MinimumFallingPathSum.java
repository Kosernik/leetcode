package Problems;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        MinimumFallingPathSum solution = new MinimumFallingPathSum();

        int[][] test0 = {
                {2,1,3},
                {6,5,4},
                {7,8,9}
        };

        System.out.println(solution.minFallingPathSum(test0));
    }

    /**
     * LeetCode #931. Minimum Falling Path Sum.
     *
     * Complexity - O(N*M), N = matrix.length, M = matrix[0].length.
     * Memory - O(1)
     *
     * @param matrix - a 2d square array.
     * @return - the minimum sum of any falling path through matrix.
     */
    public int minFallingPathSum(int[][] matrix) {
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int leftIdx = Math.max(col-1, 0);
                int rightIdx = Math.min(col+1, matrix[0].length-1);

                matrix[row][col] += Math.min(Math.min(matrix[row-1][leftIdx], matrix[row-1][rightIdx]), matrix[row-1][col]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int cost : matrix[matrix.length-1]) result = Math.min(result, cost);
        return result;
    }
}
