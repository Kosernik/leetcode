package MonthlyChallenges.Year25.January;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowOrColumn {

    /**
     * LeetCode №2661. First Completely Painted Row or Column.
     * <p>
     * Complexity - O(N*M), N = height of a matrix, M = width of a matrix.
     * Memory - (N+M)
     *
     * @param arr - an array of all the integers in the range [1, arr.length].
     * @param mat - a 2d array of all the integers in the range [1, M*N]. M*N = arr.length.
     * @return - the smallest index i at which either a row or a column will be completely painted in mat.
     */
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int height = mat.length, width = mat[0].length;

        int[] visitedCellsOnRow = new int[height];
        int[] visitedCellOnColumn = new int[width];

        //  cell`s value -> [row, column]
        Map<Integer, int[]> coordinates = new HashMap<>();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                coordinates.put(mat[row][col], new int[]{row, col});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];

            int[] coordinate = coordinates.get(value);
            visitedCellsOnRow[coordinate[0]]++;
            visitedCellOnColumn[coordinate[1]]++;

            if (visitedCellsOnRow[coordinate[0]] == width || visitedCellOnColumn[coordinate[1]] == height) {
                return i;
            }
        }

        return arr.length - 1;
    }
}
