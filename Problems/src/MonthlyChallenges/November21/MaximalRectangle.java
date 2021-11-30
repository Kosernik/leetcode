package MonthlyChallenges.November21;

public class MaximalRectangle {
    public static void main(String[] args) {
        MaximalRectangle solution = new MaximalRectangle();

        //  [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        char[][] test0 = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};

        System.out.println(solution.maximalRectangle(test0));
    }

    /**
     * LeetCode #85. Maximal Rectangle.
     *
     * Complexity - O(N^2)
     * Memory - O(N)
     *
     * @param matrix - a m*n matrix of characters '0' and '1'.
     * @return - the area o the largest rectangle containing only '1'`s.
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        else if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == '0' ? 0 : 1;

        int length = matrix.length;
        int width = matrix[0].length;

        // dpArray[i][j][0] - the number of 1-s in vertical direction
        // dpArray[i][j][1] - the number of 1-s in horizontal direction
        int[][][] dpArray = new int[length+1][width+1][2];

        for (int i = 1; i < length+1; i++) {
            for (int j = 1; j < width+1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dpArray[i][j][0] = dpArray[i-1][j][0] + 1;
                    dpArray[i][j][1] = dpArray[i][j-1][1] + 1;
                } else {
                    dpArray[i][j][0] = 0;
                    dpArray[i][j][1] = 0;
                }
            }
        }

        int maxArea = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '0') continue;

                int height = dpArray[i+1][j+1][0];

                for (int w = 1; w <= dpArray[i+1][j+1][1]; w++) {
                    height = Math.min(height, dpArray[i+1][j+1 - w+1][0]);
                    maxArea = Math.max(maxArea, height*w);
                }
            }
        }

        return maxArea;
    }
}
