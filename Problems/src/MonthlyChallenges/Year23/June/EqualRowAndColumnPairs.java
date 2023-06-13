package MonthlyChallenges.Year23.June;

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {

    /**
     * LeetCode #2352. Equal Row and Column Pairs.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param grid - a square matrix.
     * @return - the number of pairs (r, c) such that row 'r' equals column 'c'.
     */
    public int equalPairs(int[][] grid) {
        int size = grid.length;
        Map<String, Integer> rows = new HashMap<>();

        for (int[] row : grid) {
            StringBuilder rowStr = new StringBuilder();
            for (int number : row) {
                rowStr.append(number);
                rowStr.append("*");
            }

            String curRowStr = rowStr.toString();
            rows.put(curRowStr, rows.getOrDefault(curRowStr, 0) + 1);
        }

        int numberOfEqualPairs = 0;

        for (int i = 0; i < size; i++) {
            StringBuilder col = new StringBuilder();
            for (int[] ints : grid) {
                col.append(ints[i]);
                col.append("*");
            }

            String colStr = col.toString();
            numberOfEqualPairs += rows.getOrDefault(colStr, 0);
        }

        return numberOfEqualPairs;
    }
}
