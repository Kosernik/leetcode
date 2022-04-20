package ExploreCards.TopInterviewQuestionsHard;

public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
        LongestIncreasingPathInMatrix solution = new LongestIncreasingPathInMatrix();

        int[][] test0 = {{9,9,4},{6,6,8},{2,1,1}};

        System.out.println(solution.longestIncreasingPath(test0));
    }
    private int[][] computed;
    int[] neighbours = {0,1,0,-1,0};

    /**
     * LeetCode #329. Longest Increasing Path in a Matrix.
     *
     * Complexity - O(N*M), N = matrix.length, M = matrix[i].length.
     * Memory - O(N*M)
     *
     * @param matrix - a 2d square array of non-negative integers.
     * @return - the length of the longest increasing path in matrix. Only vertical and horizontal moves are allowed.
     */
    public int longestIncreasingPath(int[][] matrix) {
        computed = new int[matrix.length][matrix[0].length];

        int result = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                result = Math.max(result, dfs(row, col, matrix));
            }
        }

        return result;
    }

    private int dfs(int row, int column, int[][] matrix) {
        if (computed[row][column] != 0) return computed[row][column];
        int result = 0;

        for (int i = 0; i < neighbours.length-1; i++) {
            int neighRow = row + neighbours[i];
            int neighCol = column + neighbours[i+1];

            if (0 <= neighRow && neighRow < matrix.length &&
                    0 <= neighCol && neighCol < matrix[0].length &&
                    matrix[neighRow][neighCol] < matrix[row][column]) {

                result = Math.max(result, dfs(neighRow, neighCol, matrix));
            }
        }

        result += 1;
        computed[row][column] = result;
        return result;
    }
}
