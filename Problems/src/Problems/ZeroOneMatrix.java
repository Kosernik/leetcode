package Problems;

import java.util.*;

public class ZeroOneMatrix {

    /**
     * LeetCode #542. 01 Matrix.
     *
     * Complexity - O(M*N), M - mat.length, N - mat[0].length.
     * Memory - O(M*N)
     *
     * @param mat - a M*N matrix of 0 and 1.
     * @return - the matrix with the distance of the nearest 0 for each cell.
     */
    public int[][] updateMatrix(int[][] mat) {
        int length = mat.length;
        int width = mat[0].length;
        int[][] updated = new int[length][width];
        for (int i = 0; i < length; i++) {
            Arrays.fill(updated[i], 20_001);
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 0) {
                    updated[i][j] = 0;
                } else {
                    if (i > 0) {
                        updated[i][j] = Math.min(updated[i][j], updated[i-1][j] + 1);
                    }
                    if (j > 0) {
                        updated[i][j] = Math.min(updated[i][j], updated[i][j-1] + 1);
                    }
                }
            }
        }

        for (int i = length-1; i >= 0; i--) {
            for (int j = width-1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    if (i+1 < length) {
                        updated[i][j] = Math.min(updated[i][j], updated[i+1][j] + 1);
                    }
                    if (j+1 < width) {
                        updated[i][j] = Math.min(updated[i][j], updated[i][j+1] + 1);
                    }
                }
            }
        }

        return updated;
    }
}
