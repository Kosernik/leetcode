package Problems;

public class ReshapeTheMatrix {

    /**
     * LeetCode #566. Reshape the Matrix.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param mat - a 2d array representing a m*n matrix.
     * @param r - the number of rows in new matrix.
     * @param c - the number of columns in new matrix.
     * @return - the reshaped matrix if it is possible and legal, otherwise the original "mat" is returned.
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length* mat[0].length != r*c) return mat;

        int[][] result = new int[r][c];

        int index = 0;

        for (int[] ints : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                result[index / c][index % c] = ints[j];
                index++;
            }
        }

        return result;
    }
}
